package com.example.role.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication().withUser("user").password("{noop}123456").roles("USER");
        authenticationManagerBuilder.inMemoryAuthentication().withUser("admin").password("{noop}123456").roles("ADMIN");
        authenticationManagerBuilder.inMemoryAuthentication().withUser("dba").password("{noop}123456").roles("ADMIN","DBA");
    }
}
