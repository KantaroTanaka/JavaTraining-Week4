package com.example.hellospring.task;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private int currentId = 1;

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task addTask(String title) {
        Task newTask = new Task(currentId++, title);
        tasks.add(newTask);
        return newTask;
    }
}