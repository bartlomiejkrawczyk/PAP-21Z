package com.example.restaurant;


import com.example.restaurant.entities.DishCategory;
import com.example.restaurant.entities.Employee;
import com.example.restaurant.entities.Order;
import com.example.restaurant.entities.Receipt;
import com.example.restaurant.entities.SpecialRequest;
import com.example.restaurant.entities.Table;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Interface with defined functions,
 * used by retrofit to generate methods,
 * that fetch data from server
 *
 * @see Retrofit
 */
public interface InterfaceApi {

    @GET("img/restaurant/{file}")
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

    @PUT("api/orders/status/{order}/{status}")
    Call<Order> advanceOrder(@Path("order") Long orderId, @Path("status") int status);

    @DELETE("api/orders/{order}")
    Call<Void> deleteOrder(@Path("order") Long id);

    @POST("api/specialRequests")
    Call<SpecialRequest> addRequest(@Body SpecialRequest request);

    @DELETE("api/specialRequests/{request}")
    Call<Void> deleteRequest(@Path("request") Long request);
}
