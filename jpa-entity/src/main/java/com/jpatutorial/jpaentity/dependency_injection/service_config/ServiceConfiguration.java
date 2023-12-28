package com.jpatutorial.jpaentity.dependency_injection.service_config;


import com.jpatutorial.jpaentity.dependency_injection.CommunicationService;
import com.jpatutorial.jpaentity.dependency_injection.EmailService;
import com.jpatutorial.jpaentity.dependency_injection.ISender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public ISender iSender() {
        return new EmailService();
    }
}
