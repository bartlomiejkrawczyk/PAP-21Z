package com.example.api.controllers;


import com.example.api.entities.Dish;
import com.example.api.entities.DishCategory;
import com.example.api.repositories.DishCategoriesRepository;
import com.example.api.repositories.DishesRepository;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DishesControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private Gson gson;

    private DishCategory mockDishCategory;

    private Dish mockDish;

    @Autowired
    private DishCategoriesRepository dishCategoriesRepository;
    @Autowired
    private DishesRepository repository;

    @BeforeEach
    public void setUpGson() {
        gson = new Gson();
    }

    @BeforeEach
    public void addMockDish() {
        mockDishCategory = new DishCategory(0L, "Test", null, Collections.emptyList());
        mockDish = new Dish(0L, "Abc", null, 123, 0L, Collections.emptyList(), Collections.emptyList());
        dishCategoriesRepository.save(mockDishCategory);
        repository.save(mockDish);
    }

    @AfterEach
    public void removeMockDish() {
        repository.delete(mockDish);
        dishCategoriesRepository.deleteById(mockDishCategory.getId());
    }

    @Test
    public void findAll() throws Exception {
        MvcResult result = mockMvc.perform(get("/dishes/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Type listType = new TypeToken<List<Dish>>() {
        }.getType();
        List<Dish> dishes = gson.fromJson(result.getResponse().getContentAsString(), listType);

        assertTrue(dishes.size() > 0);
        assertTrue(dishes.contains(mockDish));
    }

    @Test
    public void findDishById() throws Exception {
        MvcResult result = mockMvc.perform(get("/dishes/0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Dish dish = gson.fromJson(result.getResponse().getContentAsString(), Dish.class);
        assertEquals(mockDish, dish);
    }

    @Test
    public void findDishByIdEntityNotFound() throws Exception {
        mockMvc.perform(get("/dishes/-1"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(status().isNotFound());
    }

}
