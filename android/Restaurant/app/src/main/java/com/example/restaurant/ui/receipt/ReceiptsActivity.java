package com.example.restaurant.ui.receipt;

import static com.example.restaurant.ui.login.LoginActivity.EMPLOYEE_ID;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.example.restaurant.db.AppDatabase;
import com.example.restaurant.entities.Dish;
import com.example.restaurant.entities.DishCategory;
import com.example.restaurant.entities.Order;
import com.example.restaurant.entities.Receipt;
import com.example.restaurant.handlers.FailureErrorHandler;
import com.example.restaurant.handlers.ResponseErrorHandler;
import com.example.restaurant.ui.settings.SettingsActivity;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class that controls what can happen on receipts activity
 */
public class ReceiptsActivity extends AppCompatActivity {

    public static final String RECEIPT = "receipt";

    private RecyclerView recyclerView;
    private ReceiptsRecyclerViewAdapter adapter;
    private ProgressBar progressBar;

    private Timer timer;

    private int unhandledReceiptsCount;

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

        if (timer != null)
            timer.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();

        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

        new Thread(this::getReceipts).start();
    }

    private void initViews() {
        progressBar = findViewById(R.id.progress_bar_receipts);
        progressBar.setVisibility(View.VISIBLE);

        recyclerView = findViewById(R.id.recycler_view_receipts);
        setUpRecyclerView();

    }

    private void setUpRecyclerView() {
        recyclerView.setHasFixedSize(true);
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
    }


    private void getReceipts() {
        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.shared_preference_file_key), Context.MODE_PRIVATE);
        long employeeId = sharedPref.getLong(EMPLOYEE_ID, -1L);

        // If there are no dishes download them first
        downloadDishesIfNotAvailable();

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
                } else {
                    new ResponseErrorHandler<>(response, ReceiptsActivity.this)
                            .errorDialog(
                                    getString(R.string.error_downloading_receipts),
                                    (dialog, id) -> new Thread(() -> getReceipts()).start(),
                                    true
                            );
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Receipt>> call, @NonNull Throwable t) {
                new FailureErrorHandler(t, ReceiptsActivity.this)
                        .errorDialog(
                                getString(R.string.error_downloading_receipts),
                                (dialog, id) -> new Thread(() -> getReceipts()).start(),
                                true
                        );
            }
        });
    }

    private void downloadDishesIfNotAvailable() {
        AppDatabase db = AppDatabase.getAppDatabase(this);
        if (db.dishesDao().getDishCount() == 0) {
            Call<List<DishCategory>> call = App.interfaceApi.getDishes();

            try {
                Response<List<DishCategory>> response = call.execute();
                if (response.isSuccessful() && response.body() != null) {
                    List<DishCategory> categories = response.body();

                    for (DishCategory category : categories) {
                        db.dishCategoriesDao().insert(category);
                        for (Dish dish : category.getDishes()) {
                            db.dishesDao().insert(dish);
                        }
                    }
                } else {
                    new ResponseErrorHandler<>(response, ReceiptsActivity.this)
                            .errorDialog(
                                    getString(R.string.error_downloading_dishes),
                                    (dialog, id) -> new Thread(this::getReceipts).start(),
                                    true
                            );
                }
            } catch (IOException e) {
                new FailureErrorHandler(e, ReceiptsActivity.this)
                        .errorDialog(
                                getString(R.string.error_downloading_dishes),
                                (dialog, id) -> new Thread(this::getReceipts).start(),
                                true
                        );
            }
        }
    }

    private void scheduleUpdates() {
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                unhandledReceiptsCount = adapter.getItemCount() - 1;

                if (unhandledReceiptsCount == 0) {
                    runOnUiThread(() -> {
                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                    });
                } else {
                    for (int i = 0; i < unhandledReceiptsCount; i++) {
                        getOrders(i);
                    }
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
                            tryShowRecyclerView();
                        });
                    }).start();
                } else {
                    runOnUiThread(() -> tryShowRecyclerView());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Order>> call, @NonNull Throwable t) {
                runOnUiThread(() -> tryShowRecyclerView());
            }
        });
    }

    private void tryShowRecyclerView() {
        if (--unhandledReceiptsCount == 0) {
            progressBar.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }
}