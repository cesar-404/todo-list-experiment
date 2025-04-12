package br.com.bebopcode.todolist.service.mappers;

import br.com.bebopcode.todolist.dto.TaskRequest;
import br.com.bebopcode.todolist.dto.TaskResponse;
import br.com.bebopcode.todolist.dto.TaskUpdateResponse;
import br.com.bebopcode.todolist.model.Task;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TaskMapper {

    public Task toEntity(TaskRequest taskRequest) {
        return new Task(taskRequest.title(),
                taskRequest.description(),
                taskRequest.priority(),
                taskRequest.status());
    }

    public TaskResponse toTaskResponse(Task task) {
        return new TaskResponse(task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getStatus(),
                task.getCreatedAt());
    }

    public TaskResponse toTaskResponse(Optional<Task> task) {
        var taskResult = task.orElseThrow(
                () -> new RuntimeException("Task not found")
        );
        return toTaskResponse(taskResult);
    }

    public TaskUpdateResponse toTaskUpdateResponse(Optional<Task> task) {
        var taskResult = task.orElseThrow(
                () -> new RuntimeException("Task not found"));

        return new TaskUpdateResponse(taskResult.getTitle(),
                taskResult.getDescription(),
                taskResult.getPriority(),
                taskResult.getStatus(),
                taskResult.getCreatedAt(),
                taskResult.getUpdatedAt());
    }
}
