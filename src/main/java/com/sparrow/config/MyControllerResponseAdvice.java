package com.sparrow.config;

import com.sparrow.spring.starter.advice.ControllerResponseAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 功能描述:AOP拦截所有Controller
 */
@RestControllerAdvice(basePackages =
        {"com.sparrow.article.controller",
                "com.sparrow.cms.controller"})
public class MyControllerResponseAdvice extends ControllerResponseAdvice {
}
