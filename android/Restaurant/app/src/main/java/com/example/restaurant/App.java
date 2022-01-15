package com.example.restaurant;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.restaurant.utils.DishUtils;
import com.example.restaurant.utils.TableUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Base android application class
 * - this is the starting class - defined in Android manifest
 */
public class App extends Application {

    public static InterfaceApi interfaceApi;

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); // Skip the night mode for now
        createNetworkSys();
        updateData();
    }

    /**
     * Initialize Network System:
     * logging interceptor,
     * json converter,
     * retrofit interface
     *
     * @see OkHttpClient
     * @see Gson
     * @see Retrofit
     * @see InterfaceApi
     */
    private void createNetworkSys() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();


        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .serializeNulls()
                .setLenient()
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(getString(R.string.base_url))
                .client(okHttpClient)
                .build();

        interfaceApi = retrofit.create(InterfaceApi.class);
    }

    /**
     * On startup download dishes and tables
     * - it isn't necessary if the data hasn't changed between
     * two separate application starts
     */
    private void updateData() {
        new DishUtils(getApplicationContext()).downloadDishes();
        new TableUtils(getApplicationContext()).downloadTables();
    }
}