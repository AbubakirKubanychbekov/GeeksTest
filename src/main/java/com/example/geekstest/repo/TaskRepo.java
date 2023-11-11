package com.example.geekstest.repo;

import com.example.geekstest.dto.TaskResponse;
import com.example.geekstest.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {

    @Query("select new com.example.geekstest.dto.TaskResponse(t.id,t.title,t.description,t.completed,t.createdAt) from Task t")
    List<TaskResponse> getAllTasks();
}
