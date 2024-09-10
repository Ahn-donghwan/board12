package com.sparta.round12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Round12Application {

    public static void main(String[] args) {
        SpringApplication.run(Round12Application.class, args);
    }

}
