// User Guide:
// ***************************************************************************
// **** Please make sure to follow the steps below to run the application ****
// ***************************************************************************
// Database creation script: CREATE DATABASE lib_auth_service_db;


package com.sarasavi.lib_auth_service;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibAuthServiceApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
