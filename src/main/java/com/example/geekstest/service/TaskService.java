package com.example.geekstest.service;

import com.example.geekstest.dto.SimpleResponse;
import com.example.geekstest.dto.TaskRequest;
import com.example.geekstest.dto.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAllTasks();

    TaskResponse create(TaskRequest save);

    SimpleResponse update(Long id, TaskRequest taskRequest);

    SimpleResponse delete(Long id);
}
