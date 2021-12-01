package com.example.desktop.ui;

import com.example.desktop.App;
import com.example.desktop.entities.Employee;
import com.example.desktop.entities.Order;
import com.example.desktop.entities.SpecialRequest;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class GUI {

    private final JPanel panelLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel panelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private final JPanel panelTop = new JPanel();
    private final Border blackline = BorderFactory.createLineBorder(Color.black);
    private JPanel scrollablePanel = new JPanel();
    private JScrollPane scrollFrame = new JScrollPane(scrollablePanel);
    private JButton buttonCooks = new JButton("Cooks");

    public void setButtonCooks(){
        buttonCooks.setBounds(1, 1, 100, 23);
        panelTop.add(buttonCooks);
        buttonCooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCook();
            }
        });
    }

    public void addCook() {
        JFrame frame1 = new JFrame("Kitchen Cooks");
        frame1.setMinimumSize(new Dimension(200, 200));
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setVisible(true);
    }

    public void downloadOrders() {
        Call<List<Order>> call = App.interfaceApi.getOrdersStatus1();
        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    addOrdersToLeftPanel(response);
                }
            }
            @Override
            public void onFailure(Call<List<Order>> call, Throwable throwable) {

            }
        });
    }

    private void addOrdersToLeftPanel(Response<List<Order>> response) {

        Vector<JPanel> orders = new Vector<JPanel>();

        for (Order order : response.body()) {
            JPanel orderPanel = new JPanel();
            orderPanel.setBorder(blackline);
            orderPanel.setPreferredSize(new Dimension(200, 30));
//                JLabel date = new JLabel(order.getDate().toString());
            JLabel dish_name = new JLabel(order.getDish().getName());
//                orderPanel.add(date);
            orderPanel.add(dish_name);
            for (SpecialRequest request: order.getRequests())
                orderPanel.add(new JLabel(request.getRequest()));
            orders.add(orderPanel);
        }
        scrollablePanel.removeAll();
        for (JPanel order: orders) scrollablePanel.add(order);

        panelLeft.updateUI();
    }


    public GUI() {

        JFrame frame = new JFrame("Kitchen application");
        frame.setMinimumSize(new Dimension(800, 450));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelLeft.setBorder(blackline);
        panelLeft.setPreferredSize(new Dimension(400, 150));
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));

        panelRight.setBorder(blackline);
        panelRight.setPreferredSize(new Dimension(400, 150));

        panelTop.setBorder(blackline);
        panelTop.setPreferredSize(new Dimension(800, 25));
        panelTop.setBackground(Color.GRAY);
        panelTop.setLayout(null);

        JPanel panelLeftTitle = new JPanel();
        panelLeftTitle.setBorder(blackline);
        panelLeftTitle.setBackground(Color.DARK_GRAY);

        JLabel panelLeftTitleText = new JLabel("Orders placed:");
        panelLeftTitleText.setForeground(Color.WHITE);

        panelLeftTitle.add(panelLeftTitleText);
        panelLeft.add(panelLeftTitle);

        scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));
        scrollablePanel.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension(400, 350));
        panelLeft.add(scrollFrame);

        downloadOrders();
        Timer t = new Timer(30_000, e -> downloadOrders());
        t.start();

        frame.add(panelLeft, BorderLayout.LINE_START);
        frame.add(panelRight, BorderLayout.LINE_END);
        frame.add(panelTop, BorderLayout.NORTH);

        setButtonCooks();
        frame.pack();
        frame.setVisible(true);
    }
}