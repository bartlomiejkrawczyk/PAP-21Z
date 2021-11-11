package com.example.restaurant.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.restaurant.App;
import com.example.restaurant.R;
import com.example.restaurant.db.ImageSaver;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageUtils {
    private final Context context;
    private final Activity activity;
    private final String directory = "images";

    public ImageUtils(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    public void setImage(ImageView view, String fileName) {
        ImageSaver saver = new ImageSaver(context)
                .setDirectoryName(directory)
                .setFileName(fileName);
        if (saver.exists()) {
            view.setImageBitmap(saver.load());
        } else {
            final Call<ResponseBody> call = App.interfaceApi.getImage(fileName);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(@NonNull Call<ResponseBody> call,
                                       @NonNull Response<ResponseBody> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        byte[] img = null;
                        try {
                            img = response.body().bytes();
                        } catch (IOException e) {
                            view.setImageResource(R.drawable.ic_baseline_error_outline);
                        }
                        if (img != null) {
                            Bitmap bitmap = byteArrayToBitmap(img);
                            view.setImageBitmap(bitmap);
                            saver.save(bitmap);
                        }
                    } else {
                        view.setImageResource(R.drawable.ic_baseline_error_outline);
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                    view.setImageResource(R.drawable.ic_baseline_error_outline);
                }
            });
        }
    }

    public static Bitmap byteArrayToBitmap(byte[] data) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;
        return BitmapFactory.decodeByteArray(data, 0, data.length, options);
    }
}
