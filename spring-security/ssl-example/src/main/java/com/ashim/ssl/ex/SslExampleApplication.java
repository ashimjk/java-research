package com.ashim.ssl.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
public class SslExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SslExampleApplication.class, args);
    }

}