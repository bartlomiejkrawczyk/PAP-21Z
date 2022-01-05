package com.example.restaurant.handlers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import com.example.restaurant.R;

/**
 * Class used to format error message and show it to user
 */
public class FailureError {
    private final Activity activity;
    private final Context context;
    private final Throwable throwable;

    public FailureError(Throwable throwable, Activity activity) {
        this.activity = activity;
        this.context = activity;
        this.throwable = throwable;
    }

    private String getMessage() {
        String message = context.getString(R.string.toast_failure_error_internet_connection);
        message += throwable.getLocalizedMessage();

        return message;
    }

    public void makeToast() {
        Toast.makeText(context, getMessage(), Toast.LENGTH_LONG).show();
    }

    /**
     * Show error dialog to user
     *
     * @param error           - title of the dialog
     * @param onClickListener - interface called on try again button clicked
     * @param closeApp        - indicates whether to add button to close app or finish current activity
     */
    public void errorDialog(String error, DialogInterface.OnClickListener onClickListener, boolean closeApp) {
        activity.runOnUiThread(() -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);

            // Set properties
            builder.setMessage(getMessage())
                    .setTitle(error);

            // Add the buttons
            builder.setNegativeButton(R.string.error_try_again, onClickListener);
            if (closeApp) {
                builder.setPositiveButton(R.string.error_close_application, (dialog, id) -> {
                    Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                    homeIntent.addCategory(Intent.CATEGORY_HOME);
                    homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(homeIntent);
                });
            } else {
                builder.setPositiveButton(R.string.error_finish_activity, (dialog, id) -> activity.finish());
            }

            builder.setCancelable(false);

            AlertDialog dialog = builder.create();

            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        });
    }
}
