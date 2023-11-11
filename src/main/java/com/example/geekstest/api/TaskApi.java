package com.example.geekstest.api;

import com.example.geekstest.dto.SimpleResponse;
import com.example.geekstest.dto.TaskRequest;
import com.example.geekstest.dto.TaskResponse;
import com.example.geekstest.service.TaskService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Getter
@Setter
@RequestMapping("/api/task")
public class TaskApi {

    private final TaskService taskService;

    @GetMapping
    List<TaskResponse> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping
    TaskResponse create(@RequestBody TaskRequest save){
        return taskService.create(save);
    }

    @PutMapping("/{id}")
    SimpleResponse update(@PathVariable Long id, @RequestBody TaskRequest taskRequest){
        return taskService.update(id,taskRequest);
    }

    @DeleteMapping("/{id}")
    SimpleResponse delete(@PathVariable Long id){
        return taskService.delete(id);
    }
}
