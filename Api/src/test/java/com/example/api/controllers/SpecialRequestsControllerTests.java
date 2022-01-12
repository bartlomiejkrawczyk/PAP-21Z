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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SpecialRequestsControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private Gson gson;

    private SpecialRequest mockRequest;

    private Order mockOrder;

    private EmployeeKind mockKind;
    private Employee mockEmployee;

    private DishCategory mockDishCategory;

    private Dish mockDish;

    private Receipt mockReceipt;

    @Autowired
    private ReceiptsRepository receiptsRepository;

    @Autowired
    private DishCategoriesRepository dishCategoriesRepository;
    @Autowired
    private DishesRepository dishesRepository;

    @Autowired
    private EmployeeKindsRepository employeeKindsRepository;
    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private SpecialRequestsRepository repository;

    @BeforeEach
    public void setUpGson() {
        gson = new Gson();
    }

    @BeforeEach
    public void addMockRequest() {
        mockKind = new EmployeeKind(0L, "Test", Collections.emptyList());
        mockEmployee = new Employee(0L, "Test", "Tested", 0L);
        employeeKindsRepository.save(mockKind);
        employeesRepository.save(mockEmployee);

        mockDishCategory = new DishCategory(0L, "Test", null, Collections.emptyList());
        mockDish = new Dish(0L, "Abc", null, 123, 0L, Collections.emptyList(), Collections.emptyList());
        dishCategoriesRepository.save(mockDishCategory);
        dishesRepository.save(mockDish);

        mockReceipt = new Receipt(null, 0, mockEmployee, null, Collections.emptyList());
        mockReceipt = receiptsRepository.save(mockReceipt);

        mockOrder = new Order(null, System.currentTimeMillis(), mockDish, mockReceipt.getId(), Collections.emptyList(), 1, mockEmployee);

        mockOrder = ordersRepository.save(mockOrder);

        mockRequest = new SpecialRequest(null, "Test", mockOrder.getId());
        mockRequest = repository.save(mockRequest);
    }

    @AfterEach
    public void removeMockRequest() {
        repository.deleteById(mockRequest.getId());

        ordersRepository.deleteById(mockOrder.getId());

        receiptsRepository.deleteById(mockReceipt.getId());

        dishesRepository.deleteById(mockDish.getId());
        dishCategoriesRepository.deleteById(mockDishCategory.getId());

        employeesRepository.deleteById(mockEmployee.getId());
        employeeKindsRepository.deleteById(mockKind.getId());
    }

    @Test
    public void findAll() throws Exception {
        MvcResult result = mockMvc.perform(get("/specialRequests/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Type listType = new TypeToken<List<SpecialRequest>>() {
        }.getType();
        List<SpecialRequest> requests = gson.fromJson(result.getResponse().getContentAsString(), listType);

        assertTrue(requests.size() > 0);
        assertTrue(requests.contains(mockRequest));
    }

    @Test
    public void saveSpecialRequest() throws Exception {
        repository.deleteById(mockRequest.getId());
        mockRequest.setId(null);
        MvcResult result = mockMvc.perform(post("/specialRequests/")
                        .contentType("application/json")
                        .content(gson.toJson(mockRequest)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        SpecialRequest request = gson.fromJson(result.getResponse().getContentAsString(), SpecialRequest.class);
        mockRequest.setId(request.getId());

        assertEquals(mockRequest, request);
    }

    @Test
    public void deleteSpecialRequest() throws Exception {
        mockMvc.perform(delete("/specialRequests/" + mockRequest.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        mockRequest.setId(null);
        mockRequest = repository.save(mockRequest);
    }
}
