package com.example.todolist.controllers;

import com.example.todolist.TodolistApplication;
import com.example.todolist.entities.Task;
import com.example.todolist.repositories.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.example.todolist.TestUtil.formatLocalDateTime;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = TodolistApplication.class)
@AutoConfigureMockMvc
class TaskControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void findBy() throws Exception {
        // PENDING TASKS ids 1 e 3
        Task task1 = taskRepository.findById(1L).get();
        Task task3 = taskRepository.findById(3L).get();

        mvc.perform(MockMvcRequestBuilders.get("/api/tasks")
                .param("taskStatus","PENDING")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(task1.getId().intValue())))
                .andExpect(jsonPath("$[0].title", is(task1.getTitle())))
                .andExpect(jsonPath("$[0].description", is(task1.getDescription())))
                .andExpect(jsonPath("$[0].status", is(task1.getStatus().name())))
                .andExpect(jsonPath("$[0].creationDate", is(formatLocalDateTime(task1.getCreationDate()))))
                .andExpect(jsonPath("$[0].updateDate", is(formatLocalDateTime(task1.getUpdateDate()))))
                .andExpect(jsonPath("$[1].id", is(task3.getId().intValue())))
                .andExpect(jsonPath("$[1].title", is(task3.getTitle())))
                .andExpect(jsonPath("$[1].description", is(task3.getDescription())))
                .andExpect(jsonPath("$[1].status", is(task3.getStatus().name())))
                .andExpect(jsonPath("$[1].creationDate", is(formatLocalDateTime(task3.getCreationDate()))))
                .andExpect(jsonPath("$[1].updateDate", is(formatLocalDateTime(task3.getUpdateDate()))));
    }

}