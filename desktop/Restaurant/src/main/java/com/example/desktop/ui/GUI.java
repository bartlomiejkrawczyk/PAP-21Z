package com.example.desktop.ui;

import com.example.desktop.App;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI {

    int greetingsButtonCounter = 0;

    private final JPanel panel = new JPanel();
    private final JButton greetingButton = new JButton("Hello World!");
    private final JButton testConnectionButton = new JButton("Test Connection!");
    private final JLabel helloCounter = new JLabel("Hellos: " + greetingsButtonCounter, SwingConstants.CENTER);
    ActionListener testConnection = e -> getHelloWorld(testConnectionButton);

    public GUI() {

        JFrame frame = new JFrame("Hello World Java Swing");
        frame.setMinimumSize(new Dimension(480, 270));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout());

        greetingButton.addActionListener(countHellos);
        testConnectionButton.addActionListener(testConnection);
        greetingButton.setPreferredSize(new Dimension(160, 90));

        panel.add(greetingButton);
        panel.add(testConnectionButton);
        panel.add(helloCounter);

        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    ActionListener countHellos = e -> {
        greetingsButtonCounter++;
        helloCounter.setText("Hellos: " + greetingsButtonCounter);
    };

    private static void getHelloWorld(JButton button) {
        Call<String> call = App.interfaceApi.getHelloWorld();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NotNull Call<String> call, @NotNull Response<String> response) {
                if (response.isSuccessful() && response.body() != null) {
                    button.setText(response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<String> call, @NotNull Throwable throwable) {

            }
        });
    }

}