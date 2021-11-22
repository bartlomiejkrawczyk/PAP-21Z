package com.example.restaurant;


import com.example.restaurant.entities.DishCategory;
import com.example.restaurant.entities.Employee;
import com.example.restaurant.entities.Receipt;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
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

    @GET("api/receipts/all")
    Call<List<Receipt>> getReceipts();
}
