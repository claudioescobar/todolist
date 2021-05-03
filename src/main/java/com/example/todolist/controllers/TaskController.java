package com.example.todolist.controllers;

import com.example.todolist.entities.Task;
import com.example.todolist.entities.TaskStatus;
import com.example.todolist.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/tasks")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<Task> findBy(@RequestParam("taskStatus")TaskStatus taskStatus) {
        return taskService.findBy(taskStatus);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Task task) {
        taskService.create(task);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id, @RequestBody Task task) {
        taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        taskService.delete(id);
    }
}
