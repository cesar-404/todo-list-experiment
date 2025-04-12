package br.com.bebopcode.todolist.controller;

import br.com.bebopcode.todolist.dto.TaskRequest;
import br.com.bebopcode.todolist.dto.TaskResponse;
import br.com.bebopcode.todolist.dto.TaskUpdateRequest;
import br.com.bebopcode.todolist.dto.TaskUpdateResponse;
import br.com.bebopcode.todolist.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> create(@RequestBody TaskRequest task) {
        var response = taskService.create(task);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskUpdateResponse> updateById(@PathVariable Long id, @RequestBody TaskUpdateRequest task) {
        var updateResponse = taskService.update(id, task);
        return ResponseEntity.ok().body(updateResponse);
    }

    @GetMapping("/list")
    public ResponseEntity<List<TaskResponse>> findAll() {
        List<TaskResponse> listResponse = taskService.findAll();
        return ResponseEntity.ok().body(listResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskResponse> findById(@PathVariable Long id) {
        var response = taskService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<Void> deleteAll() {
        taskService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
