package com.example.restaurant.ui.settings;

import static com.example.restaurant.ui.login.LoginActivity.EMPLOYEE_ID;
import static com.example.restaurant.ui.login.LoginActivity.EMPLOYEE_NAME;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.restaurant.R;
import com.example.restaurant.ui.login.LoginActivity;

public class SettingsActivity extends AppCompatActivity {
    private static final String SIGN_OUT = "sign_out";
    private static final String CREDENTIALS = "credentials";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);

            Context context = getContext();
            if (context != null) {
                setEmployeeTitle(context);

                addSignOutFunctionality(context);
            }

        }

        private void addSignOutFunctionality(Context context) {
            Preference signOut = findPreference(SIGN_OUT);
            if (signOut != null) {
                signOut.setOnPreferenceClickListener(preference -> {
                    SharedPreferences sharedPref = context
                            .getSharedPreferences(getString(R.string.shared_preference_file_key), Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putLong(EMPLOYEE_ID, -1L);
                    editor.putString(EMPLOYEE_NAME, "");
                    editor.apply();

                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);

                    Activity activity = getActivity();
                    if (activity != null)
                        activity.finishAffinity();

                    return true;
                });
            }
        }

        private void setEmployeeTitle(Context context) {
            String name = context
                    .getSharedPreferences(getString(R.string.shared_preference_file_key), Context.MODE_PRIVATE)
                    .getString(EMPLOYEE_NAME, getString(R.string.preference_employee_title));
            Preference employeeName = findPreference(CREDENTIALS);
            if (employeeName != null)
                employeeName.setTitle(name);
        }
    }

}