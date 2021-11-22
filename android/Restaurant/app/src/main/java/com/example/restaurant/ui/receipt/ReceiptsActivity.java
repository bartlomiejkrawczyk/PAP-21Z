package com.example.restaurant.ui.receipt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant.App;
import com.example.restaurant.R;
import com.example.restaurant.entities.Receipt;
import com.example.restaurant.ui.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReceiptsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ReceiptsRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipts);

        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recycler_view_receipts);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adapter = new ReceiptsRecyclerViewAdapter();

        adapter.setOnClickListener(receipt -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);

        new Thread(this::getReceipts).start();
    }

    private void getReceipts() {
        Call<List<Receipt>> call = App.interfaceApi.getReceipts();
        call.enqueue(new Callback<List<Receipt>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<List<Receipt>> call, @NonNull Response<List<Receipt>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Receipt> receipts = response.body();
                    adapter.setReceipts(receipts);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Receipt>> call, @NonNull Throwable t) {

            }
        });
    }
}