package com.example.restaurant;


import com.example.restaurant.entities.DishCategory;
import com.example.restaurant.entities.Employee;
import com.example.restaurant.entities.Order;
import com.example.restaurant.entities.Receipt;
import com.example.restaurant.entities.Table;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface InterfaceApi {
    @GET("api")
    Call<String> getHelloWorld();

    @GET("img/{file}")
    Call<ResponseBody> getImage(@Path("file") String filePath);

    @GET("api/employees/names/1")
    Call<List<Employee>> getWaiters();

    @GET("api/dishCategories/mobile")
    Call<List<DishCategory>> getDishes();

    @GET("api/receipts/employee/{employee}")
    Call<List<Receipt>> getReceipts(@Path("employee") Long employeeId);

    @GET("api/orders/receipt/{receipt}")
    Call<List<Order>> getOrders(@Path("receipt") Long receiptId);

    @GET("api/tables/all")
    Call<List<Table>> getTables();

    @POST("api/receipts")
    Call<Receipt> addReceipt(@Body Receipt receipt);

    @PUT("api/receipts/{receipt}")
    Call<Receipt> updateReceipt(@Path("receipt") Long receiptId, @Body Receipt receipt);

    @DELETE("api/receipts/{receipt}")
    Call<Void> deleteReceipt(@Path("receipt") Long receiptId);

    @POST("api/orders")
    Call<Order> addOrder(@Body Order order);

    @DELETE("api/orders/{order}")
    Call<Void> deleteOrder(@Path("order") Long id);
}
