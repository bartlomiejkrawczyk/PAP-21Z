package com.example.api.controllers;

import com.example.api.entities.Employee;
import com.example.api.entities.EmployeeKind;
import com.example.api.entities.Receipt;
import com.example.api.projections.MockReceiptInfo;
import com.example.api.repositories.EmployeeKindsRepository;
import com.example.api.repositories.EmployeesRepository;
import com.example.api.repositories.ReceiptsRepository;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ReceiptsControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private Gson gson;

    private EmployeeKind mockKind;
    private Employee mockEmployee;

    private Receipt mockReceipt;


    @Autowired
    private EmployeeKindsRepository employeeKindsRepository;
    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private ReceiptsRepository repository;

    @BeforeEach
    public void setUpGson() {
        gson = new Gson();
    }

    @BeforeEach
    public void addReceipt() {
        mockKind = new EmployeeKind(0L, "Test", Collections.emptyList());
        mockEmployee = new Employee(0L, "Test", "Tested", 0L);
        employeeKindsRepository.save(mockKind);
        employeesRepository.save(mockEmployee);

        mockReceipt = new Receipt(null, 0, mockEmployee, null, Collections.emptyList());

        mockReceipt = repository.save(mockReceipt);
    }

    @AfterEach
    public void removeReceipt() {
        repository.deleteById(mockReceipt.getId());

        employeesRepository.deleteById(mockEmployee.getId());
        employeeKindsRepository.deleteById(mockKind.getId());
    }

    @Test
    public void findAll() throws Exception {
        MvcResult result = mockMvc.perform(get("/receipts/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Type listType = new TypeToken<List<Receipt>>() {
        }.getType();
        List<Receipt> receipts = gson.fromJson(result.getResponse().getContentAsString(), listType);

        assertTrue(receipts.size() > 0);
        assertTrue(receipts.contains(mockReceipt));
    }

    @Test
    public void findReceiptsByEmployee() throws Exception {
        MvcResult result = mockMvc.perform(get("/receipts/employee/" + mockEmployee.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Type listType = new TypeToken<List<MockReceiptInfo>>() {
        }.getType();
        List<MockReceiptInfo> receipts = gson.fromJson(result.getResponse().getContentAsString(), listType);

        assertTrue(receipts.size() > 0);
        assertTrue(receipts.contains(new MockReceiptInfo(mockReceipt.getId(), 0, null)));
    }

    @Test
    public void saveReceipt() throws Exception {
        repository.deleteById(mockReceipt.getId());
        mockReceipt.setId(null);
        MvcResult result = mockMvc.perform(post("/receipts/")
                        .contentType("application/json")
                        .content(gson.toJson(mockReceipt)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Receipt receipt = gson.fromJson(result.getResponse().getContentAsString(), Receipt.class);

        mockReceipt.setId(receipt.getId());

        assertEquals(mockReceipt, receipt);
    }

    @Test
    public void deleteReceipt() throws Exception {
        mockMvc.perform(delete("/receipts/" + mockReceipt.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Optional<Receipt> optionalReceipt = repository.findById(mockReceipt.getId());

        optionalReceipt.ifPresent(receipt -> fail());

        mockReceipt.setId(null);
        mockReceipt = repository.save(mockReceipt);
    }
}
