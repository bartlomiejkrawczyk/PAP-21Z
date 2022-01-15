package com.example.restaurant.ui.launcher;

import static com.example.restaurant.ui.login.LoginActivity.EMPLOYEE_ID;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import com.example.restaurant.R;
import com.example.restaurant.ui.login.LoginActivity;
import com.example.restaurant.ui.receipt.ReceiptsActivity;

/**
 * Custom class that decides which activity to open
 * (it checks whether employee has been logged in)
 */
@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        splashScreen.setOnExitAnimationListener(splashScreenViewProvider -> {
            Intent intent;
            if (isEmployeeLoggedIn())
                intent = new Intent(SplashActivity.this, ReceiptsActivity.class);
            else
                intent = new Intent(SplashActivity.this, LoginActivity.class);

            startActivity(intent);

            finish();
        });
        setContentView(R.layout.activity_splash);

    }

    private boolean isEmployeeLoggedIn() {
        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.shared_preference_file_key), Context.MODE_PRIVATE);
        long employeeId = sharedPref.getLong(EMPLOYEE_ID, -1L);
        return employeeId != -1L;
    }
}