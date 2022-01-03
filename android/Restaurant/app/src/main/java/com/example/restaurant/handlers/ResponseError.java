package com.example.restaurant.handlers;

import android.content.Context;
import android.widget.Toast;

import retrofit2.Response;

public class ResponseError<T> {
    private final Response<T> response;
    private final Context context;

    public ResponseError(Response<T> response, Context context) {
        this.response = response;
        this.context = context;
    }

    public String getMessage() {
        String message = "Error: " + response.code();
        if (!response.message().equals(""))
            message += " - " + response.message();
        return message;
    }

    public void makeToast() {
        Toast.makeText(context, getMessage(), Toast.LENGTH_LONG).show();
    }

    public void makeToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
