package com.example.demo.models.mapper;

import com.example.demo.models.Task;
import com.example.demo.models.UserWithBuilder;


public class TaskMapper {

    public TaskDTO toDTO(Task task) {
        return TaskDTO.builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .build();
    }

    public UserWithBuilder testBuilder() {
        return UserWithBuilder.Builder.builder()
                .setName("name")
                .setSurname("surname")
                .build();
    }

    public Task toEntity(TaskDTO dto) {
        return Task.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }

//    public Task toEntity(TaskDTO dto) {
//        Task task = new Task();
//        task.setId(dto.getId());
//        task.setName(dto.getName());
//        task.setDescription(dto.getDescription());
//        task.setDone(dto.isDone());
//        task.setTaskDate(Date.valueOf(dto.getCustomDate()));
//        return task;
//    }
}
