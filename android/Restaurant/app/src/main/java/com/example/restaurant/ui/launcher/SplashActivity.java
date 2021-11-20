package com.example.restaurant.ui.launcher;

import static com.example.restaurant.ui.login.LoginActivity.EMPLOYEE_ID_KEY;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurant.R;
import com.example.restaurant.ui.MainActivity;
import com.example.restaurant.ui.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        performSplash();
    }

    //wait 1.5 seconds and open app
    private void performSplash() {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            //launch splash activity and
            //decide what activity to open
            //login or main
            //TODO: create deciding method on which activity to open
            Intent intent;
            if (ifEmployeeIsLoggedIn())
                intent = new Intent(SplashActivity.this, MainActivity.class);
            else
                intent = new Intent(SplashActivity.this, LoginActivity.class);


            startActivity(intent);
            overridePendingTransition(R.anim.foreground_activity_slide_in, R.anim.background_activity_slide_out);

            finish();
        }, 1500);
    }

    public boolean ifEmployeeIsLoggedIn() {
        SharedPreferences sharedPref = this.getSharedPreferences(
                getString(R.string.shared_preference_file_key), Context.MODE_PRIVATE);
        long employeeId = sharedPref.getLong(EMPLOYEE_ID_KEY, -1L);
        return employeeId != -1L;
    }
}