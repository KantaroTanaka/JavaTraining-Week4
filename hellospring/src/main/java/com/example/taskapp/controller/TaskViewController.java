package com.example.taskapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.taskapp.entity.Task;
import com.example.taskapp.exception.TaskNotFoundException;
import com.example.taskapp.form.TaskForm;
import com.example.taskapp.service.TaskService;

@Controller // ← @RestControllerではありません！「画面」を返すときはこれ。
@RequestMapping("/tasks")
public class TaskViewController {

    private final TaskService taskService;

    public TaskViewController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String index(Model model) {
        List<Task> tasks = taskService.findAll();
        
        model.addAttribute("tasks", tasks);
        
        return "tasks/index";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("taskForm", new TaskForm());
        return "tasks/form";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Task task = taskService.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
        
        TaskForm taskForm = new TaskForm();
        taskForm.setTitle(task.getTitle());
        
        model.addAttribute("taskForm", taskForm);
        model.addAttribute("taskId", id);
        model.addAttribute("mode", "edit");
        
        return "tasks/form";
    }

    @PostMapping
    public String createTask(@Validated @ModelAttribute TaskForm taskForm,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        
        if (bindingResult.hasErrors()) {
            return "tasks/form";
        }

        Task task = new Task();
        task.setTitle(taskForm.getTitle());
        task.setCompleted(false);
        taskService.save(task);

        redirectAttributes.addFlashAttribute("success", "タスクを登録しました！");

        return "redirect:/tasks";
    }

    @PostMapping("/{id}/edit")
    public String updateTask(@PathVariable Long id, 
                             @Validated @ModelAttribute TaskForm taskForm,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("mode", "edit"); 
            return "tasks/form";
        }

        Task task = taskService.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
        
        task.setTitle(taskForm.getTitle());
        taskService.update(id, task);

        redirectAttributes.addFlashAttribute("success", "タスクを更新しました！");
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        taskService.delete(id);
        
        redirectAttributes.addFlashAttribute("success", "タスクを削除しました！");
        return "redirect:/tasks";
    }
}