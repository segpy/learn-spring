package com.example.demo.services;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.Task;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.repository.TaskRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> getTaskById(Long id) {
        Optional<Task> tempTask = taskRepository.findById(id);
        if (tempTask.isPresent()) {
            return tempTask;
        } else {
//            throw new NotFoundException("Task with id " + id + " not found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task with id " + id + " not found");
        }
    }
}
