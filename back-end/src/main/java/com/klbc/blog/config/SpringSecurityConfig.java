package com.klbc.blog.config;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * security 配置类
 *
 * @author klbc
 */
// @EnableWebSecurity
// public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//  private List<String> url = Arrays.asList("/edit");
//
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
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.authorizeRequests().antMatchers("/api/blog/edit/*").authenticated();
//  }
// }
