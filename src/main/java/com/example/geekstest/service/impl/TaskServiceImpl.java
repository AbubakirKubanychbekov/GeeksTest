package com.example.geekstest.service.impl;

import com.example.geekstest.dto.SimpleResponse;
import com.example.geekstest.dto.TaskRequest;
import com.example.geekstest.dto.TaskResponse;
import com.example.geekstest.entity.Task;
import com.example.geekstest.repo.TaskRepo;
import com.example.geekstest.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;

    @Override
    public List<TaskResponse> getAllTasks() {
        return taskRepo.getAllTasks();
    }

    @Override
    public TaskResponse create(TaskRequest save) {
        Task task = new Task();
        task.setId(save.getId());
        task.setTitle(save.getTitle());
        task.setDescription(save.getDescription());
        task.setCompleted(false);
        task.setCreatedAt(LocalDate.now());
        taskRepo.save(task);
        return TaskResponse.builder()
                .id(save.getId())
                .title(save.getTitle())
                .description(save.getDescription())
                .completed(false)
                .createdAt(LocalDate.now())
                .build();
    }

    @Override
    public SimpleResponse update(Long id, TaskRequest taskRequest) {
        Task task = taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Task with id: %s not found".formatted(id)));
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setCompleted(false);
        task.setCreatedAt(LocalDate.now());
        taskRepo.save(task);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Task successfully updated")
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        if (!taskRepo.existsById(id)){
            throw new RuntimeException("Task with id: %s not exsist");
        }
        taskRepo.deleteById(id);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Task is deleted")
                .build();
    }
}
