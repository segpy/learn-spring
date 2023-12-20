package com.example.demo.repository.adapter;

import com.example.demo.models.Task;
import com.example.demo.models.mapper.TaskDTO;
import com.example.demo.models.mapper.TaskMapper;
import com.example.demo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryAdapter {


    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public Optional<TaskDTO> getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        return Optional.ofNullable(taskMapper.toDTO(task));
    }

    public TaskDTO saveTask(TaskDTO taskDTO) {
        Task task = taskMapper.toEntity(taskDTO);
        return taskMapper.toDTO(taskRepository.save(task));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public TaskDTO updateTask(TaskDTO taskDTO) {
        Task task = taskMapper.toEntity(taskDTO);
        return taskMapper.toDTO(taskRepository.save(task));
    }

    public List<TaskDTO> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(taskMapper::toDTO).collect(Collectors.toList());
    }
}
