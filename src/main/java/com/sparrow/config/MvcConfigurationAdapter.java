package com.sparrow.config;

import com.sparrow.constant.Config;
import com.sparrow.protocol.constant.Constant;
import com.sparrow.support.Authenticator;
import com.sparrow.support.IpSupport;
import com.sparrow.support.web.MonolithicLoginUserFilter;
import com.sparrow.utility.ConfigUtility;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.inject.Inject;
import java.util.List;

@Configuration
public class MvcConfigurationAdapter implements WebMvcConfigurer {

    @Value("${sparrow.mock_login_user}")
    private Boolean mockUser;
    @Inject
    private IpSupport ipSupport;

    @Value("${sparrow.authenticator.white.list}")
    private List<String> whiteList;

    @Value("sparrow.request_header_key_login_token")
    private String tokenKey;
    @Inject
    private Authenticator authenticator;

    @Bean
    MonolithicLoginUserFilter loginTokenFilter() {
        return new MonolithicLoginUserFilter(authenticator, this.mockUser, this.whiteList, this.tokenKey);
    }
}
