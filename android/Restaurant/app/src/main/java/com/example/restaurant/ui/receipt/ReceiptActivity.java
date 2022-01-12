package com.example.restaurant.ui.receipt;

import static com.example.restaurant.ui.login.LoginActivity.EMPLOYEE_ID;
import static com.example.restaurant.ui.receipt.ReceiptsActivity.RECEIPT;

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
import com.example.restaurant.handlers.FailureErrorHandler;
import com.example.restaurant.handlers.ResponseErrorHandler;
import com.example.restaurant.ui.dish.DishCategoriesActivity;
import com.example.restaurant.ui.request.RequestsActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReceiptActivity extends AppCompatActivity {

    public static final String DISH = "dish";
    public static final String ORDER = "order";

    private TextView textViewTotal;
    private List<Table> tables;
    private Spinner spinner;
    private ArrayAdapter<Table> adapter;
    private LinearLayout linearLayout;

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
            signEmployeeToReceipt();
        }

        initViews();
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
            handleCloseReceipt();
        } else if (id == R.id.menu_delete_receipt) {
            handleDeleteReceipt();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initViews() {
        textViewTotal = findViewById(R.id.text_view_total_receipt);
        textViewTotal.setText(receipt.formatTotal());

        spinner = findViewById(R.id.spinner_tables_receipt);
        setupSpinner();

        linearLayout = findViewById(R.id.linear_layout_orders_receipt);

        List<Order> orders = receipt.getOrders();
        if (orders == null) {
            orders = new ArrayList<>();
            receipt.setOrders(orders);
        }
        for (Order order : orders)
            displayOrder(order);

        Button button = findViewById(R.id.button_add_order_receipt);

        ActivityResultLauncher<Intent> dishActivityResultLauncher = registerForDishActivityResult();

        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, DishCategoriesActivity.class);
            dishActivityResultLauncher.launch(intent);
        });

        requestActivityResultLauncher = registerForRequestsActivityResult();
    }

    private void handleCloseReceipt() {
        if (receipt.canClose()) {
            receipt.setPayment(receipt.getTotal());

            if (receipt.getPayment() > 0) {
                Call<Receipt> call = App.interfaceApi.updateReceipt(receipt.getId(), receipt);
                call.enqueue(new Callback<Receipt>() {
                    @Override
                    public void onResponse(@NonNull Call<Receipt> call, @NonNull Response<Receipt> response) {
                        if (response.isSuccessful()) {
                            finish();
                        } else {
                            new ResponseErrorHandler<>(response, ReceiptActivity.this).makeToast();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<Receipt> call, @NonNull Throwable t) {
                        new FailureErrorHandler(t, ReceiptActivity.this).makeToast();
                    }
                });
            } else {
                Toast.makeText(ReceiptActivity.this, getString(R.string.toast_error_cannot_close_empty_receipt), Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(ReceiptActivity.this, getString(R.string.toast_error_cannot_close_receipt), Toast.LENGTH_LONG).show();
        }
    }

    private void handleDeleteReceipt() {
        if (receipt.canDelete()) {
            Call<Void> call = App.interfaceApi.deleteReceipt(receipt.getId());
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                    if (response.isSuccessful()) {
                        finish();
                    } else {
                        new ResponseErrorHandler<>(response, ReceiptActivity.this).makeToast();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                    new FailureErrorHandler(t, ReceiptActivity.this).makeToast();
                }
            });
        } else {
            Toast.makeText(ReceiptActivity.this, getString(R.string.toast_error_cannot_delete_receipt), Toast.LENGTH_LONG).show();
        }
    }


    private void signEmployeeToReceipt() {
        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.shared_preference_file_key), Context.MODE_PRIVATE);
        long employeeId = sharedPref.getLong(EMPLOYEE_ID, -1L);
        receipt.setEmployee(new Employee(employeeId));
    }

    private void initNewReceipt() {
        receipt = new Receipt();
        receipt.setPayment(0);

        signEmployeeToReceipt();

        Call<Receipt> call = App.interfaceApi.addReceipt(receipt);
        call.enqueue(new Callback<Receipt>() {
            @Override
            public void onResponse(@NonNull Call<Receipt> call, @NonNull Response<Receipt> response) {
                if (response.isSuccessful() && response.body() != null) {
                    receipt.setId(response.body().getId());
                } else {
                    new ResponseErrorHandler<>(response, ReceiptActivity.this).makeToast(getString(R.string.receipt_activity_adding_receipt_failed));
                    finish();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Receipt> call, @NonNull Throwable t) {
                new FailureErrorHandler(t, ReceiptActivity.this).makeToast();
                finish();
            }
        });
    }


    @NonNull
    private ActivityResultLauncher<Intent> registerForDishActivityResult() {
        return registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            long dishId = data.getLongExtra(DISH, -1L);

                            addOrder(dishId);
                        }
                    }
                });
    }

    private void addOrder(long dishId) {
        new Thread(() -> {
            Dish dish = AppDatabase.getAppDatabase(ReceiptActivity.this).dishesDao().getDishById(dishId);

            Order order = new Order(null, System.currentTimeMillis(), dish, receipt.getId(), new ArrayList<>(), 1);

            final Call<Order> call = App.interfaceApi.addOrder(order);
            call.enqueue(new Callback<Order>() {
                @Override
                public void onResponse(@NonNull Call<Order> call, @NonNull Response<Order> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        Order order = response.body();
                        displayOrder(order);
                        receipt.getOrders().add(order);
                        textViewTotal.setText(receipt.formatTotal());
                    } else {
                        new ResponseErrorHandler<>(response, ReceiptActivity.this).makeToast();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<Order> call, @NonNull Throwable t) {
                    new FailureErrorHandler(t, ReceiptActivity.this).makeToast();
                }
            });
        }).start();
    }


    @NonNull
    private ActivityResultLauncher<Intent> registerForRequestsActivityResult() {
        return registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            Order updatedOrder = (Order) data.getSerializableExtra(ORDER);

                            Optional<Order> order = receipt
                                    .getOrders()
                                    .stream()
                                    .filter(o -> o.getId() != null && o.getId().equals(updatedOrder.getId()))
                                    .findFirst();

                            order.ifPresent(value -> value.setRequests(updatedOrder.getRequests()));
                        }
                    }
                });
    }

    private void setupSpinner() {
        tables = new ArrayList<>();
        tables.add(new Table(null, getString(R.string.spinner_item_takeaway)));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tables);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        new Thread(this::retrieveTablesFromDatabase).start();

        spinner.post(() -> spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                updateTable(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Do nothing
            }
        }));
    }

    private void retrieveTablesFromDatabase() {
        AppDatabase db = AppDatabase.getAppDatabase(this);
        if (db.tablesDao().getTablesCount() > 0) {
            List<Table> daoTables = db.tablesDao().getTables();
            setTables(daoTables);
        } else {
            Call<List<Table>> call = App.interfaceApi.getTables();
            try {
                Response<List<Table>> response = call.execute();
                if (response.isSuccessful() && response.body() != null) {
                    setTables(response.body());
                } else {
                    new ResponseErrorHandler<>(response, ReceiptActivity.this)
                            .errorDialog(
                                    getString(R.string.error_downloading_tables),
                                    (dialog, id) -> new Thread(this::retrieveTablesFromDatabase).start(),
                                    false
                            );
                }
            } catch (IOException e) {
                new FailureErrorHandler(e, ReceiptActivity.this)
                        .errorDialog(
                                getString(R.string.error_downloading_tables),
                                (dialog, id) -> new Thread(this::retrieveTablesFromDatabase).start(),
                                false
                        );
            }
        }
    }

    private void setTables(List<Table> tables) {
        runOnUiThread(() -> {
            this.tables.addAll(tables);
            adapter.notifyDataSetChanged();

            Table table = receipt.getTable();
            if (table != null)
                for (int i = 0; i < tables.size(); i++) {
                    if (tables.get(i).getId().equals(table.getId())) {
                        spinner.setSelection(i + 1);
                        break;
                    }
                }
        });
    }


    private void updateTable(int position) {
        boolean update = false;
        Table table = receipt.getTable();

        if (position != 0) {
            if (table == null || !table.getId().equals(tables.get(position).getId()))
                update = true;
            receipt.setTable(tables.get(position));
        } else {
            if (table != null)
                update = true;
            receipt.setTable(null);
        }

        if (update) {
            Call<Receipt> call = App.interfaceApi.updateReceipt(receipt.getId(), receipt);
            call.enqueue(new Callback<Receipt>() {
                @Override
                public void onResponse(@NonNull Call<Receipt> call, @NonNull Response<Receipt> response) {
                    if (!response.isSuccessful())
                        new ResponseErrorHandler<>(response, ReceiptActivity.this).makeToast();
                    // else Do nothing
                }

                @Override
                public void onFailure(@NonNull Call<Receipt> call, @NonNull Throwable t) {
                    new FailureErrorHandler(t, ReceiptActivity.this).makeToast();
                }
            });
        }
    }

    private void displayOrder(Order order) {
        if (order.getStatus() != 3) {
            View view = LayoutInflater.from(this).inflate(R.layout.list_view_order_receipt, linearLayout, false);

            TextView textViewOrder = view.findViewById(R.id.text_view_order_list_view_order_receipt);
            TextView textViewPrice = view.findViewById(R.id.text_view_price_list_view_order_receipt);
            ImageView imageViewDelete = view.findViewById(R.id.image_view_delete_list_view_order_receipt);
            ImageView imageViewEdit = view.findViewById(R.id.image_view_edit_list_view_order_receipt);

            textViewOrder.setText(order.getDish().getName());
            textViewPrice.setText(order.formatPrice());

            imageViewDelete.setClickable(true);
            imageViewDelete.setFocusable(true);

            if (order.getStatus() == 2) {
                imageViewDelete.setImageResource(R.drawable.ic_check);
                imageViewDelete.setOnClickListener(view1 -> advanceOrder(order, view));
                imageViewEdit.setVisibility(View.INVISIBLE);
            } else {
                imageViewDelete.setOnClickListener(view1 -> deleteOrder(order, view));
                imageViewEdit.setOnClickListener(view1 -> {
                    Intent intent = new Intent(ReceiptActivity.this, RequestsActivity.class);
                    intent.putExtra(ORDER, order);
                    requestActivityResultLauncher.launch(intent);
                });
            }

            linearLayout.addView(view);
        }
    }

    private void advanceOrder(Order order, View view) {
        Call<Order> call = App.interfaceApi.advanceOrder(order.getId(), 3);
        call.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(@NonNull Call<Order> call, @NonNull Response<Order> response) {
                if (response.isSuccessful()) {
                    order.setStatus(3);
                    linearLayout.removeView(view);
                } else {
                    new ResponseErrorHandler<>(response, ReceiptActivity.this).makeToast();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Order> call, @NonNull Throwable t) {
                new FailureErrorHandler(t, ReceiptActivity.this).makeToast();
            }
        });
    }


    private void deleteOrder(Order order, View view) {
        Call<Void> call = App.interfaceApi.deleteOrder(order.getId());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                if (response.isSuccessful()) {
                    receipt.getOrders().remove(order);
                    textViewTotal.setText(receipt.formatTotal());
                    linearLayout.removeView(view);
                } else {
                    new ResponseErrorHandler<>(response, ReceiptActivity.this).makeToast();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                new FailureErrorHandler(t, ReceiptActivity.this).makeToast();
            }
        });
    }
}