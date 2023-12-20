package com.example.demo.services;

import com.example.demo.models.Task;
import com.example.demo.models.mapper.TaskDTO;
import com.example.demo.models.mapper.TaskMapper;
import com.example.demo.repository.adapter.TaskRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.demo.repository.TaskRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepositoryAdapter taskRepository;
    private final TaskMapper taskMapper;

    public List<TaskDTO> getTasks() {
        return taskRepository.getTasks();
    }

    public TaskDTO saveTask(TaskDTO task) {
        return taskRepository.saveTask(task);
    }

    public TaskDTO getTaskById(Long id) {
        Optional<TaskDTO> tempTask = taskRepository.getTaskById(id);
//        if (tempTask.isPresent()) {
//            return tempTask.get();
//        } else {
////            throw new NotFoundException("Task with id " + id + " not found");
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task with id " + id + " not found");
//        }
        return tempTask.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task with id " + id + " not found"));
    }
}
