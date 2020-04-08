package com.zqz.config;

import com.zqz.intercepter.RoteLimitIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-08 23:20
 * @changeRecord
 */
@Configuration
public class AppMvcConfig implements WebMvcConfigurer {

    @Resource
    private RoteLimitIntercepter roteLimitIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(roteLimitIntercepter);
    }
}
