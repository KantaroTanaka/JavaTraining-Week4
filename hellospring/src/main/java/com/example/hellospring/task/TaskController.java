package com.example.hellospring.task;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // 全件取得
    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    // タスク登録
    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Map<String, String> request) {
        String title = request.get("title");
        
        // バリデーション：titleが空またはnullなら400エラー
        if (title == null || title.isEmpty()) {
            return ResponseEntity.badRequest().body("Title cannot be empty");
        }
        
        Task newTask = taskService.addTask(title);
        return ResponseEntity.ok(newTask);
    }
}