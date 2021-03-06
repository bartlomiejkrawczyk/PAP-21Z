package com.example.restaurant.utils;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.restaurant.App;
import com.example.restaurant.db.AppDatabase;
import com.example.restaurant.entities.Dish;
import com.example.restaurant.entities.DishCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class used to download dishes and save them into the local database
 */
public class DishUtils {
    private final Context context;

    public DishUtils(Context context) {
        this.context = context;
    }


    /**
     * Download all the dishes from the database and save them to the local database
     * if there are those dishes in the database already - replace them
     */
    public void downloadDishes() {
        Call<List<DishCategory>> call = App.interfaceApi.getDishes();
        call.enqueue(new Callback<List<DishCategory>>() {
            @Override
            public void onResponse(@NonNull Call<List<DishCategory>> call, @NonNull Response<List<DishCategory>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<DishCategory> categories = response.body();

                    new Thread(() -> {
                        AppDatabase db = AppDatabase.getAppDatabase(context);
                        for (DishCategory category : categories) {
                            db.dishCategoriesDao().insert(category);
                            for (Dish dish : category.getDishes()) {
                                db.dishesDao().insert(dish);
                            }
                        }
                    }).start();
                }
                // else do nothing -> updating data isn't necessary
            }

            @Override
            public void onFailure(@NonNull Call<List<DishCategory>> call, @NonNull Throwable t) {
                // do nothing -> updating data isn't necessary
            }
        });
    }

}
