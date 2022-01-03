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

public class TableUtils {
    private final Context context;

    public TableUtils(Context context) {
        this.context = context;
    }

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
                // else do nothing
            }

            @Override
            public void onFailure(@NonNull Call<List<Table>> call, @NonNull Throwable t) {
                // do nothing
            }
        });
    }
}
