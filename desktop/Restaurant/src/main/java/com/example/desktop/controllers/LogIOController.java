package com.example.desktop.controllers;

import com.example.desktop.App;
import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Employee;
import com.example.desktop.ui.ItemView;
import com.example.desktop.ui.CooksView;

import java.util.List;

public class LogIOController {

    private CooksView view;

    private AppDatabase db;

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

    public void initController() {
    }

    public static void main(String[] args) {
        App.createNetworkSys();
        CooksView view = new CooksView();
        LogIOController controller = new LogIOController(view);
        controller.initController();
    }
}