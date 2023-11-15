package com.sparrow.config;

import com.sparrow.spring.starter.SpringServletContainer;
import com.sparrow.spring.starter.filter.ClientInformationFilter;
import com.sparrow.support.IpSupport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.inject.Inject;
import java.util.List;

public class MvcConfigurationAdapter extends WebMvcConfigurationSupport {


    @Value("${mock_login_user}")
    private Boolean mockUser;

    @Inject
    private IpSupport ipSupport;

    @Value("${authenticator.white.list}")
    private List<String> whiteList;

    @Inject
    private SpringServletContainer springServletContainer;


    @Bean
    public ClientInformationFilter clientInformationFilter() {
        return new ClientInformationFilter(-98, this.springServletContainer);
    }
}
