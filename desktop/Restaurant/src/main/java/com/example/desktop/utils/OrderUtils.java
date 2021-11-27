package com.example.desktop.utils;

import com.example.desktop.App;
import com.example.desktop.entities.Order;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class OrderUtils {
    public static void downloadOrders() {
        Call<List<Order>> call = App.interfaceApi.getOrdersStatus1();
        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if (response.isSuccessful() && response.body() != null) {

                }
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable throwable) {

            }
        });
    }

}
