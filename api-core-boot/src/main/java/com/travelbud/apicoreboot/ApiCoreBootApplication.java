package com.travelbud.apicoreboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.travel.core","com.travelbud.apicoreboot"})
@EnableAutoConfiguration
public class ApiCoreBootApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ApiCoreBootApplication.class, args);
    }
}