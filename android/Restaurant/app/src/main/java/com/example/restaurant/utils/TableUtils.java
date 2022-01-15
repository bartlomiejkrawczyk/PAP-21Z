package com.example.restaurant.utils;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.restaurant.App;
import com.example.restaurant.db.AppDatabase;
import com.example.restaurant.entities.Table;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class used to download tables and save them into the local database
 */
public class TableUtils {
    private final Context context;

    public TableUtils(Context context) {
        this.context = context;
    }

    /**
     * Download all the tables from the database and save them to the local database
     * if there are those tables in the database already - replace them
     */
    public void downloadTables() {
        Call<List<Table>> call = App.interfaceApi.getTables();
        call.enqueue(new Callback<List<Table>>() {
            @Override
            public void onResponse(@NonNull Call<List<Table>> call, @NonNull Response<List<Table>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Table> tables = response.body();

                    new Thread(() -> {
                        AppDatabase db = AppDatabase.getAppDatabase(context);

                        for (Table table : tables)
                            db.tablesDao().insert(table);
                    }).start();
                }
                // else do nothing -> updating data isn't necessary
            }

            @Override
            public void onFailure(@NonNull Call<List<Table>> call, @NonNull Throwable t) {
                // do nothing -> updating data isn't necessary
            }
        });
    }
}
