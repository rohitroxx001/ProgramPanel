package com.programpanel.presentation.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.programpanel")
public class CommandLineApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommandLineApplication.class, args);
    }
}
