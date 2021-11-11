package com.example.restaurant;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface InterfaceApi {
    @GET("api")
    Call<String> getHelloWorld();

    @GET("img/{file}")
    Call<ResponseBody> getImage(@Path("file") String filePath);
}
