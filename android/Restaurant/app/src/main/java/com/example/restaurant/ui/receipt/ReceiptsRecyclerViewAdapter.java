package com.example.restaurant.ui.receipt;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant.R;
import com.example.restaurant.entities.Order;
import com.example.restaurant.entities.Receipt;

import java.util.List;

public class ReceiptsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Receipt> receipts;
    private OnClickListener onClickListener;

    public ReceiptsRecyclerViewAdapter() {
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_receipts, parent, false);
        view.setFocusable(true);
        view.setClickable(true);
        return new ReceiptsViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Receipt receipt = receipts.get(position);
        if (holder instanceof ReceiptsViewHolder) {
            ((ReceiptsViewHolder) holder).textViewTable.setText(receipt.getTable().getName());
            StringBuilder orders = new StringBuilder();
            StringBuilder prices = new StringBuilder();
            int total = 0;
            for (Order order : receipt.getOrders()) {
                orders.append(order.getDish().getName()).append("\n");
                prices.append(order.getDish().getPrice() / 100).append(" PLN\n");
                total += order.getDish().getPrice();
            }
            ((ReceiptsViewHolder) holder).textViewOrders.setText(orders);
            ((ReceiptsViewHolder) holder).textViewOrdersPrice.setText(prices);
            ((ReceiptsViewHolder) holder).textViewTotal.setText(String.format("%d PLN", total / 100));
        }
    }

    @Override
    public int getItemCount() {
        if (receipts != null)
            return receipts.size();
        return 0;
    }

    public interface OnClickListener {
        void onClick(Receipt receipt);
    }

    public class ReceiptsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView textViewTable;
        public final TextView textViewOrders;
        public final TextView textViewOrdersPrice;
        public final TextView textViewTotal;

        public ReceiptsViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textViewTable = itemView.findViewById(R.id.text_view_table_receipts_item);
            this.textViewOrders = itemView.findViewById(R.id.text_view_orders_receipts_item);
            this.textViewOrdersPrice = itemView.findViewById(R.id.text_view_orders_prices_receipts_item);
            this.textViewTotal = itemView.findViewById(R.id.text_view_total_receipts_item);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onClickListener != null)
                onClickListener.onClick(receipts.get(getLayoutPosition()));
        }
    }
}
