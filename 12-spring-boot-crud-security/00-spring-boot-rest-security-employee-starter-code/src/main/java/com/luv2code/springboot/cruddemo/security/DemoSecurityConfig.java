package com.luv2code.springboot.cruddemo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

/**
 * Configuration class for defining security-related beans using Spring Security.
 * This class creates an InMemoryUserDetailsManager bean, which is an in-memory user
 * details manager provided by Spring Security. It allows the definition of users
 * with their respective roles directly in the code.
 */
@Configuration
public class DemoSecurityConfig {

    //add support for JDBC
    //no hard-coded users
    /**
     * Creates a UserDetailsManager bean using JDBC for user authentication.
     * This bean is responsible for managing user details, such as loading user information
     * from a database using JDBC. It uses the provided DataSource for database connectivity.
     *
     * @param dataSource The DataSource bean for connecting to the database.
     * @return UserDetailsManager bean configured to use JDBC for user authentication.
     */

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    /**
     * Configures security based on roles for different URL patterns.
     *
     * @param http HttpSecurity object to configure security settings.
     * @return SecurityFilterChain object representing the security configuration.
     * @throws Exception Exception that may occur during configuration.
     */
   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
        http.authorizeHttpRequests(configurar ->
                configurar
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
        );
       // Use HTTP Basic Authentication
        http.httpBasic(Customizer.withDefaults());

       // Disable CSRF protection (not required for stateless REST APIs using POST, PUT, DELETE, and/or PATCH)
        http.csrf(csrf ->csrf.disable());

       // Return the configured HttpSecurity as a SecurityFilterChain
       return http.build();
   }



    /**
     //     * Creates an InMemoryUserDetailsManager bean with predefined users and roles.
     //     *
     //     * @return InMemoryUserDetailsManager bean containing user details for authentication.
     //     */

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}test123")// {noop} indicates plain text password
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
//        // Return the InMemoryUserDetailsManager bean with the defined users
//        return new InMemoryUserDetailsManager(john, mary, susan);
//    }

}
