package br.com.bebopcode.todolist.dto;

import br.com.bebopcode.todolist.enums.TaskPriority;
import br.com.bebopcode.todolist.enums.TaskStatus;

import java.time.LocalDateTime;

public record TaskResponse(String title,
                           String description,
                           TaskPriority priority,
                           TaskStatus status,
                           LocalDateTime createdAt) {
}
