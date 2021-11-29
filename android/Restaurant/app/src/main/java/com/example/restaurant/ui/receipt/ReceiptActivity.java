package com.example.restaurant.ui.receipt;

import static com.example.restaurant.ui.receipt.ReceiptsActivity.RECEIPT;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurant.R;
import com.example.restaurant.db.AppDatabase;
import com.example.restaurant.entities.Order;
import com.example.restaurant.entities.Receipt;
import com.example.restaurant.entities.Table;
import com.example.restaurant.ui.dish.DishCategoriesActivity;

import java.util.ArrayList;
import java.util.List;

public class ReceiptActivity extends AppCompatActivity {

    private List<Table> tables;
    private Spinner spinner;
    private LinearLayout linearLayout;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        Intent previous = getIntent();
        Receipt receipt = (Receipt) previous.getSerializableExtra(RECEIPT);

        if (receipt == null) {
            receipt = new Receipt();
            // TODO: set employee
        }


        initViews(receipt);
    }

    private void initViews(Receipt receipt) {

        spinner = findViewById(R.id.spinner_tables_receipt);
        tables = new ArrayList<>();
        ArrayAdapter<Table> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tables);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        new Thread(() -> {
            AppDatabase db = AppDatabase.getAppDatabase(this);
            tables.addAll(db.tablesDao().getTables());
            adapter.notifyDataSetChanged();
        }).start();


        linearLayout = findViewById(R.id.linear_layout_orders_receipt);

        List<Order> orders = receipt.getOrders();
        if (orders == null) {
            orders = new ArrayList<>();
            receipt.setOrders(orders);
        }
        for (Order order : orders)
            displayOrder(order);

        button = findViewById(R.id.button_add_order_receipt);

        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, DishCategoriesActivity.class);
            startActivity(intent);
        });


    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void displayOrder(Order order) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(this).inflate(R.layout.list_view_order_receipt, null, false);
        TextView textViewOrder = view.findViewById(R.id.text_view_order_list_view_order_receipt);
        TextView textViewPrice = view.findViewById(R.id.text_view_price_list_view_order_receipt);
        ImageView imageView = view.findViewById(R.id.image_view_delete_list_view_order_receipt);
        textViewOrder.setText(order.getDish().getName());
        textViewPrice.setText(String.format("%.2f PLN", order.getDish().getPrice() / 100.0));
        imageView.setClickable(true);
        imageView.setFocusable(true);
        imageView.setOnClickListener(view1 -> {
            // TODO: implement on click
        });
        linearLayout.addView(view);
    }
}