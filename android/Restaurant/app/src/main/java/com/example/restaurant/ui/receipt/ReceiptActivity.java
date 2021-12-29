package com.example.restaurant.ui.receipt;

import static com.example.restaurant.ui.login.LoginActivity.EMPLOYEE_ID_KEY;
import static com.example.restaurant.ui.receipt.ReceiptsActivity.RECEIPT;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurant.App;
import com.example.restaurant.R;
import com.example.restaurant.db.AppDatabase;
import com.example.restaurant.entities.Dish;
import com.example.restaurant.entities.Employee;
import com.example.restaurant.entities.Order;
import com.example.restaurant.entities.Receipt;
import com.example.restaurant.entities.Table;
import com.example.restaurant.ui.dish.DishCategoriesActivity;
import com.example.restaurant.ui.request.RequestsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReceiptActivity extends AppCompatActivity {

    private TextView textViewTotal;
    private List<Table> tables;
    private Spinner spinner;
    private LinearLayout linearLayout;
    private Button button;

    private Receipt receipt;

    private ActivityResultLauncher<Intent> requestActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        Intent previous = getIntent();
        receipt = (Receipt) previous.getSerializableExtra(RECEIPT);

        if (receipt == null) {
            initNewReceipt();
        } else {
            SharedPreferences sharedPref = this.getSharedPreferences(
                    getString(R.string.shared_preference_file_key), Context.MODE_PRIVATE);
            long employeeId = sharedPref.getLong(EMPLOYEE_ID_KEY, -1L);
            receipt.setEmployee(new Employee(employeeId));
        }

        initViews(receipt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.receipt, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_close_receipt) {
            int total = 0;
            for (Order order : receipt.getOrders()) {
                total += order.getDish().getPrice();
            }
            receipt.setPayment(total);
            Call<Receipt> call = App.interfaceApi.updateReceipt(receipt.getId(), receipt);
            call.enqueue(new Callback<Receipt>() {
                @Override
                public void onResponse(@NonNull Call<Receipt> call, @NonNull Response<Receipt> response) {
                    if (response.isSuccessful()) {
                        finish();
                    } else
                        Toast.makeText(ReceiptActivity.this, "Error: " + response.code(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(@NonNull Call<Receipt> call, @NonNull Throwable t) {
                    Toast.makeText(ReceiptActivity.this, getString(R.string.receipt_activity_internet_error), Toast.LENGTH_LONG).show();
                }
            });
        } else if (id == R.id.menu_delete_receipt) {
            Call<Void> call = App.interfaceApi.deleteReceipt(receipt.getId());
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                    if (!response.isSuccessful())
                        Toast.makeText(ReceiptActivity.this, "Error: " + response.code(), Toast.LENGTH_LONG).show();
                    else
                        finish();
                }

                @Override
                public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                    Toast.makeText(ReceiptActivity.this, getString(R.string.receipt_activity_internet_error), Toast.LENGTH_LONG).show();
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }

    private void initNewReceipt() {
        receipt = new Receipt();
        receipt.setPayment(0);
        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.shared_preference_file_key), Context.MODE_PRIVATE);
        long employeeId = sharedPref.getLong(EMPLOYEE_ID_KEY, -1L);
        receipt.setEmployee(new Employee(employeeId));
        Call<Receipt> call = App.interfaceApi.addReceipt(receipt);
        call.enqueue(new Callback<Receipt>() {
            @Override
            public void onResponse(@NonNull Call<Receipt> call, @NonNull Response<Receipt> response) {
                if (response.isSuccessful() && response.body() != null) {
                    receipt.setId(response.body().getId()); // TODO: Add loading indicator
                } else {
                    tryAgain();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Receipt> call, @NonNull Throwable t) {
                tryAgain();
            }
        });
    }

    private void tryAgain() {
        Toast.makeText(this, getString(R.string.receipt_activity_adding_receipt_failed), Toast.LENGTH_LONG).show();
        finish();
    }

    private void initViews(Receipt receipt) {

        textViewTotal = findViewById(R.id.text_view_total_receipt);
        updateTotal(receipt);

        spinner = findViewById(R.id.spinner_tables_receipt);
        tables = new ArrayList<>();
        tables.add(new Table(null, getString(R.string.spinner_item_takeaway)));
        ArrayAdapter<Table> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tables);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


        new Thread(() -> {
            AppDatabase db = AppDatabase.getAppDatabase(this);
            List<Table> daoTables = db.tablesDao().getTables();
            tables.addAll(daoTables);
            adapter.notifyDataSetChanged();
            Table table = receipt.getTable();
            if (table != null)
                for (int i = 0; i < daoTables.size(); i++) {
                    if (daoTables.get(i).getId().equals(table.getId())) {
                        spinner.setSelection(i + 1);
                        break;
                    }
                }
        }).start();

        spinner.post(() -> spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (position != 0)
                    receipt.setTable(tables.get(position));
                else
                    receipt.setTable(null);
                Call<Receipt> call = App.interfaceApi.updateReceipt(receipt.getId(), receipt);
                call.enqueue(new Callback<Receipt>() {
                    @Override
                    public void onResponse(@NonNull Call<Receipt> call, @NonNull Response<Receipt> response) {
                        // Do nothing
                        if (!response.isSuccessful())
                            Toast.makeText(ReceiptActivity.this, "Error: " + response.code(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(@NonNull Call<Receipt> call, @NonNull Throwable t) {
                        Toast.makeText(ReceiptActivity.this, getString(R.string.receipt_activity_internet_error), Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        }));

        linearLayout = findViewById(R.id.linear_layout_orders_receipt);

        List<Order> orders = receipt.getOrders();
        if (orders == null) {
            orders = new ArrayList<>();
            receipt.setOrders(orders);
        }
        for (Order order : orders)
            displayOrder(order);

        button = findViewById(R.id.button_add_order_receipt);

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            long dishId = data.getLongExtra("dish", -1L);

                            new Thread(() -> {
                                Dish dish = AppDatabase.getAppDatabase(ReceiptActivity.this).dishesDao().getDishById(dishId);

                                Order order = new Order(null, System.currentTimeMillis(), dish, receipt.getId(), new ArrayList<>(), 1);

                                Call<Order> call = App.interfaceApi.addOrder(order);
                                call.enqueue(new Callback<Order>() {
                                    @Override
                                    public void onResponse(@NonNull Call<Order> call, @NonNull Response<Order> response) {
                                        if (response.isSuccessful()) {
                                            displayOrder(order);
                                            receipt.getOrders().add(order);
                                            updateTotal(receipt);
                                        } else
                                            Toast.makeText(ReceiptActivity.this, "Error: " + response.code(), Toast.LENGTH_LONG).show();
                                    }

                                    @Override
                                    public void onFailure(@NonNull Call<Order> call, @NonNull Throwable t) {
                                        Toast.makeText(ReceiptActivity.this, getString(R.string.receipt_activity_internet_error), Toast.LENGTH_LONG).show();
                                    }
                                });
                            }).start();
                        }
                    }
                });

        requestActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            Order updatedOrder = (Order) data.getSerializableExtra("order");
                            for (Order o : receipt.getOrders())
                                if (o.getId().equals(updatedOrder.getId()))
                                    o.setRequests(updatedOrder.getRequests());
                        }
                    }
                });

        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, DishCategoriesActivity.class);
//            startActivity(intent);
            activityResultLauncher.launch(intent);
        });


    }

    @SuppressLint("SetTextI18n")
    private void updateTotal(Receipt receipt) {
        int total = 0;
        if (receipt.getOrders() != null)
            for (Order o : receipt.getOrders())
                total += o.getDish().getPrice();
        textViewTotal.setText(total / 100.0 + " PLN");
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void displayOrder(Order order) {
        if (order.getStatus() != 3) {
            @SuppressLint("InflateParams") View view = LayoutInflater.from(this).inflate(R.layout.list_view_order_receipt, linearLayout, false);
            TextView textViewOrder = view.findViewById(R.id.text_view_order_list_view_order_receipt);
            TextView textViewPrice = view.findViewById(R.id.text_view_price_list_view_order_receipt);
            ImageView imageViewDelete = view.findViewById(R.id.image_view_delete_list_view_order_receipt);
            ImageView imageViewEdit = view.findViewById(R.id.image_view_edit_list_view_order_receipt);
            textViewOrder.setText(order.getDish().getName());
            textViewPrice.setText(String.format("%.2f PLN", order.getDish().getPrice() / 100.0));

            imageViewDelete.setClickable(true);
            imageViewDelete.setFocusable(true);
            if (order.getStatus() == 2) {
                imageViewDelete.setImageResource(R.drawable.ic_check);
                imageViewDelete.setOnClickListener(view1 -> {
                    Call<Order> call = App.interfaceApi.advanceOrder(order.getId(), 3);
                    call.enqueue(new Callback<Order>() {
                        @Override
                        public void onResponse(@NonNull Call<Order> call, @NonNull Response<Order> response) {
                            if (response.isSuccessful()) {
                                linearLayout.removeView(view);
                            }
                        }

                        @Override
                        public void onFailure(@NonNull Call<Order> call, @NonNull Throwable t) {
                            // TODO: handle failure
                        }
                    });
                });
                imageViewEdit.setVisibility(View.INVISIBLE);
            } else {
                imageViewDelete.setOnClickListener(view1 -> {
                    Call<Void> call = App.interfaceApi.deleteOrder(order.getId());
                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                            if (response.isSuccessful()) {
                                receipt.getOrders().remove(order);
                                updateTotal(receipt);
                                linearLayout.removeView(view);
                            } else
                                Toast.makeText(ReceiptActivity.this, "Error: " + response.code(), Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                            Toast.makeText(ReceiptActivity.this, getString(R.string.receipt_activity_internet_error), Toast.LENGTH_LONG).show();
                        }
                    });
                });

                imageViewEdit.setOnClickListener(view1 -> {
                    Intent intent = new Intent(ReceiptActivity.this, RequestsActivity.class);
                    intent.putExtra("order", order);
                    requestActivityResultLauncher.launch(intent);
                });
            }

            linearLayout.addView(view);
        }
    }
}