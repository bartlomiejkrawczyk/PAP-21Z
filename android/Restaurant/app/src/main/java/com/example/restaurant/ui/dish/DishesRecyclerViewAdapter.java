package com.example.restaurant.ui.dish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant.R;
import com.example.restaurant.entities.Dish;
import com.example.restaurant.utils.ImageUtils;

import java.util.List;

public class DishesRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Dish> dishes;
    private OnClickListener onClickListener;
    private final Context context;

    public DishesRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_dishes, parent, false);
        view.setFocusable(true);
        view.setClickable(true);
        return new DishesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Dish dish = dishes.get(position);
        if (holder instanceof DishesViewHolder) {
            ((DishesViewHolder) holder).textViewDish.setText(dish.getName());
            if (dish.getImagePath() != null)
                new ImageUtils(context).setImage(((DishesViewHolder) holder).imageViewDish, dish.getImagePath());
        }
    }

    @Override
    public int getItemCount() {
        if (dishes != null)
            return dishes.size();
        return 0;
    }

    public interface OnClickListener {
        void onClick(Dish dish);
    }

    public class DishesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView textViewDish;
        public final ImageView imageViewDish;

        public DishesViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewDish = itemView.findViewById(R.id.text_view_dishes);
            this.imageViewDish = itemView.findViewById(R.id.image_view_dishes);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (onClickListener != null)
                onClickListener.onClick(dishes.get(getLayoutPosition()));
        }
    }
}
