package com.sparrow.config;

import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.ThreadContext;
import com.sparrow.protocol.constant.Constant;
import com.sparrow.support.web.CookieUtility;
import com.sparrow.support.web.ServletUtility;
import com.sparrow.utility.StringUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class MonolithicLoginUserFilter implements Filter {
    /**
     * logback log4j的作者写的
     * 酸辣粉 基本上是java 领域关于的工业级标准
     */
    private Logger logger = LoggerFactory.getLogger(MonolithicLoginUserFilter.class);
    /**
     * 支持mock 用户对象
     */
    private Boolean mockLoginUser;
    /**
     * 白名单
     */
    private List<String> whiteList;

    private Authenticator authenticator;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /**
         * 1. 根据用户的token 解析当前登录用户并写到threadlocal 中
         * 2. 需要提供loginUser的上下文工具类
         * 3. 需要提供可扩展的auth接口
         */
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            String currentUrl = req.getServletPath();
            //todo 设备的指纹
            String ip = ServletUtility.getInstance().getClientIp(req);
            if (this.whiteList.contains(currentUrl)) {
                //直接return 行不行？
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            String loginToken = req.getHeader(Constant.REQUEST_HEADER_KEY_LOGIN_TOKEN);
            LoginUser loginUser = null;
            if (StringUtility.isNullOrEmpty(loginToken)) {
                loginToken = CookieUtility.getPermission(req);
            }

            if (StringUtility.isNullOrEmpty(loginToken)) {
                if (mockLoginUser) {
                    loginUser = LoginUser.create(1L, "mock-user",
                            "mock-nick-name",
                            "avatar", "127.0.0.1", 3);
                } else {
                    //todo 提示登录
                }
            } else {
                //loginToken
                //我能在这里做认证吗？肯定不行啊!不具扩展性！
                loginUser = this.authenticator.authenticate(loginToken, ip);
            }
            ThreadContext.bindLoginToken(loginUser);
            filterChain.doFilter(servletRequest, servletResponse);
            ThreadContext.clearToken();
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
