package com.example.restaurant.ui;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurant.R;
import com.example.restaurant.utils.ImageUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.image_view_main);
        new ImageUtils(this, this).setImage(imageView, "restaurant.png");
    }
}