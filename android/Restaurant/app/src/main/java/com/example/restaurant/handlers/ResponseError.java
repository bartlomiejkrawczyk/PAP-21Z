package com.example.restaurant.handlers;

import android.app.Activity;

import com.example.restaurant.R;

import retrofit2.Response;

/**
 * Class used to format response error message and show it to user
 */
public class ResponseError<T> extends ErrorHandler {
    private final Response<T> response;

    public ResponseError(Response<T> response, Activity activity) {
        super(activity);
        this.response = response;
    }

    @Override
    protected String getMessage() {
        String message = context.getString(R.string.error_unknown_error);
        if (response.isSuccessful()) {
            if (response.body() == null)
                message = context.getString(R.string.error_response_body_is_empty);
        } else {
            message = context.getString(R.string.error_error) + response.code();
            if (!response.message().equals(""))
                message += " - " + response.message();
        }

        return message;
    }

}
