package com.example.api.controllers;


import com.example.api.entities.DishCategory;
import com.example.api.repositories.DishCategoriesRepository;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class DishCategoriesControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private Gson gson;

    private DishCategory mockCategory;

    @Autowired
    private DishCategoriesRepository repository;

    @BeforeEach
    public void setUpGson() {
        gson = new Gson();
    }

    @BeforeEach
    public void addMockDishCategory() {
        mockCategory = new DishCategory(0L, "Kategoria", "img/kkn.gif", Collections.emptyList());
        repository.save(mockCategory);
    }

    @AfterEach
    public void removeMockDishCategory() {
        repository.delete(mockCategory);
    }

    @Test
    public void getExample() throws Exception {
        DishCategory dishCategory = new DishCategory(1L, "Kategoria", "img/kkn.gif", Collections.emptyList());

        mockMvc.perform(get("/dishCategories/example"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(gson.toJson(dishCategory)));
    }

    @Test
    public void findAll() throws Exception {
        MvcResult result = mockMvc.perform(get("/dishCategories/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Type listType = new TypeToken<List<DishCategory>>() {
        }.getType();
        List<DishCategory> dishCategories = gson.fromJson(result.getResponse().getContentAsString(), listType);

        assertTrue(dishCategories.size() > 0);
        assertTrue(dishCategories.contains(mockCategory));
    }


    @Test
    public void findDishCategoriesInfo() throws Exception {
        MvcResult result = mockMvc.perform(get("/dishCategories/mobile"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Type listType = new TypeToken<List<DishCategory>>() {
        }.getType();
        List<DishCategory> dishCategories = gson.fromJson(result.getResponse().getContentAsString(), listType);

        assertTrue(dishCategories.size() > 0);
        assertTrue(dishCategories.contains(mockCategory));
    }


}
