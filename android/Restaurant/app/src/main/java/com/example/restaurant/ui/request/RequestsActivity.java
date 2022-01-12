package com.example.restaurant.ui.request;

import static com.example.restaurant.ui.receipt.ReceiptActivity.ORDER;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurant.App;
import com.example.restaurant.R;
import com.example.restaurant.entities.Order;
import com.example.restaurant.entities.SpecialRequest;
import com.example.restaurant.errors.InvalidData;
import com.example.restaurant.handlers.FailureErrorHandler;
import com.example.restaurant.handlers.ResponseErrorHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestsActivity extends AppCompatActivity {
    private EditText editText;
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
        order = (Order) previous.getSerializableExtra(ORDER);

        editText = findViewById(R.id.edit_text_request_requests);

        linearLayout = findViewById(R.id.linear_layout_requests);

        ImageView imageView = findViewById(R.id.image_view_add_request_requests);
        imageView.setOnClickListener(view -> addRequest());

        for (SpecialRequest request : order.getRequests()) {
            displayRequest(request);
        }
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(ORDER, order);
        setResult(RESULT_OK, intent);

        super.finish();
    }

    private void addRequest() {
        String request = editText.getText().toString();

        SpecialRequest specialRequest = new SpecialRequest(null, request, order.getId());

        try {
            specialRequest.validateData();
            Call<SpecialRequest> call = App.interfaceApi.addRequest(specialRequest);
            call.enqueue(new Callback<SpecialRequest>() {
                @Override
                public void onResponse(@NonNull Call<SpecialRequest> call, @NonNull Response<SpecialRequest> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        editText.setText("");
                        SpecialRequest responseRequest = response.body();
                        order.getRequests().add(responseRequest);
                        displayRequest(responseRequest);
                    } else {
                        new ResponseErrorHandler<>(response, RequestsActivity.this).makeToast();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<SpecialRequest> call, @NonNull Throwable t) {
                    new FailureErrorHandler(t, RequestsActivity.this).makeToast();
                }
            });
        } catch (InvalidData e) {
            Toast.makeText(RequestsActivity.this, getString(R.string.toast_error_request_invalid_data) + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void displayRequest(SpecialRequest specialRequest) {
        View view = LayoutInflater.from(RequestsActivity.this).inflate(R.layout.list_view_request, linearLayout, false);

        TextView textViewRequest = view.findViewById(R.id.text_view_request_list_view_request);
        textViewRequest.setText(specialRequest.getRequest());

        ImageView imageViewDelete = view.findViewById(R.id.image_view_delete_request_list_view_request);
        imageViewDelete.setOnClickListener(view1 -> deleteRequest(specialRequest, view));

        linearLayout.addView(view);
    }

    private void deleteRequest(SpecialRequest specialRequest, View view) {
        Call<Void> callDel = App.interfaceApi.deleteRequest(specialRequest.getId());
        callDel.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                if (response.isSuccessful()) {
                    linearLayout.removeView(view);
                    order.getRequests().remove(specialRequest);
                } else {
                    new ResponseErrorHandler<>(response, RequestsActivity.this).makeToast();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                new FailureErrorHandler(t, RequestsActivity.this).makeToast();
            }
        });
    }
}