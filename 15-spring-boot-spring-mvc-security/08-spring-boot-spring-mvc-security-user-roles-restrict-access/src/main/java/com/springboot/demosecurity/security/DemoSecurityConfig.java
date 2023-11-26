package com.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

//add support for JDBC .. no hard code
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
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
   // Configure in-memory user details manager with three users: john, mary, and susan.
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}test123")//Use {noop} to indicate plain text password (for demo purposes).
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails mary = User.builder()
//                .username("mary")
//                .password("{noop}test123")
//                .roles("EMPLOYEE","MANAGER")
//                .build();
//
//        UserDetails susan = User.builder()
//                .username("susan")
//                .password("{noop}test123")
//                .roles("EMPLOYEE","MANAGER","ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john, mary, susan);
//    }

}
