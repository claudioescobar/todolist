package com.example.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = TodolistApplication.class)
@AutoConfigureMockMvc
public class AbstractIntegrationTest {

    @Container
    private static final PostgreSQLContainer postgreSQLContainer = CustomPostgreSQLContainer.getInstance();

    @Autowired
    protected MockMvc mvc;

    @Test
    void dbIsRunning() {
        assertTrue(postgreSQLContainer.isRunning());
    }
}
