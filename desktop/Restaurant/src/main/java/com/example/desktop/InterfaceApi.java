package com.example.desktop;

import com.example.desktop.entities.Employee;
import com.example.desktop.entities.Order;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface InterfaceApi {
    @GET("api")
    Call<String> getHelloWorld();

    @GET("img/{file}")
    Call<ResponseBody> getImage(@Path("file") String filePath);

    @GET("employees/all")
    Call<List<Employee>> getEmployees();

    @GET("orders/all")
    Call<List<Order>> getOrders();
}
