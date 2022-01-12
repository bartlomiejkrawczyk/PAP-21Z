package com.example.api.controllers;

import com.example.api.entities.*;
import com.example.api.repositories.*;
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
public class IngredientsControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private Gson gson;

    private Dish mockDish;
    private DishCategory mockDishCategory;
    private Product mockProduct;
    private ProductCategory mockProductCategory;
    private Ingredient mockIngredient;

    @Autowired
    private DishesRepository dishesRepository;

    @Autowired
    private DishCategoriesRepository dishCategoriesRepository;

    @Autowired
    private ProductCategoriesRepository productCategoriesRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private IngredientsRepository repository;

    @BeforeEach
    public void setUpGson() {
        gson = new Gson();
    }

    @BeforeEach
    public void addMockIngredient() {
        mockDishCategory = new DishCategory(0L, "Test", null, Collections.emptyList());
        mockDish = new Dish(0L, "Test", null, 123, 0L, Collections.emptyList(), Collections.emptyList());

        dishCategoriesRepository.save(mockDishCategory);
        dishesRepository.save(mockDish);

        mockProductCategory = new ProductCategory(0L, "Test", Collections.emptyList());
        mockProduct = new Product(0L, "Test", 2000L, 10L, "ml", 0L);

        productCategoriesRepository.save(mockProductCategory);
        productsRepository.save(mockProduct);

        mockIngredient = new Ingredient(0L, 100L, 0L, 0L);

        repository.save(mockIngredient);
    }

    @AfterEach
    public void removeMockIngredient() {
        repository.delete(mockIngredient);

        productsRepository.deleteById(mockProduct.getId());
        productCategoriesRepository.deleteById(mockProductCategory.getId());

        dishesRepository.deleteById(mockDish.getId());
        dishCategoriesRepository.deleteById(mockDishCategory.getId());
    }

    @Test
    public void findAll() throws Exception {
        MvcResult result = mockMvc.perform(get("/ingredients/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Type listType = new TypeToken<List<Ingredient>>() {
        }.getType();
        List<Ingredient> ingredients = gson.fromJson(result.getResponse().getContentAsString(), listType);

        assertTrue(ingredients.size() > 0);
        assertTrue(ingredients.contains(mockIngredient));
    }
}
