package com.example.taskapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.taskapp.service.UserAccountService;

@SpringBootApplication
public class TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(UserAccountService userAccountService) {
        return args -> {
            try {
                userAccountService.registerUser("testuser2", "password"); 
                
                System.out.println("testuser2を登録しました！");
            } catch (Exception e) {
                System.out.println("（テストユーザーはすでに存在しているか、エラーが発生しました）");
            }
        };
    }
}