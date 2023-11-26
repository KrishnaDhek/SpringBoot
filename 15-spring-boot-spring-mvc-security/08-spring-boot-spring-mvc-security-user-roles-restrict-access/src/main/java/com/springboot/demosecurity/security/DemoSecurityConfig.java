package com.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    // Configure in-memory user details manager with three users: john, mary, and susan.
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")//Use {noop} to indicate plain text password (for demo purposes).
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }


    // Configure the security filter chain with specific rules.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
        http.authorizeHttpRequests(configurer ->
                configurer

                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems").hasRole("ADMIN")
                        //Require authentication for any request.
                        .anyRequest().authenticated())


                .formLogin(form ->
                        form
                                // Specify the custom login page.
                                .loginPage("/showLoginPage")
                                //no controller request mapping required for this
                                // URL for processing login.
                                .loginProcessingUrl("/authenticateTheUser")
                                // Allow all users to access the login page.

                                .permitAll()
                )
                .logout(logout ->
                        logout.permitAll()
                )
                .exceptionHandling(configurer->
                        configurer.accessDeniedPage("/access-denied")
                );

        return http.build();

    }
}
