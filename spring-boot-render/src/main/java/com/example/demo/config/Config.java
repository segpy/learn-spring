package com.example.demo.config;

import com.example.demo.models.mapper.TaskMapper;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.adapter.TaskRepositoryAdapter;
import com.example.demo.services.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public TaskMapper taskMapper() {
        return new TaskMapper();
    }

//    @Bean
//    public TaskRepositoryAdapter taskRepositoryAdapter(TaskRepository taskRepository, TaskMapper taskMapper) {
//        return new TaskRepositoryAdapter(taskRepository, taskMapper);
//    }
}
