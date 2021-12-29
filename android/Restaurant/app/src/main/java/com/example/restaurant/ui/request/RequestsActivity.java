package com.example.restaurant.ui.request;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurant.App;
import com.example.restaurant.R;
import com.example.restaurant.entities.Order;
import com.example.restaurant.entities.SpecialRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestsActivity extends AppCompatActivity {
    private EditText editText;
    private ImageView imageView;
    private LinearLayout linearLayout;
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);

        initViews();
    }

    private void initViews() {
        Intent previous = getIntent();
        order = (Order) previous.getSerializableExtra("order");

        editText = findViewById(R.id.edit_text_request_requests);
        imageView = findViewById(R.id.image_view_add_request_requests);
        linearLayout = findViewById(R.id.linear_layout_requests);

        imageView.setOnClickListener(view -> addRequest());

        for (SpecialRequest request : order.getRequests()) {
            displayRequest(request);
        }
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("order", order);
        setResult(RESULT_OK, intent);
        super.finish();
    }

    private void addRequest() {
        String request = editText.getText().toString();
        if (request.length() > 0) {
            SpecialRequest specialRequest = new SpecialRequest(null, request, order.getId());
            Call<SpecialRequest> call = App.interfaceApi.addRequest(specialRequest);
            call.enqueue(new Callback<SpecialRequest>() {
                @Override
                public void onResponse(@NonNull Call<SpecialRequest> call, @NonNull Response<SpecialRequest> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        editText.setText("");
                        SpecialRequest responseRequest = response.body();
                        order.getRequests().add(responseRequest);
                        displayRequest(responseRequest);
                    }
                }

                @Override
                public void onFailure(@NonNull Call<SpecialRequest> call, @NonNull Throwable t) {

                }
            });

        }
    }

    private void displayRequest(SpecialRequest specialRequest) {
        View view = LayoutInflater.from(RequestsActivity.this).inflate(R.layout.list_view_request, linearLayout, false);

        TextView textViewRequest = view.findViewById(R.id.text_view_request_list_view_request);
        textViewRequest.setText(specialRequest.getRequest());

        ImageView imageViewDelete = view.findViewById(R.id.image_view_delete_request_list_view_request);
        imageViewDelete.setOnClickListener(view1 -> {
            Call<Void> callDel = App.interfaceApi.deleteRequest(specialRequest.getId());
            callDel.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                    if (response.isSuccessful()) {
                        linearLayout.removeView(view);
                        order.getRequests().remove(specialRequest);
                    }
                    // TODO: Handle failure
                }

                @Override
                public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                    // TODO: Handle failure
                }
            });
        });
        linearLayout.addView(view);
    }
}