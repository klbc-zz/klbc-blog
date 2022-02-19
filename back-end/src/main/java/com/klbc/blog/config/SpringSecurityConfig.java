package com.klbc.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * security 配置类
 *
 * @author klbc
 */
 @EnableWebSecurity
 public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
  private List<String> url = Arrays.asList("/edit");

//  @Bean
//  public UserDetailsService userDetailsService() {
//    InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//    inMemoryUserDetailsManager.createUser(
//        User.withUsername("noodzhan")
//            .password("19970717.cf")
//            .authorities(Collections.emptyList())
//            .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
//            .build());
//    return inMemoryUserDetailsManager;
//  }
  @Bean
  BCryptPasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
      //后台关闭csrf校验 不然post请求会抱403
      http.csrf().disable();
    //http.authorizeRequests().antMatchers("/api/blog/edit/*").authenticated();
  }



/* 用于测试
    public static void main(String[] args) {
        String password = "123456";
        String password2 = "1234567";
        String password3 = "123456";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String password4 = encoder.encode(password);
        System.out.println("password: "+password4);
        System.out.println(encoder.matches(password2,password4));
        System.out.println(encoder.matches(password3,password4));

    }
*/

 }
