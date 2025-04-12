package br.com.bebopcode.todolist.dto;


import br.com.bebopcode.todolist.enums.TaskPriority;
import br.com.bebopcode.todolist.enums.TaskStatus;

public record TaskRequest(String title,
                          String description,
                          TaskPriority priority,
                          TaskStatus status) {
}
