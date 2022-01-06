package com.example.api.controllers;

import com.example.api.entities.Table;
import com.example.api.repositories.TablesRepository;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TablesControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private Gson gson;

    private Table mockTable;

    @Autowired
    private TablesRepository repository;


    @BeforeEach
    public void setUpGson() {
        gson = new Gson();
    }

    @BeforeEach
    public void addTable() {
        mockTable = new Table(0L, "Test");
        repository.save(mockTable);
    }

    @AfterEach
    public void removeTable() {
        repository.deleteById(mockTable.getId());
    }

    @Test
    public void findAll() throws Exception {
        MvcResult result = mockMvc.perform(get("/tables/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Type listType = new TypeToken<List<Table>>() {
        }.getType();
        List<Table> tables = gson.fromJson(result.getResponse().getContentAsString(), listType);

        assertTrue(tables.size() > 0);
        assertTrue(tables.contains(mockTable));
    }
}
