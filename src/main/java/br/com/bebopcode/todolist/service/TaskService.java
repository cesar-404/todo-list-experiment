package br.com.bebopcode.todolist.service;

import br.com.bebopcode.todolist.dto.TaskRequest;
import br.com.bebopcode.todolist.dto.TaskResponse;
import br.com.bebopcode.todolist.dto.TaskUpdateRequest;
import br.com.bebopcode.todolist.dto.TaskUpdateResponse;
import br.com.bebopcode.todolist.repository.TaskRepository;
import br.com.bebopcode.todolist.service.mappers.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository repository, TaskMapper taskMapper, TaskRepository taskRepository) {
        this.repository = repository;
        this.taskMapper = taskMapper;
        this.taskRepository = taskRepository;
    }

    public TaskResponse create(TaskRequest task) {
        var taskEntity = taskMapper.toEntity(task);
        var taskEntityResult = repository.save(taskEntity);
        return taskMapper.toTaskResponse(taskEntityResult);
    }

    public TaskUpdateResponse update(Long id, TaskUpdateRequest task) {
        var taskEntity = repository.findById(id);
        return taskMapper.toTaskUpdateResponse(taskEntity);
    }

    public List<TaskResponse> findAll() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toTaskResponse)
                .sorted(Comparator.comparingInt(
                        (TaskResponse taskResponse) -> taskResponse.priority().getOrder()
                ))
                .collect(Collectors.toList());
    }

    public TaskResponse findById(Long id) {
        var taskEntity = repository.findById(id);
        return taskMapper.toTaskResponse(taskEntity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

}
