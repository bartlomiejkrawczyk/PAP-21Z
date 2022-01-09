package com.example.restaurant.handlers;

import android.app.Activity;

import com.example.restaurant.R;

/**
 * Class used to format error message and show it to user
 */
public class FailureError extends ErrorHandler {
    private final Throwable throwable;

    public FailureError(Throwable throwable, Activity activity) {
        super(activity);
        this.throwable = throwable;
    }

    @Override
    protected String getMessage() {
        String message = context.getString(R.string.toast_failure_error_internet_connection);
        message += throwable.getLocalizedMessage();

        return message;
    }

}
