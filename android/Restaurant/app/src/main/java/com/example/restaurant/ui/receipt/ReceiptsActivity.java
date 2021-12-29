package com.example.restaurant.ui.receipt;

import static com.example.restaurant.ui.login.LoginActivity.EMPLOYEE_ID_KEY;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant.App;
import com.example.restaurant.R;
import com.example.restaurant.entities.Order;
import com.example.restaurant.entities.Receipt;
import com.example.restaurant.ui.settings.SettingsActivity;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReceiptsActivity extends AppCompatActivity {

    public static final String RECEIPT = "receipt";

    private RecyclerView recyclerView;
    private ReceiptsRecyclerViewAdapter adapter;
    private ProgressBar progressBar;

    private Timer timer;

    private int orderCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipts);

        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();

        timer.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();

        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

        getReceipts();
    }

    private void initViews() {
        progressBar = findViewById(R.id.progress_bar_receipts);

        recyclerView = findViewById(R.id.recycler_view_receipts);
        recyclerView.setHasFixedSize(true);

        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adapter = new ReceiptsRecyclerViewAdapter();

        adapter.setOnClickListener(receipt -> {
            Intent intent = new Intent(this, ReceiptActivity.class);
            intent.putExtra(RECEIPT, receipt);
            startActivity(intent);
        });

        adapter.setOnButtonClickListener(view -> {
            Intent intent = new Intent(this, ReceiptActivity.class);
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);

        new Thread(this::getReceipts).start();
    }


    private void getReceipts() {
        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.shared_preference_file_key), Context.MODE_PRIVATE);
        long employeeId = sharedPref.getLong(EMPLOYEE_ID_KEY, -1L);
        Call<List<Receipt>> call = App.interfaceApi.getReceipts(employeeId);
        call.enqueue(new Callback<List<Receipt>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<List<Receipt>> call, @NonNull Response<List<Receipt>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Receipt> receipts = response.body();

                    adapter.setReceipts(receipts);

                    scheduleUpdates();

                    runOnUiThread(() -> adapter.notifyDataSetChanged());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Receipt>> call, @NonNull Throwable t) {

            }
        });
    }

    private void scheduleUpdates() {
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                orderCount = adapter.getItemCount() - 1;
                for (int i = 0; i < adapter.getItemCount() - 1; i++) {
                    getOrders(i);
                }
            }
        }, 0, 20000);
    }

    private void getOrders(int position) {
        Call<List<Order>> call = App.interfaceApi.getOrders(adapter.getReceipts().get(position).getId());
        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(@NonNull Call<List<Order>> call, @NonNull Response<List<Order>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Order> orders = response.body();
                    new Thread(() -> {
                        for (Order order : orders) {
                            order.getDish().fetchData(ReceiptsActivity.this);
                        }
                        runOnUiThread(() -> {
                            adapter.getReceipts().get(position).setOrders(orders);
                            adapter.notifyItemChanged(position);
                            if (--orderCount == 0) {
                                progressBar.setVisibility(View.GONE);
                                recyclerView.setVisibility(View.VISIBLE);
                            }
                        });

                    }).start();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Order>> call, @NonNull Throwable t) {
                Log.e("ORDERS", t.getMessage());
                runOnUiThread(() -> {
                    if (--orderCount == 0) {
                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                    }
                });
            }
        });
    }
}