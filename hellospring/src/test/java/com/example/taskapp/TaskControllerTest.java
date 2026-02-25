package com.example.taskapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "testuser", roles = "USER") 
    public void testShowTaskList_Success() throws Exception {
        mockMvc.perform(get("/tasks"))
               .andExpect(status().isOk())
               .andExpect(view().name("tasks/index"));
    }

    @Test
    public void testShowTaskList_WithoutLogin_RedirectsToLogin() throws Exception {
        mockMvc.perform(get("/tasks"))
               .andExpect(status().is3xxRedirection()); 
    }
}