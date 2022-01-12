package com.example.desktop.controllers;

import com.example.desktop.App;
import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Employee;
import com.example.desktop.ui.CooksView;
import com.example.desktop.ui.ItemView;

import java.util.List;

public class LogIOController {

    private final CooksView view;

    private final AppDatabase db;

    public LogIOController(CooksView view) {
        this.view = view;
        db = AppDatabase.getAppDatabase();

        initView();
    }

    private void initView() {
        view.getFrame().setTitle("Cooks");
        new Thread(this::addEmployees).start();
    }

    private void addEmployees() {
        List<Employee> employees = db.getEmployeesDownloadIfEmpty();
        for (Employee e: employees) {
            ItemView itemView = new ItemView("Log In");
            new LogIOItemController(e, itemView);
            view.getScrollablePanel().add(itemView.getPanel());
        }
    }

    public static void main(String[] args) {
        App.createNetworkSys();
        CooksView view = new CooksView();
        new LogIOController(view);
    }
}