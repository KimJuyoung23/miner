package com.kjh.vuebootbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VueBootBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueBootBackendApplication.class, args);
    }

}
