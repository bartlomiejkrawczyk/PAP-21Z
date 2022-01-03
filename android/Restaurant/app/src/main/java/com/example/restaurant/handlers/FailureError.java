package com.example.restaurant.handlers;

import android.content.Context;
import android.widget.Toast;

import com.example.restaurant.R;

public class FailureError {
    private final Context context;
    private final Throwable throwable;

    public FailureError(Context context, Throwable throwable) {
        this.context = context;
        this.throwable = throwable;
    }

    public String getMessage() {
        String message = context.getString(R.string.toast_failure_error_internet_connection);
        message += throwable.getLocalizedMessage();

        return message;
    }

    public void makeToast() {
        Toast.makeText(context, getMessage(), Toast.LENGTH_LONG).show();
    }
}
