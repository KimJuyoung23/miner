package com.kjh.vuebootbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // BaseTimeEntity.java 에 쓰임
public class VueBootBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueBootBackendApplication.class, args);
    }

}
