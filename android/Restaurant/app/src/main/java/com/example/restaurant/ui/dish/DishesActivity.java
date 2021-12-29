package com.example.restaurant.ui.dish;

import static com.example.restaurant.ui.dish.DishCategoriesActivity.DISH_CATEGORY_ID_KEY;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant.R;
import com.example.restaurant.db.AppDatabase;
import com.example.restaurant.entities.Dish;

import java.util.List;

public class DishesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DishesRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishes);

        initViews();
    }

    private void initViews() {
        Intent previousIntent = getIntent();
        long id = previousIntent.getLongExtra(DISH_CATEGORY_ID_KEY, -1L);

        if (id != -1L) {
            recyclerView = findViewById(R.id.recycler_view_dishes);
            recyclerView.setHasFixedSize(true);

            RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(manager);
            adapter = new DishesRecyclerViewAdapter(this);

            adapter.setOnClickListener(dish -> {
                Intent intent = new Intent();
                intent.putExtra("dish", dish.getId());
                setResult(RESULT_OK, intent);
                finish();
            });

            recyclerView.setAdapter(adapter);

            new Thread(() -> getDishes(id)).start();
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private void getDishes(long categoryId) {
        AppDatabase db = AppDatabase.getAppDatabase(this);
        List<Dish> dishes = db.dishesDao().getDishesByCategory(categoryId);
        adapter.setDishes(dishes);
        adapter.notifyDataSetChanged();
    }
}