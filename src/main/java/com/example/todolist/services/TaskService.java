package com.example.todolist.services;

import com.example.todolist.entities.Task;
import com.example.todolist.entities.TaskStatus;
import com.example.todolist.exceptions.DataNotFoundException;
import com.example.todolist.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TaskService {

    private final TaskRepository taskRepository;

    public void create(Task task) {
        taskRepository.save(task);
    }

    public void update(Long id, Task task) {
        task.setId(id);
        taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> findBy(TaskStatus taskStatus) {
        Example<Task> criteria = Example.of(Task.builder().status(taskStatus).build());
        List<Task> tasks = taskRepository.findAll(criteria);

        if (tasks == null || tasks.isEmpty()) {
            throw new DataNotFoundException();
        }

        return tasks;
    }

}
