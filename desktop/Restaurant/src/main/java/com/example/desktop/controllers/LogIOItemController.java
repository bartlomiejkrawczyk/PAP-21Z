package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Employee;
import com.example.desktop.ui.ItemView;

import java.awt.event.ActionListener;

public class LogIOItemController {

    private final Employee employee;
    private final ItemView view;
    private final AppDatabase db;
    private boolean loggedIn;

    private ActionListener actionListener;

    public LogIOItemController(Employee employee, ItemView view) {
        this.employee = employee;
        this.view = view;

        db = AppDatabase.getAppDatabase();

        this.loggedIn = db.getLoggedInEmployees().contains(employee);

        updateView();
        updateActionListener();
    }

    private void updateView() {
        view.getLabel().setText(employee.toString());
        if (loggedIn)
            view.getButton1().setText("Log Out");
        else
            view.getButton1().setText("Log In");
    }

    private void updateActionListener() {
        if (loggedIn)
            actionListener = e -> logOut();
        else
            actionListener = e -> logIn();
        view.getButton1().addActionListener(actionListener);
    }

    private void logOut() {
        loggedIn = false;
        db.logOut(employee);
        updateView();

        view.getButton1().removeActionListener(actionListener);
        updateActionListener();
    }

    private void logIn() {
        loggedIn = true;
        db.logIn(employee);
        updateView();

        view.getButton1().removeActionListener(actionListener);
        updateActionListener();
    }
}