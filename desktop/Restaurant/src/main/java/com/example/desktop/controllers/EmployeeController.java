package com.example.desktop.controllers;

import com.example.desktop.App;
import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Employee;
import com.example.desktop.ui.EmployeeView;

import javax.swing.*;
import java.awt.*;

public class EmployeeController {

    private Employee employee;
    private EmployeeView view;

    private AppDatabase db;

    public EmployeeController(Employee employee, EmployeeView view) {
        this.employee = employee;
        this.view = view;

        db = AppDatabase.getAppDatabase();
        updateView();
    }

    private void updateView() {
        view.getLabel().setText(employee.toString());
    }

    public static void main(String[] args) {
        App.createNetworkSys();
        AppDatabase db = AppDatabase.getAppDatabase();
        Employee employee = db.getEmployeeById(10L);

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        frame.setPreferredSize(new Dimension(800, 450));
        frame.setMinimumSize(new Dimension(800, 450));
        frame.setResizable(true);

        EmployeeView view = new EmployeeView();
        JPanel panel = view.getPanel();
        new EmployeeController(employee, view);
        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
