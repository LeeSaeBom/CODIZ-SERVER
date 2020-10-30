package com.gachon.codiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class CodizApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodizApplication.class, args);
    }
}
