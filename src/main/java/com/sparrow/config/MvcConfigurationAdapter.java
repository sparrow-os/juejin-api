package com.sparrow.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * extends WebMvcConfigurationSupport 慎用，会将可默认的WebMvcAutoConfiguration  覆盖
 */
@Configuration
public class MvcConfigurationAdapter extends WebMvcConfigurationSupport {

}
