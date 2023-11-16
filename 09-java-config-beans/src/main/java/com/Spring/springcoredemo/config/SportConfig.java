package com.Spring.springcoredemo.config;

import com.Spring.springcoredemo.common.Coach;
import com.Spring.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public Coach swimCoach(){   //bean id is swimCoach
        return  new SwimCoach();
    }
}
