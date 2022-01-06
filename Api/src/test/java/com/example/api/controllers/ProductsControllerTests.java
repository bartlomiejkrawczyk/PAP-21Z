package com.example.api.controllers;

import com.example.api.entities.Product;
import com.example.api.entities.ProductCategory;
import com.example.api.projections.MockProductInfo;
import com.example.api.repositories.ProductCategoriesRepository;
import com.example.api.repositories.ProductsRepository;
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
public class ProductsControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private Gson gson;

    private ProductCategory mockCategory;
    private Product mockProduct;

    @Autowired
    private ProductCategoriesRepository categoriesRepository;

    @Autowired
    private ProductsRepository repository;

    @BeforeEach
    public void setUpGson() {
        gson = new Gson();
    }

    @BeforeEach
    public void addProduct() {
        mockCategory = new ProductCategory(0L, "Test", Collections.emptyList());
        mockProduct = new Product(0L, "Test", 1000L, 100L, "L", 0L);

        categoriesRepository.save(mockCategory);
        repository.save(mockProduct);
    }

    @AfterEach
    public void removeProduct() {
        repository.deleteById(mockProduct.getId());
        categoriesRepository.deleteById(mockCategory.getId());
    }

    @Test
    public void findAll() throws Exception {
        MvcResult result = mockMvc.perform(get("/products/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Type listType = new TypeToken<List<Product>>() {
        }.getType();
        List<Product> products = gson.fromJson(result.getResponse().getContentAsString(), listType);

        assertTrue(products.size() > 0);
        assertTrue(products.contains(mockProduct));
    }

    @Test
    public void findById() throws Exception {
        MvcResult result = mockMvc.perform(get("/products/id/0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        MockProductInfo product = gson.fromJson(result.getResponse().getContentAsString(), MockProductInfo.class);

        assertEquals(new MockProductInfo(mockProduct.getId(), mockProduct.getName(), mockProduct.getUnit()), product);
    }
}
