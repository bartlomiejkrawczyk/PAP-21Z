package com.example.restaurant.ui.dish;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant.R;
import com.example.restaurant.db.AppDatabase;
import com.example.restaurant.entities.DishCategory;

import java.util.List;

/**
 * Class that controls what can happen on dish categories activity
 * <p>
 * Window that displays all the dish categories available in the restaurant
 */
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
        setUpRecyclerView();

        new Thread(this::getDishCategories).start();
    }

    private void setUpRecyclerView() {
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adapter = new DishCategoriesRecyclerViewAdapter();

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        setResult(RESULT_OK, data);
                        finish();
                    }
                });

        adapter.setOnClickListener(category -> {
            Intent intent = new Intent(this, DishesActivity.class);
            intent.putExtra(DISH_CATEGORY_ID_KEY, category.getId());
            activityResultLauncher.launch(intent);
        });

        recyclerView.setAdapter(adapter);
    }

    @SuppressLint("NotifyDataSetChanged")
    private void getDishCategories() {
        AppDatabase db = AppDatabase.getAppDatabase(this);
        List<DishCategory> categories = db.dishCategoriesDao().getCategories();
        adapter.setCategories(categories);
        adapter.notifyDataSetChanged();
    }
}