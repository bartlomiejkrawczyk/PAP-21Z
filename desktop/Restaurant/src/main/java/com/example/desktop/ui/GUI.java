package com.example.desktop.ui;

import com.example.desktop.App;
import com.example.desktop.entities.Employee;
import com.example.desktop.entities.Order;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class GUI {


    private final JPanel panelLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel panelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private final JPanel panelTop = new JPanel();


    public GUI() {

        JFrame frame = new JFrame("Kitchen application");
        frame.setMinimumSize(new Dimension(800, 450));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Border blackline = BorderFactory.createLineBorder(Color.black);

        panelLeft.setBorder(blackline);
        panelLeft.setPreferredSize(new Dimension(400, 150));
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));

        panelRight.setBorder(blackline);
        panelRight.setPreferredSize(new Dimension(400, 150));

        panelTop.setBorder(blackline);
        panelTop.setPreferredSize(new Dimension(800, 25));

//        panelLeft.setBackground(Color.GREEN);
//        panelRight.setBackground(Color.YELLOW);
        panelTop.setBackground(Color.GRAY);

//        Vector<JPanel> employees = new Vector<JPanel>();

        Vector<JLabel> employees = new Vector<JLabel>();

        for (int i = 0; i < 4; ++i) {
            for (Employee employee : App.getEmployeesFromApi()) {
//                JPanel employeePanel = new JPanel();
//                employeePanel.setLayout(new FlowLayout());
//                employeePanel.setBorder(blackline);
//                employeePanel.setPreferredSize(new Dimension(200, 30));
                employees.add(new JLabel(" " + employee.getId().toString() + "\t" + employee.getFirstName() + "\t" + employee.getFamilyName() + "\t" + employee.getEmployeeKindId().toString()));
//                JLabel id = new JLabel(employee.getId().toString());
//                JLabel firstName = new JLabel(employee.getFirstName());
//                JLabel familyName = new JLabel(employee.getFamilyName());
//                JLabel employeeKindId = new JLabel(employee.getEmployeeKindId().toString());
//                employeePanel.add(id);
//                employeePanel.add(firstName);
//                employeePanel.add(familyName);
//                employeePanel.add(employeeKindId);
//                employees.add(employeePanel);
            }
        }

        String list = new String();
        for (JLabel employee: employees) {
            list += employee.getText();
            list += '\n';
        }

        JTextArea area = new JTextArea(list);
//        scrollablePanel.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));

//        for(JPanel employee: employees) scrollablePanel.add(employee);

        JScrollPane scroll = new JScrollPane(area);
        panelLeft.add(scroll);
//        JScrollPane scroll = new JScrollPane(panelLeft);
//        scroll.setViewportView(employees);
//        employees.setLayoutOrientation(JList.VERTICAL);
//        panelLeft.add(scroll);

        frame.add(panelLeft, BorderLayout.LINE_START);
        frame.add(panelRight, BorderLayout.LINE_END);
        frame.add(panelTop, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }

//    private static void getListOfOrders() {
//        Call<List<Order>> call = App.interfaceApi.getOrders();
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(@NotNull Call<String> call, @NotNull Response<String> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    panelLeft
//                }
//            }
//
//            @Override
//            public void onFailure(@NotNull Call<String> call, @NotNull Throwable throwable) {
//
//            }
//        });
//    }

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