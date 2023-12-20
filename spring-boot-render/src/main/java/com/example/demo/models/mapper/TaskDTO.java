package com.example.demo.models.mapper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDTO {
    public long id;
    public String name;
    public String description;
    public String customDate;
}
