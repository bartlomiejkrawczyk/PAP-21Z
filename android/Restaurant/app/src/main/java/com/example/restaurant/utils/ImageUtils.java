package com.example.restaurant.utils;

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

/**
 * Class used to fetch images from memory or server
 * and displaying it on given ImageView
 */
public class ImageUtils {
    private final Context context;

    public ImageUtils(Context context) {
        this.context = context;
    }

    /**
     * A method to fetch image from memory
     * or if the image isn't available on the device
     * to download it from the server
     *
     * @param view     - ImageView, where should be inserted requested image
     * @param fileName - name of the image
     */
    public void setImage(ImageView view, String fileName) {
        String directory = "images";
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

    /**
     * Convert byte array to bitmap
     *
     * @param data - Byte array with image data
     * @return Bitmap Image
     */
    private Bitmap byteArrayToBitmap(byte[] data) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;
        return BitmapFactory.decodeByteArray(data, 0, data.length, options);
    }
}
