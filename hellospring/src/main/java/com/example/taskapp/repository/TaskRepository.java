package com.example.taskapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taskapp.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}