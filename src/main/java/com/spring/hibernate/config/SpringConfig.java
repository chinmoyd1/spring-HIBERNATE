package com.spring.hibernate.config;

import com.spring.hibernate.repository.EmployeeDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= "com.spring.hibernate.repository")
public class SpringConfig {
    @Bean
    public EmployeeDAO dao(){
        return new EmployeeDAO();
    }
}
