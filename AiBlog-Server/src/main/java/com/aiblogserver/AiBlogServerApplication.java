package com.aiblogserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AiBlogServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiBlogServerApplication.class, args);
    }

}
