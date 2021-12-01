package com.example.desktop;

import com.example.desktop.entities.Employee;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.GUI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.Nullable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class App {

    private static final String BASE_URL = "https://taskeeapp.com:8443/";
    public static InterfaceApi interfaceApi;

    public static void main(String[] args) {
        createNetworkSys();
        new GUI().run();
    }

    public static void createNetworkSys() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();


        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .serializeNulls()
                .setLenient()
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build();

        interfaceApi = retrofit.create(InterfaceApi.class);
    }

    @Nullable
    public static Vector<Employee> getEmployeesFromApi() {
        try {
            URL url = new URL("https://taskeeapp.com:8443/api/employees/all");

            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            String line = scanner.nextLine();
            scanner.close();

            line = line.substring(1, line.length() - 1);

            Vector<String> objectsInStrings = new Vector<String>();
            int j = 0;

            for (int i = 0; i < line.length(); ++i) {
                if (line.charAt(i) == '}') {
                    objectsInStrings.addElement(line.substring(j, i + 1));
                    j = i + 2;
                }
            }

            Vector<Employee> employees = new Vector<Employee>();

            Gson g = new Gson();
            Employee e;
            for (int i = 0; i < objectsInStrings.size(); ++i) {
                e = g.fromJson(objectsInStrings.elementAt(i), Employee.class);
                employees.addElement(e);
            }
            return employees;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    public static Vector<Order> getOrdersFromApi() {
        try {
            URL url = new URL("https://taskeeapp.com:8443/api/orders/all");

            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            String line = scanner.nextLine();
            scanner.close();

            line = line.substring(1, line.length() - 1);

            Vector<String> objectsInStrings = new Vector<String>();
            int j = 0;

            for (int i = 0; i < line.length(); ++i) {
                if (line.charAt(i) == '}') {
                    objectsInStrings.addElement(line.substring(j, i + 1));
                    j = i + 2;
                }
            }

            Vector<Order> orders = new Vector<Order>();

            Gson g = new Gson();
            Order e;
            for (int i = 0; i < objectsInStrings.size(); ++i) {
                e = g.fromJson(objectsInStrings.elementAt(i), Order.class);
                orders.addElement(e);
            }
            return orders;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
