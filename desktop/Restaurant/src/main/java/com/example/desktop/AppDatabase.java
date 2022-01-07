package com.example.desktop;

import com.example.desktop.entities.Dish;
import com.example.desktop.entities.Employee;
import com.example.desktop.entities.Order;
import com.example.desktop.entities.Product;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AppDatabase {
    private static AppDatabase db;

    private final List<Product> products;
    private List<Employee> employees;
    private final List<Employee> loggedInEmployees;
    private final List<Dish> dishes;
    private List<Order> ordersPlaced;
    private List<Order> ordersInProgress;


    public static synchronized AppDatabase getAppDatabase() {
        if (db == null) {
            db = new AppDatabase();
        }
        return db;
    }

    private AppDatabase() {
        products = new ArrayList<>();
        employees = new ArrayList<>();
        loggedInEmployees = new ArrayList<>();
        dishes = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    // Note: that this function should be called on separate thread!
    // Because it may potentially lock UI
    public List<Employee> getEmployeesDownloadIfEmpty() {
        if (employees.size() == 0)
            downloadEmployees();
        return employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public List<Employee> getLoggedInEmployees() {
        return loggedInEmployees;
    }

    public void logIn(Employee employee) {
        loggedInEmployees.add(employee);
    }

    public void logOut(Employee employee) {
        loggedInEmployees.remove(employee);
    }

    public List<Order> getOrdersPlaced() {
        return ordersPlaced;
    }

    public List<Order> getOrdersInProgress() {
        return ordersInProgress;
    }

    // Note: that this function should be called on separate thread!
    // Because it may potentially lock UI
    public Product getProductById(Long productId) {
        Optional<Product> productOptional = products.stream()
                .filter(product -> product != null && Objects.equals(product.getId(), productId))
                .findFirst();
        if (productOptional.isPresent()) {
            return productOptional.get();
        } else {
            try {
                Call<Product> call = App.interfaceApi.getProductById(productId);
                Response<Product> response = call.execute();
                if (response.isSuccessful() && response.body() != null) {
                    products.add(response.body());
                    return response.body();
                } //else {
                // TODO: Handel response error
                //}
            } catch (IOException e) {
                // TODO: Handel failure error
            }
            // TODO: Handle not found error
            return null;
        }
    }

    // Note: that this function should be called on separate thread!
    // Because it may potentially lock UI
    public synchronized Employee getEmployeeById(Long employeeId) {
        if (employees.size() == 0) {
            downloadEmployees();
        }
        Optional<Employee> employeeOptional = employees.stream()
                .filter(employee -> employee != null && Objects.equals(employee.getId(), employeeId))
                .findFirst();

        return employeeOptional.orElse(null);
        // TODO: Handle not found error when returned employee is null
    }

    public void downloadEmployees() {
        try {
            Call<List<Employee>> call = App.interfaceApi.getCooks();
            Response<List<Employee>> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                employees = response.body();
            } //else {
            // TODO: Handel response error
            //}
        } catch (IOException e) {
            // TODO: Handel failure error
        }
    }

    public void downloadOrdersPlaced(){
        try {
            Call<List<Order>> call = App.interfaceApi.getOrdersPlaced();
            Response<List<Order>> res = call.execute();
            if (res.isSuccessful() && res.body() != null) {
                ordersPlaced = res.body();
            } //else {
            // TODO: Handel response error
            //}
        } catch (IOException e) {
            // TODO: Handel failure error
        }
    }

    public void downloadOrdersInProgress(){
        try {
            Call<List<Order>> call = App.interfaceApi.getOrdersInProgress();
            Response<List<Order>> res = call.execute();
            if (res.isSuccessful() && res.body() != null) {
                ordersInProgress = res.body();
            } //else {
            // TODO: Handel response error
            //}
        } catch (IOException e) {
            // TODO: Handel failure error
        }
    }



    // Note: that this function should be called on separate thread!
    // Because it may potentially lock UI
    public Dish getDishById(Long dishId) {
        Optional<Dish> dishOptional = dishes.stream()
                .filter(dish -> dish != null && Objects.equals(dish.getId(), dishId))
                .findFirst();
        if (dishOptional.isPresent()) {
            return dishOptional.get();
        } else {
            try {
                Call<Dish> call = App.interfaceApi.getDishById(dishId);
                Response<Dish> response = call.execute();
                if (response.isSuccessful() && response.body() != null) {
                    dishes.add(response.body());
                    return response.body();
                } //else {
                // TODO: Handel response error
                //}
            } catch (IOException e) {
                // TODO: Handel failure error
            }
            // TODO: Handle not found error
            return null;
        }
    }

}