package com.sparta.springindividual;

import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;

@EnableJpaAuditing
@SpringBootApplication
public class SpringIndividualApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIndividualApplication.class, args);
    }

}
