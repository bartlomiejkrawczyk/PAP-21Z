package com.example.restaurant.ui.dish;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant.R;
import com.example.restaurant.db.AppDatabase;
import com.example.restaurant.entities.DishCategory;

import java.util.List;

public class DishCategoriesActivity extends AppCompatActivity {

    public static final String DISH_CATEGORY_ID_KEY = "dish_category_id";

    private RecyclerView recyclerView;
    private DishCategoriesRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_categories);

        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recycler_view_dish_categories);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adapter = new DishCategoriesRecyclerViewAdapter();

        adapter.setOnClickListener(category -> {
            Intent intent = new Intent(this, DishesActivity.class);
            intent.putExtra(DISH_CATEGORY_ID_KEY, category.getId());
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);

        new Thread(this::getDishCategories).start();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void getDishCategories() {
        AppDatabase db = AppDatabase.getAppDatabase(this);
        List<DishCategory> categories = db.dishCategoriesDao().getCategories();
        adapter.setCategories(categories);
        adapter.notifyDataSetChanged();
    }
}