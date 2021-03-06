package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Employee;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.CooksView;
import com.example.desktop.ui.ItemView;

import java.util.List;

/**
 * Class responsible for controlling whole frame which enables us to
 * assign orders to cooks.
 */
public class AssignmentCookController {

    private final CooksView view;
    private final Order orderToAssign;
    private final Runnable moveOrderRunnable;

    private final AppDatabase db;

    public AssignmentCookController(CooksView view, Order orderToAssign, Runnable moveOrderRunnable) {
        this.view = view;
        this.orderToAssign = orderToAssign;
        this.moveOrderRunnable = moveOrderRunnable;
        db = AppDatabase.getAppDatabase();

        updateView();
        addLoggedInEmployees();
    }

    private void updateView() {
        view.getFrame().setTitle("Assign a cook");
    }

    private void addLoggedInEmployees() {
        List<Employee> employees = db.getLoggedInEmployees();
        for (Employee e: employees) {
            ItemView itemView = new ItemView("Assign");
            new AssignmentCookItemController(e, itemView, orderToAssign, view, moveOrderRunnable);
            view.getScrollablePanel().add(itemView.getPanel());
        }
    }
}
