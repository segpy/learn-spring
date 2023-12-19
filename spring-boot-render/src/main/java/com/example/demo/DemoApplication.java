package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.SpringVersion;

@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner {
    private final Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner printInfo(){
//        return args -> {
//            String version = SpringVersion.getVersion();
//            System.out.println("Spring Framework Version: " + version);
//        };
//    }

    @Override
    public void run(String... args) throws Exception {
        String version = SpringVersion.getVersion();
        LOG.info("Spring Framework Version: " + version);
        log.info("Lombok Logger: " + version);
        System.out.println("Spring Framework Version: " + version);
    }
}
