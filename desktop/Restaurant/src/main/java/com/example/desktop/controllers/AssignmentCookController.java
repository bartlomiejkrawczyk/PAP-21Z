package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Employee;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.CooksView;
import com.example.desktop.ui.ItemView;

import java.util.List;

public class AssignmentCookController {

    private CooksView view;
    private Order orderToAssign;

    private AppDatabase db;

    public AssignmentCookController(CooksView view, Order orderToAssign) {
        this.view = view;
        this.orderToAssign = orderToAssign;
        db = AppDatabase.getAppDatabase();

        updateView();
        addLoggedInEmployees();
    }

    public void updateView() {
        view.getFrame().setTitle("Assign a cook");
    }

    private void addLoggedInEmployees() {
        List<Employee> employees = db.getLoggedInEmployees();
        for (Employee e: employees) {
            ItemView itemView = new ItemView("Assign");
            new AssignmentCookItemController(e, itemView, orderToAssign, view);
            view.getScrollablePanel().add(itemView.getPanel());
        }
    }
}
