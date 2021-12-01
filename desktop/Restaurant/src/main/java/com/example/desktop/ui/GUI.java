package com.example.desktop.ui;

import com.example.desktop.App;
import com.example.desktop.entities.Cook;
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
    private Vector<Cook> vecCooks = new Vector<Cook>();

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
                buttonCooksOnClick();
            }
        });
    }

    public void buttonCooksOnClick() {
        JFrame frameCooks = new JFrame("Cooks");
        JPanel panelCooks = new JPanel();
        JPanel panelOptions = new JPanel();
        JButton buttonAdd = new JButton("Add cook");
        JButton buttonRemove = new JButton("Remove cook");
        JPanel panelTitle = new JPanel();
        JLabel labelTitle = new JLabel("Current Cooks: ");
        JPanel scrollableCooks = new JPanel();
        JScrollPane scrollCooks = new JScrollPane(scrollableCooks);

        scrollCooks.setPreferredSize(new Dimension(300, 240));
        scrollableCooks.setLayout(new BoxLayout(scrollableCooks, BoxLayout.Y_AXIS));
        scrollableCooks.setAutoscrolls(true);

        panelTitle.setBackground(Color.DARK_GRAY);
        panelTitle.setBounds(1, 1, 300, 30);
        labelTitle.setForeground(Color.WHITE);
        panelTitle.add(labelTitle);
        panelCooks.add(panelTitle);
        panelCooks.add(scrollCooks);

        buttonAdd.setBounds(1, 1, 150, 24);
        panelOptions.add(buttonAdd);

        buttonRemove.setBounds(150, 1, 150, 24);
        panelOptions.add(buttonRemove);

        panelCooks.setBorder(blackline);
        panelCooks.setPreferredSize(new Dimension(300, 30));
        panelCooks.setLayout(new BoxLayout(panelCooks, BoxLayout.Y_AXIS));

        panelOptions.setBorder(blackline);
        panelOptions.setPreferredSize(new Dimension(300, 25));
        panelOptions.setBackground(Color.GRAY);
        panelOptions.setLayout(null);

        frameCooks.setMinimumSize(new Dimension(300, 300));
        frameCooks.setResizable(false);
        frameCooks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frameCooks.add(panelOptions, BorderLayout.NORTH);
        frameCooks.add(panelCooks, BorderLayout.LINE_START);

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameAdd = new JFrame("Add cook");
                JTextField textCookName = new JTextField("name");
                JButton buttonAddCook = new JButton("Add");

                textCookName.setPreferredSize(new Dimension(130, 50));
                textCookName.setBorder(blackline);

                buttonAddCook.setPreferredSize(new Dimension(70, 50));
                buttonAddCook.setBorder(blackline);

                frameAdd.setPreferredSize(new Dimension(200, 50));
                frameAdd.setResizable(false);
                frameAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                frameAdd.add(textCookName, BorderLayout.LINE_START);
                frameAdd.add(buttonAddCook, BorderLayout.LINE_END);

                buttonAddCook.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int cooksNumber = vecCooks.size();
                        int cookId;
                        if (cooksNumber == 0)
                            cookId = 1;
                        else {
                            int lastCookId = vecCooks.get(cooksNumber - 1).getId();
                            cookId = lastCookId + 1;
                        }
                        String cookName = textCookName.getText();
                        Cook cook = new Cook(cookId, cookName);
                        vecCooks.add(cook);

                        Vector<JPanel> cooks = new Vector<JPanel>();

                        for (Cook c : vecCooks){
                            JPanel panelCook = new JPanel( new FlowLayout(FlowLayout.LEFT));
                            panelCook.setBorder(blackline);
                            panelCook.setMinimumSize(new Dimension(300, 30));
                            panelCook.setMaximumSize(new Dimension(300, 30));

                            JLabel labelCookDescription = new JLabel("Index:" + Integer.toString(c.getId()) + ".    Name: " +c.getName());
                            panelCook.add(labelCookDescription);

                            cooks.add(panelCook);
                        }
                        scrollableCooks.removeAll();
                        for (JPanel ck : cooks) { scrollableCooks.add(ck); }

                        panelCooks.updateUI();

                        frameAdd.dispose();
                    }
                });

                frameAdd.pack();
                frameAdd.setLocationRelativeTo(null);
                frameAdd.setVisible(true);
            }
        });

        frameCooks.pack();
        frameCooks.setLocationRelativeTo(null);
        frameCooks.setVisible(true);
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
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
