package com.example.restaurant.ui.receipt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    private View.OnClickListener onButtonClickListener;

    private static final int RECEIPT = 1;
    private static final int ADD_RECEIPT = 2;

    public ReceiptsRecyclerViewAdapter() {
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setOnButtonClickListener(View.OnClickListener onButtonClickListener) {
        this.onButtonClickListener = onButtonClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == RECEIPT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_receipts, parent, false);
            view.setFocusable(true);
            view.setClickable(true);
            return new ReceiptsViewHolder(view);
        } else if (viewType == ADD_RECEIPT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_add_receipt, parent, false);
            return new AddReceiptViewHolder(view);
        }
        throw new UnsupportedOperationException("Unsupported type exception");
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ReceiptsViewHolder) {
            Receipt receipt = receipts.get(position);
            ((ReceiptsViewHolder) holder).textViewTable.setText(receipt.getTable().toString());
            int total = 0;
            ((ReceiptsViewHolder) holder).linearLayout.removeAllViews();
            for (Order order : receipt.getOrders()) {
                total += order.getDish().getPrice();
                ((ReceiptsViewHolder) holder).linearLayout.addView(getOrderView(order, holder.itemView.getContext()));
            }
            ((ReceiptsViewHolder) holder).textViewTotal.setText(String.format("%.2f PLN", total / 100.0));
        }
//        else if (holder instanceof AddReceiptViewHolder) {
//            // Do nothing for now
//        }
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private View getOrderView(Order order, Context context) {
        @SuppressLint("InflateParams") View convertView = LayoutInflater.from(context).inflate(R.layout.list_view_order_receipts, null, false);

        TextView textViewOrder = convertView.findViewById(R.id.text_view_order_list_view_order_receipts);
        TextView textViewPrice = convertView.findViewById(R.id.text_view_price_list_view_order_receipts);
        ImageView imageView = convertView.findViewById(R.id.image_view_list_view_order_receipts);

        textViewOrder.setText(order.getDish().getName());
        textViewPrice.setText(String.format("%.2f PLN", order.getDish().getPrice() / 100.0));

        switch (order.getStatus()) {
            case 1:
                imageView.setImageResource(R.drawable.ic_baseline_close);
                break;
            case 2:
                imageView.setImageResource(R.drawable.ic_baseline_almost_done);
                break;
            case 3:
                imageView.setImageResource(R.drawable.ic_baseline_done);
                break;

        }

        return convertView;
    }


    @Override
    public int getItemCount() {
        if (receipts != null)
            return receipts.size() + 1;
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1)
            return ADD_RECEIPT;
        return RECEIPT;
    }

    public interface OnClickListener {
        void onClick(Receipt receipt);
    }

    public class ReceiptsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView textViewTable;
        public final LinearLayout linearLayout;
        public final TextView textViewTotal;

        public ReceiptsViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textViewTable = itemView.findViewById(R.id.text_view_table_receipts_item);
            this.linearLayout = itemView.findViewById(R.id.linear_layout_receipts_item);
            this.textViewTotal = itemView.findViewById(R.id.text_view_total_receipts_item);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onClickListener != null)
                onClickListener.onClick(receipts.get(getLayoutPosition()));
        }
    }

    public class AddReceiptViewHolder extends RecyclerView.ViewHolder {
        public final Button button;

        public AddReceiptViewHolder(@NonNull View itemView) {
            super(itemView);


            button = itemView.findViewById(R.id.button_recycler_item_add_receipt);
            button.setOnClickListener(onButtonClickListener);
        }
    }
}
