package com.example.api.controllers;

import com.example.api.entities.EmployeeKind;
import com.example.api.repositories.EmployeeKindsRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeKindsControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private Gson gson;

    private EmployeeKind mockKind;

    @Autowired
    private EmployeeKindsRepository repository;

    @BeforeEach
    public void setUpGson() {
        gson = new Gson();
    }

    @BeforeEach
    public void addMockEmployeeKind() {
        mockKind = new EmployeeKind(0L, "Test", Collections.emptyList());
        repository.save(mockKind);
    }

    @AfterEach
    public void removeMockEmployeeKind() {
        repository.delete(mockKind);
    }

    @Test
    public void findAll() throws Exception {
        MvcResult result = mockMvc.perform(get("/employeeKinds/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Type listType = new TypeToken<List<EmployeeKind>>() {
        }.getType();
        List<EmployeeKind> kinds = gson.fromJson(result.getResponse().getContentAsString(), listType);

        assertTrue(kinds.size() > 0);
        assertTrue(kinds.contains(mockKind));
    }
}
