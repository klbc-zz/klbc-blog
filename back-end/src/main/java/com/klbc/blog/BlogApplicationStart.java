package com.klbc.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 博客系统后台
 *
 * @author klbc
 */
@SpringBootApplication
@MapperScan("com.klbc.blog.mapper")
public class BlogApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplicationStart.class,args);

    }
}
