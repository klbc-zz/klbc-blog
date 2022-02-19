package com.klbc.blog.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  @author klbc
 */
//@SpringBootConfiguration
//public class MyWebConfigurer implements WebMvcConfigurer {
////    //拦截器省略
//private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
//        "classpath:/META-INF/resources/", "classpath:/resources/",
//        "classpath:/static/", "classpath:/public/" };
//
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        if (!registry.hasMappingForPattern("/**")) {
//            registry.addResourceHandler("/**").addResourceLocations(
//                    "classpath:/META-INF/resources/");
//        }
//        if (!registry.hasMappingForPattern("/**")) {
//            registry.addResourceHandler("/**").addResourceLocations(
//                    CLASSPATH_RESOURCE_LOCATIONS);
//        }
//
//    }
//
//}
