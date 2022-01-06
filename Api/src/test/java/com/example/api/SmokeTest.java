package com.example.api;

import com.example.api.controllers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private DishCategoriesController dishCategoriesController;

    @Autowired
    private DishesController dishesController;

    @Autowired
    private EmployeesController employeesController;

    @Autowired
    private EmployeeKindsController employeeKindsController;

    @Autowired
    private HelloWorldController helloWorldController;

    @Autowired
    private IngredientsController ingredientsController;

    @Autowired
    private OrdersController ordersController;

    @Autowired
    private ProductCategoriesController productCategoriesController;

    @Autowired
    private ProductsController productsController;

    @Autowired
    private ReceiptsController receiptsController;

    @Autowired
    private RecipesController recipesController;

    @Autowired
    private SpecialRequestsController specialRequestsController;

    @Autowired
    private TablesController tablesController;

    @Test
    public void contextLoads() {
        assertThat(dishCategoriesController).isNotNull();
        assertThat(dishesController).isNotNull();
        assertThat(employeesController).isNotNull();
        assertThat(employeeKindsController).isNotNull();
        assertThat(helloWorldController).isNotNull();
        assertThat(ingredientsController).isNotNull();
        assertThat(ordersController).isNotNull();
        assertThat(productCategoriesController).isNotNull();
        assertThat(productsController).isNotNull();
        assertThat(receiptsController).isNotNull();
        assertThat(recipesController).isNotNull();
        assertThat(specialRequestsController).isNotNull();
        assertThat(tablesController).isNotNull();
    }

}
