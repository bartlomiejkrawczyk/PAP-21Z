package com.example.desktop;

import com.example.desktop.entities.Dish;
import com.example.desktop.entities.Employee;
import com.example.desktop.entities.Order;
import com.example.desktop.entities.Product;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A pseudo database class - class that stores values of current session in one place with convenient access
 */
public class AppDatabase {
    private static AppDatabase db;

    private List<Product> products;
    private List<Employee> employees;
    private final List<Employee> loggedInEmployees;
    private final List<Dish> dishes;
    private List<Order> ordersPlaced;
    private List<Order> ordersInProgress;

    /**
     * if there is not local databes, downloads one
     * @return database
     */
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
        ordersPlaced = new ArrayList<>();
        ordersInProgress = new ArrayList<>();
    }

    // Note: that this function should be called on separate thread!
    // Because it may potentially lock UI
    /**
     * Downloads employees if there is no downloaded.
     * @return list of Employee objects
     */
    public List<Employee> getEmployeesDownloadIfEmpty() {
        if (employees.size() == 0)
            downloadEmployees();
        return employees;
    }

    public List<Employee> getLoggedInEmployees() {
        return loggedInEmployees;
    }

    /**
     * Adds given employee to list of logged in.
     * @param employee
     */
    public void logIn(Employee employee) {
        loggedInEmployees.add(employee);
    }

    /**
     * Removes given employee from list of logged in.
     * @param employee
     */
    public void logOut(Employee employee) {
        loggedInEmployees.remove(employee);
    }

    public List<Order> getOrdersPlaced() {
        return ordersPlaced;
    }

    public List<Order> getOrdersInProgress() {
        return ordersInProgress;
    }

    /**
     * Add order to ordersInProgress and sort them by employee id.
     * @param order
     */
    public void addOrderInProgress(Order order) {
        ordersInProgress.add(order);
        ordersInProgress.sort(Comparator.comparing(o -> o.getEmployee().getId()));
    }

    // Note: that this function should be called on separate thread!
    // Because it may potentially lock UI
    /**
     * Downloads list of products of there is none.
     * @return
     */
    public List<Product> getProductsDownloadIfEmpty() {
        if (products.size() == 0)
            downloadProducts();
        return products;
    }

    // Note: that this function should be called on separate thread!
    // Because it may potentially lock UI

    /**
     * If there is no downloaded products, downloads all.
     * Get product by its id.
     * @param productId
     * @return product of given id
     */
    public synchronized Product getProductById(Long productId) {
        if (products.size() == 0) {
            downloadProducts();
        }
        Optional<Product> productOptional = products.stream()
                .filter(product -> product != null && Objects.equals(product.getId(), productId))
                .findFirst();

        return productOptional.orElse(null);
    }

    // Note: that this function should be called on separate thread!
    // Because it may potentially lock UI

    /**
     * Download products from real database. If error occurs, it's properly raised.
     */
    public void downloadProducts() {
        try {
            Call<List<Product>> call = App.interfaceApi.getProducts();
            Response<List<Product>> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                products = response.body();
            } else {
                JOptionPane.showMessageDialog(
                        new JFrame(),
                        response.message(),
                        "Response error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    new JFrame(),
                    e,
                    "Failure error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Note: that this function should be called on separate thread!
    // Because it may potentially lock UI

    /**
     * If there is no employees, downloads all.
     * Get employee of given id.
     * @param employeeId
     * @return employee with given id
     */
    public synchronized Employee getEmployeeById(Long employeeId) {
        if (employees.size() == 0) {
            downloadEmployees();
        }
        Optional<Employee> employeeOptional = employees.stream()
                .filter(employee -> employee != null && Objects.equals(employee.getId(), employeeId))
                .findFirst();

        return employeeOptional.orElse(null);
    }

    /**
     * Download all employees from real database. If error occurs, it's properly raised.
     */
    public void downloadEmployees() {
        try {
            Call<List<Employee>> call = App.interfaceApi.getCooks();
            Response<List<Employee>> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                employees = response.body();
            } else {
                JOptionPane.showMessageDialog(
                        new JFrame(),
                        response.message(),
                        "Response error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    new JFrame(),
                    e,
                    "Failure error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Note: that this function should be called on separate thread!
    // Because it may potentially lock UI

    /**
     * Download placed orders from real database. If error occurs, it's properly raised.
     */
    public void downloadOrdersPlaced(){
        try {
            Call<List<Order>> call = App.interfaceApi.getOrdersPlaced();
            Response<List<Order>> res = call.execute();
            if (res.isSuccessful() && res.body() != null) {
                ordersPlaced = res.body();
            } else {
                JOptionPane.showMessageDialog(
                        new JFrame(),
                        res.message(),
                        "Response error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    new JFrame(),
                    e,
                    "Failure error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    // Note: that this function should be called on separate thread!
    // Because it may potentially lock UI

    /**
     * Download orders in progress from real database. If error occurs, it's properly raised.
     */
    public void downloadOrdersInProgress(){
        try {
            Call<List<Order>> call = App.interfaceApi.getOrdersInProgress();
            Response<List<Order>> res = call.execute();
            if (res.isSuccessful() && res.body() != null) {
                ordersInProgress = res.body()
                        .stream()
                        .sorted(Comparator.comparing(o -> o.getEmployee().getId()))
                        .collect(Collectors.toList());
                for (Order order : ordersInProgress) {
                    order.setEmployee(getEmployeeById(order.getEmployee().getId()));
                }
            } else {
                JOptionPane.showMessageDialog(
                        new JFrame(),
                        res.message(),
                        "Response error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    new JFrame(),
                    e,
                    "Failure error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Note: that this function should be called on separate thread!
    // Because it may potentially lock UI

    /**
     * Uses other functions to download both placed and in progress orders.
     */
    public void downloadOrders() {
        downloadOrdersPlaced();
        downloadOrdersInProgress();
    }

    /**
     * Automatically logs in employees with assigned orders.
     */
    public void loginEmployeesWithOrders() {
        List<Employee> employees = ordersInProgress.stream()
                .map(Order::getEmployee)
                .distinct()
                .collect(Collectors.toList());

        loggedInEmployees.addAll(employees);
    }

    /**
     * Checks if employee can log out/doesn't have assigned order.
     * @param employee
     * @return result
     */
    public boolean employeeCanLogOut(Employee employee) {
        return ordersInProgress.stream()
                .map(Order::getEmployee)
                .noneMatch(employee1 -> employee == employee1);
    }

    /**
     * Download order image from real database. If error occurs, it's properly raised.
     * @param imagePath
     * @return
     */
    public BufferedImage getImage(String imagePath) {
        BufferedImage bufferedImage = null;

        File directory = new File(System.getProperty("user.dir") + File.separator + "images" + File.separator);
        boolean dirExists = directory.exists();
        if (!dirExists) {
            dirExists = directory.mkdir();
        }

        boolean successful = false;

        if (dirExists) {
            File file = new File(System.getProperty("user.dir") + File.separator + "images" + File.separator + imagePath);

            if (file.exists()) {
                try {
                    bufferedImage = ImageIO.read(file);
                    successful = true;
                } catch (IOException ignored) {
                }
            }
        }

        if (!successful) {
            try {
                Call<ResponseBody> call = App.interfaceApi.getImage(imagePath);
                Response<ResponseBody> response = call.execute();
                if (response.isSuccessful() && response.body() != null) {
                    byte[] img = response.body().bytes();
                    InputStream is = new ByteArrayInputStream(img);
                    bufferedImage = ImageIO.read(is);

                    saveBufferedImage(bufferedImage, imagePath);
                } else {
                    JOptionPane.showMessageDialog(
                            new JFrame(),
                            response.message(),
                            "Response error",
                            JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(
                        new JFrame(),
                        e,
                        "Failure error",
                        JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }

        return bufferedImage;
    }

    /**
     * Saves image to given path.
     * @param image
     * @param imagePath
     */
    private void saveBufferedImage(BufferedImage image, String imagePath) {
        File directory = new File(System.getProperty("user.dir") + File.separator + "images" + File.separator);
        boolean dirExists = directory.exists();

        if (!dirExists) {
            dirExists = directory.mkdir();
        }

        if (dirExists) {
            try {
                File outputFile = new File(System.getProperty("user.dir") + File.separator + "images" + File.separator + imagePath);
                ImageIO.write(image, "jpg", outputFile);
            } catch (IOException ignored) {
            }
        }

    }

    // Note: that this function should be called on separate thread!
    // Because it may potentially lock UI

    /**
     * Get dish of given id.
     * @param dishId
     * @return
     */
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
                } else {
                    JOptionPane.showMessageDialog(
                            new JFrame(),
                            response.message(),
                            "Response error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(
                        new JFrame(),
                        e,
                        "Failure error",
                        JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(
                    new JFrame(),
                    "File not found",
                    "Not found error",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Note: that this function should be called on separate thread!
    // Because it may potentially lock UI

    /**
     * Assign order to employee, set him as with assignment.
     * @param order
     * @param employeeId
     */
    public void setEmployeePreparingOrder(Order order, Long employeeId) {
        Long orderId = order.getId();
        try {
            Call<Order> call = App.interfaceApi.setEmployeePreparingOrder(orderId, employeeId);
            Response<Order> res = call.execute();
            if (res.isSuccessful() && res.body() != null) {
                order.setEmployee(getEmployeeById(employeeId));
            } else {
                JOptionPane.showMessageDialog(
                        new JFrame(),
                        res.message(),
                        "Response error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    new JFrame(),
                    e,
                    "Failure error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Note: that this function should be called on separate thread!
    // Because it may potentially lock UI

    /**
     * Sets order status as advanced/in progress.
     * @param order
     */
    public void advanceOrderStatus(Order order) {
        Long orderId = order.getId();
        try {
            Call<Order> call = App.interfaceApi.advanceOrderStatus(orderId);
            Response<Order> res = call.execute();
            if (res.isSuccessful() && res.body() != null) {
                order.setStatus(2);
            } else {
                JOptionPane.showMessageDialog(
                        new JFrame(),
                        res.message(),
                        "Response error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    new JFrame(),
                    e,
                    "Failure error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Increase given product by given number.
     * @param product
     * @param quantity
     */
    public void incrementProductQuantity(Product product, Long quantity) {
        Call<Product> call = App.interfaceApi.increaseProductQuantity(product.getId(), quantity);
        try {
            Response<Product> res = call.execute();
            if (res.isSuccessful() && res.body() != null) {
                product.setQuantity(res.body().getQuantity());
            } else {
                JOptionPane.showMessageDialog(
                        new JFrame(),
                        res.message(),
                        "Response error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    new JFrame(),
                    e,
                    "Failure error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
