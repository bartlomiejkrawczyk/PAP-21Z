package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Employee;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.ItemView;

public class AssignmentCookItemController {

    private final ItemView view;
    private Employee employee;
    private Order orderToAssign;

    private final AppDatabase db;

    public AssignmentCookItemController(Employee employee, ItemView view, Order orderToAssign) {
        this.employee = employee;
        this.view = view;
        this.orderToAssign = orderToAssign;

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
        db.setEmployeePreparingOrder(orderToAssign, employee.getId());
        // TODO: Usuwanie orderu z listy po lewej od razu
        // TODO: Dodanie orderu do listy po prawej
    }
}
