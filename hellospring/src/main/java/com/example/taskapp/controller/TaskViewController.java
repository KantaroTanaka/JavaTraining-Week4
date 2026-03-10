package com.example.taskapp.controller;

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
import com.example.taskapp.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskViewController {

    private final TaskService taskService;

    public TaskViewController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "tasks/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "tasks/form";
    }

    @PostMapping
    public String create(@Validated @ModelAttribute Task task, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "tasks/form";
        }
        taskService.save(task);
        redirectAttributes.addFlashAttribute("successMessage", "タスクを作成しました！");
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.findById(id));
        return "tasks/form";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable Long id, @Validated @ModelAttribute Task task, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "tasks/form";
        }
        task.setId(id);
        taskService.save(task);
        redirectAttributes.addFlashAttribute("successMessage", "タスクを更新しました！");
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        taskService.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage", "タスクを削除しました！");
        return "redirect:/tasks";
    }
}