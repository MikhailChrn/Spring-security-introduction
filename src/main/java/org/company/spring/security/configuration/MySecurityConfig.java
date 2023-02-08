package org.company.spring.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication().withUser(userBuilder.username("Ivan").password("Ivan").roles("EMPLOYEE"));
        auth.inMemoryAuthentication().withUser(userBuilder.username("Elena").password("Elena").roles("HR"));
        auth.inMemoryAuthentication().withUser(userBuilder.username("Mikhail").password("Mikhail").roles("MANAGER", "HR"));
    }
}
