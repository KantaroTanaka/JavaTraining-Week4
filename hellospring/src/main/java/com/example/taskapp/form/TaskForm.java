package com.example.taskapp.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskForm {

    @NotBlank(message = "タイトルを入力してください")
    @Size(max = 50, message = "タイトルは50文字以内で入力してください")
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}