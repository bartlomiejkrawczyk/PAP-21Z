package com.example.api.controllers;

import com.example.api.entities.Employee;
import com.example.api.entities.EmployeeKind;
import com.example.api.projections.MockEmployeeNamesOnly;
import com.example.api.repositories.EmployeeKindsRepository;
import com.example.api.repositories.EmployeesRepository;
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
public class EmployeesControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private Gson gson;

    private EmployeeKind mockKind;
    private Employee mockEmployee;

    @Autowired
    private EmployeeKindsRepository employeeKindsRepository;

    @Autowired
    private EmployeesRepository repository;

    @BeforeEach
    public void setUpGson() {
        gson = new Gson();
    }

    @BeforeEach
    public void addMockEmployee() {
        mockKind = new EmployeeKind(0L, "Test", Collections.emptyList());
        mockEmployee = new Employee(0L, "Test", "Tested", 0L);
        employeeKindsRepository.save(mockKind);
        repository.save(mockEmployee);
    }

    @AfterEach
    public void removeMockEmployee() {
        repository.delete(mockEmployee);
        employeeKindsRepository.deleteById(mockKind.getId());
    }

    @Test
    public void findAll() throws Exception {
        MvcResult result = mockMvc.perform(get("/employees/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        List<Employee> employees = gson.fromJson(result.getResponse().getContentAsString(), listType);

        assertTrue(employees.size() > 0);
        assertTrue(employees.contains(mockEmployee));
    }

    @Test
    public void findNamesByEmployeeKindId() throws Exception {
        MvcResult result = mockMvc.perform(get("/employees/names/0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Type listType = new TypeToken<List<MockEmployeeNamesOnly>>() {
        }.getType();
        List<MockEmployeeNamesOnly> employees = gson.fromJson(result.getResponse().getContentAsString(), listType);

        assertTrue(employees.size() > 0);
        assertTrue(employees.contains(new MockEmployeeNamesOnly(0L, "Test Tested")));
    }

    @Test
    public void findEmployeesOfKind() throws Exception {
        MvcResult result = mockMvc.perform(get("/employees/kind/0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        List<Employee> employees = gson.fromJson(result.getResponse().getContentAsString(), listType);

        assertTrue(employees.size() > 0);
        assertTrue(employees.contains(mockEmployee));
    }
}
