package com.example.api.controllers;

import com.example.api.entities.*;
import com.example.api.projections.MockOrderInfoCook;
import com.example.api.projections.MockOrderInfoWaiter;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrdersControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private Gson gson;

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
    private OrdersRepository repository;

    @BeforeEach
    public void setUpGson() {
        gson = new Gson();
    }

    @BeforeEach
    public void addMockOrder() {
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

        mockOrder = repository.save(mockOrder);
    }

    @AfterEach
    public void removeMockOrder() {
        repository.deleteById(mockOrder.getId());

        receiptsRepository.deleteById(mockReceipt.getId());

        dishesRepository.deleteById(mockDish.getId());
        dishCategoriesRepository.deleteById(mockDishCategory.getId());

        employeesRepository.deleteById(mockEmployee.getId());
        employeeKindsRepository.deleteById(mockKind.getId());
    }

    @Test
    public void findAll() throws Exception {
        MvcResult result = mockMvc.perform(get("/orders/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Type listType = new TypeToken<List<Order>>() {
        }.getType();
        List<Order> orders = gson.fromJson(result.getResponse().getContentAsString(), listType);

        assertTrue(orders.size() > 0);
        assertTrue(orders.contains(mockOrder));
    }

    @Test
    public void findOrdersByReceipt() throws Exception {
        MvcResult result = mockMvc.perform(get("/orders/receipt/" + mockReceipt.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Type listType = new TypeToken<List<MockOrderInfoWaiter>>() {
        }.getType();
        List<MockOrderInfoWaiter> orders = gson.fromJson(result.getResponse().getContentAsString(), listType);

        assertTrue(orders.size() > 0);
        assertTrue(orders.contains(
                new MockOrderInfoWaiter(
                        mockOrder.getId(),
                        mockOrder.getDate(),
                        mockReceipt.getId(),
                        Collections.emptyList(),
                        1,
                        new MockOrderInfoWaiter.MockDishInfo(0L)
                )
        ));
    }

    @Test
    public void findOrdersByStatusAndEmployeeIsNull() throws Exception {
        mockOrder.setEmployee(null);
        repository.save(mockOrder);
        MvcResult result = mockMvc.perform(get("/orders/desktop/placed/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Type listType = new TypeToken<List<MockOrderInfoCook>>() {
        }.getType();
        List<MockOrderInfoCook> orders = gson.fromJson(result.getResponse().getContentAsString(), listType);

        assertTrue(orders.size() > 0);
        assertTrue(orders.contains(
                new MockOrderInfoCook(
                        mockOrder.getId(),
                        mockOrder.getDate(),
                        1,
                        new MockOrderInfoCook.MockDishInfo(0L),
                        null,
                        Collections.emptyList()
                )
        ));
    }

    @Test
    public void findOrdersByStatusAndEmployeeIsNotNull() throws Exception {
        MvcResult result = mockMvc.perform(get("/orders/desktop/progress/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Type listType = new TypeToken<List<MockOrderInfoCook>>() {
        }.getType();
        List<MockOrderInfoCook> orders = gson.fromJson(result.getResponse().getContentAsString(), listType);

        assertTrue(orders.size() > 0);
        assertTrue(orders.contains(
                new MockOrderInfoCook(
                        mockOrder.getId(),
                        mockOrder.getDate(),
                        1,
                        new MockOrderInfoCook.MockDishInfo(0L),
                        new MockOrderInfoCook.MockEmployeeInfo(0L),
                        Collections.emptyList()
                )
        ));
    }

    @Test
    public void setEmployee() throws Exception {
        mockOrder.setEmployee(null);
        repository.save(mockOrder);

        Employee employee = new Employee();
        employee.setId(mockEmployee.getId());

        mockOrder.setEmployee(employee);

        MvcResult result = mockMvc.perform(put("/orders/employee/" + mockOrder.getId() + "/" + mockEmployee.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Order order = gson.fromJson(result.getResponse().getContentAsString(), Order.class);

        assertEquals(mockOrder, order);
    }

    @Test
    public void setEmployeeEntityNotFound() throws Exception {
        mockMvc.perform(put("/orders/employee/0/" + mockEmployee.getId()))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(status().isNotFound());
    }

    @Test
    public void advanceStatus() throws Exception {
        mockOrder.setStatus(2);
        MvcResult result = mockMvc.perform(put("/orders/status/" + mockOrder.getId() + "/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Order order = gson.fromJson(result.getResponse().getContentAsString(), Order.class);

        assertEquals(mockOrder, order);
    }

    @Test
    public void advanceStatusDoNotDecrease() throws Exception {
        MvcResult result = mockMvc.perform(put("/orders/status/" + mockOrder.getId() + "/0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Order order = gson.fromJson(result.getResponse().getContentAsString(), Order.class);

        assertEquals(mockOrder, order);
    }

    @Test
    public void advanceStatusEntityNotFound() throws Exception {
        mockMvc.perform(put("/orders/status/0/2"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(status().isNotFound());
    }

    @Test
    public void saveOrder() throws Exception {
        repository.deleteById(mockOrder.getId());
        mockOrder.setId(null);

        MvcResult result = mockMvc.perform(
                        post("/orders/")
                                .contentType("application/json")
                                .content(gson.toJson(mockOrder)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Order order = gson.fromJson(result.getResponse().getContentAsString(), Order.class);
        mockOrder.setId(order.getId());
        assertEquals(mockOrder, order);
    }

    @Test
    public void deleteOrder() throws Exception {
        mockMvc.perform(delete("/orders/" + mockOrder.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();


        Optional<Order> optionalOrder = repository.findById(mockOrder.getId());

        optionalOrder.ifPresent(order -> fail());

        mockOrder = repository.save(mockOrder);
    }


}
