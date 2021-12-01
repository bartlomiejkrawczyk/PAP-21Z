package com.example.restaurant.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurant.App;
import com.example.restaurant.R;
import com.example.restaurant.entities.Employee;
import com.example.restaurant.ui.receipt.ReceiptsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {


    public static final String EMPLOYEE_ID_KEY = "employee_id";
    public static final String EMPLOYEE_NAME_KEY = "employee_name";

    private Spinner spinner;
    private ArrayAdapter<Employee> adapter;
    private List<Employee> employees;

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {
        spinner = findViewById(R.id.spinner_login);
        button = findViewById(R.id.button_login);

        // Add adapter to spinner

        employees = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, employees);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        new Thread(this::getWaiters).start();

        // Add click listener to button

        button.setOnClickListener(view -> {
            if (login()) {
                Intent intent = new Intent(this, ReceiptsActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), getString(R.string.toast_login_no_one_chosen), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getWaiters() {
        Call<List<Employee>> call = App.interfaceApi.getWaiters();
        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(@NonNull Call<List<Employee>> call, @NonNull Response<List<Employee>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    employees.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Employee>> call, @NonNull Throwable t) {

            }
        });
    }

    private boolean login() {
        if (spinner.getCount() > 0) {
            Employee employee = (Employee) spinner.getSelectedItem();

            SharedPreferences sharedPref = this.getSharedPreferences(
                    getString(R.string.shared_preference_file_key), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putLong(EMPLOYEE_ID_KEY, employee.getId());
            editor.putString(EMPLOYEE_NAME_KEY, employee.getName());
            editor.apply();

            return true;
        }

        return false;
    }


}