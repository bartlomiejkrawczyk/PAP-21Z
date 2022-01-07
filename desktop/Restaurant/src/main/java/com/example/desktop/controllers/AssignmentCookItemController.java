package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Employee;
import com.example.desktop.ui.ItemView;

public class AssignmentCookItemController {

    private final Employee employee;
    private final ItemView view;

    private final AppDatabase db;

    public AssignmentCookItemController(Employee employee, ItemView view) {
        this.employee = employee;
        this.view = view;

        db = AppDatabase.getAppDatabase();
        updateView();
        updateActionListener();
    }

    private void updateView() {
        view.getLabel().setText(employee.toString());
    }

    private void updateActionListener() {
        view.getButton1().addActionListener(e -> assignCook());
    }

    private void assignCook() {
        // co się będzie działo po wciśnięciu przycisku "Assign"
    }
}
