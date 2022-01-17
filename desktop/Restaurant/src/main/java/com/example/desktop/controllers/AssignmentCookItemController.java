package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Employee;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.CooksView;
import com.example.desktop.ui.ItemView;

import java.awt.event.WindowEvent;

/**
 * Class responsible for controlling each panel enabling us to assign order to cook.
 */
public class AssignmentCookItemController {

    private final ItemView view;
    private final Employee employee;
    private final Order orderToAssign;
    private final CooksView cooksView;
    private final Runnable moveOrderRunnable;

    private final AppDatabase db;

    public AssignmentCookItemController(Employee employee, ItemView view,
                                        Order orderToAssign, CooksView cooksView, Runnable moveOrderRunnable) {
        this.employee = employee;
        this.view = view;
        this.orderToAssign = orderToAssign;
        this.cooksView = cooksView;
        this.moveOrderRunnable = moveOrderRunnable;

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
        cooksView.getFrame().dispatchEvent(new WindowEvent(
                cooksView.getFrame(), WindowEvent.WINDOW_CLOSING));
        moveOrderRunnable.run();
    }
}
