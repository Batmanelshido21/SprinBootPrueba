package com.example.ConectionBD.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("admin")
                    .password("{noop}123")
                    .roles("ADMIN","USER")
                .and()
                .withUser("user")
                    .password("{noop}123")
                    .roles("USER")
                ;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.httpBasic()
        .and()
        .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/usuario/**")
                    .hasRole("ADMIN")
                    .and()
                    .formLogin().permitAll()
                    .and()
                    .csrf().disable()
                    .logout().permitAll();
    }
}