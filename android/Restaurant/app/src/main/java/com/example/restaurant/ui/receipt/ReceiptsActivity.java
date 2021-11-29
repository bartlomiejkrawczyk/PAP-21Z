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

    private void initViews() {
        recyclerView = findViewById(R.id.recycler_view_receipts);
        recyclerView.setHasFixedSize(true);

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
        Timer t = new Timer();

        t.schedule(new TimerTask() {
            @Override
            public void run() {
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
                    runOnUiThread(() -> {
                        adapter.getReceipts().get(position).setOrders(response.body());
                        adapter.notifyItemChanged(position);
                    });
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Order>> call, @NonNull Throwable t) {
                Log.e("ORDERS", t.getMessage());
            }
        });
    }
}