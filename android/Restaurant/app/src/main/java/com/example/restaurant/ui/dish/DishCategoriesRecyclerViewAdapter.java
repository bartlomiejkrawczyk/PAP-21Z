package com.example.restaurant.ui.dish;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant.R;
import com.example.restaurant.entities.DishCategory;

import java.util.List;

public class DishCategoriesRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<DishCategory> categories;
    private OnClickListener onClickListener;

    public DishCategoriesRecyclerViewAdapter() {
    }

    public void setCategories(List<DishCategory> categories) {
        this.categories = categories;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        Log.e("abc", "Click listener set");
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_dish_categories, parent, false);
        view.setFocusable(true);
        view.setClickable(true);
        return new DishCategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DishCategory category = categories.get(position);
        if (holder instanceof DishCategoriesViewHolder) {
            ((DishCategoriesViewHolder) holder).textViewCategory.setText(category.getName());
        }
    }

    @Override
    public int getItemCount() {
        if (categories != null)
            return categories.size();
        return 0;
    }

    public interface OnClickListener {
        void onClick(DishCategory category);
    }

    public class DishCategoriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView textViewCategory;

        public DishCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textViewCategory = itemView.findViewById(R.id.text_view_dish_categories);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.e("abc", "test on click");
            if (onClickListener != null)
                onClickListener.onClick(categories.get(getLayoutPosition()));
        }
    }
}
