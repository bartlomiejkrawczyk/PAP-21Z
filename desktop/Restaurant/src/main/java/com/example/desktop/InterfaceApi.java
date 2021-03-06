package com.example.desktop;

import com.example.desktop.entities.Dish;
import com.example.desktop.entities.Employee;
import com.example.desktop.entities.Order;
import com.example.desktop.entities.Product;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import java.util.List;

/**
 * Interface with defined functions,
 * used by retrofit to generate methods,
 * that fetch data from server
 *
 * @see retrofit2.Retrofit
 */
public interface InterfaceApi {

    @GET("img/restaurant/{file}")
    Call<ResponseBody> getImage(@Path("file") String filePath);

    @GET("api/employees/kind/2")
    Call<List<Employee>> getCooks();

    @GET("api/orders/desktop/placed/1")
    Call<List<Order>> getOrdersPlaced();

    @GET("api/orders/desktop/progress/1")
    Call<List<Order>> getOrdersInProgress();

    @GET("api/dishes/{id}")
    Call<Dish> getDishById(@Path("id") Long id);

    @GET("api/products/all")
    Call<List<Product>> getProducts();

    @PUT("api/products/{id}/{quantity}")
    Call<Product> increaseProductQuantity(@Path("id") Long id, @Path("quantity") Long quantity);

    @PUT("api/orders/employee/{orderId}/{employeeId}")
    Call<Order> setEmployeePreparingOrder(@Path("orderId") Long orderId, @Path("employeeId") Long employeeId);

    @PUT("api/orders/status/{orderId}/2")
    Call<Order> advanceOrderStatus(@Path("orderId") Long orderId);
}
