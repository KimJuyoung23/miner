package com.kjh.vuebootbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class VueBootBackendApplicationTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    void testJpa() {
        Board.builder();
    }

}
