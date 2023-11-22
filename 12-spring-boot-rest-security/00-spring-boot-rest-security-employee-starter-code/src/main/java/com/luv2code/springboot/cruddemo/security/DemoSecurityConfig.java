package com.luv2code.springboot.cruddemo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Configuration class for defining security-related beans using Spring Security.
 * This class creates an InMemoryUserDetailsManager bean, which is an in-memory user
 * details manager provided by Spring Security. It allows the definition of users
 * with their respective roles directly in the code.
 */
@Configuration
public class DemoSecurityConfig {

    /**
     * Creates an InMemoryUserDetailsManager bean with predefined users and roles.
     *
     * @return InMemoryUserDetailsManager bean containing user details for authentication.
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123") //{noop} indicates plain text password
                .roles("EMPLOYEE")
                .build();

        UserDetails marry =User.builder()
                .username("marry")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails tom =User.builder()
                .username("tom")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        // Return the InMemoryUserDetailsManager bean with the defined users

        return new InMemoryUserDetailsManager(john, marry, tom);
    }
}
