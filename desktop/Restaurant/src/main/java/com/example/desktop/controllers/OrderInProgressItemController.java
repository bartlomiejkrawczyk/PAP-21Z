package com.example.desktop.controllers;

import com.example.desktop.App;
import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Employee;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.DetailsView;
import com.example.desktop.ui.ItemView;

public class OrderInProgressItemController {

    private Order orderInProgress;
    private ItemView view;
    private AppDatabase db;

    public OrderInProgressItemController(Order order, ItemView view){
        this.orderInProgress = order;
        this.view = view;

        db = AppDatabase.getAppDatabase();

        updateView();
        updateActionListener();
    }

    private void updateView() {
        String label;
        label = orderInProgress.getDish().getName();
        label += "  (:";
        label += getInitials();
        label += ") ";
        this.view.getLabel().setText(label);
    }

    private String getInitials(){
        StringBuilder initials = new StringBuilder();
        int nameI, surnameI;

        Employee cook = db.getEmployeeById(orderInProgress.getEmployee().getId());
        char[] nameChars = cook.getFirstName().toCharArray();
        char[] surnameChars = cook.getFamilyName().toCharArray();

        if (!(nameChars.length > 2)){
            nameI = nameChars.length;
        } else {
            nameI = 3;
        }

        if (!(surnameChars.length > 2)){
            surnameI = surnameChars.length;
        } else {
            surnameI = 3;
        }

        for (char ch: nameChars){
            initials.append(ch);
            nameI -= 1;
            if (nameI < 1){
                break;
            }
        }

        for (char ch: surnameChars){
            initials.append(ch);
            surnameI -= 1;
            if (surnameI < 1){
                break;
            }
        }

        return initials.toString();
    }

    private void updateActionListener(){
        view.getButton1().addActionListener(e -> orderDone());
        view.getButton2().addActionListener(e -> showDetails());
    }

    private void orderDone(){
        db.advanceOrderStatus(orderInProgress);
    }

    private void showDetails(){
        DetailsView view = new DetailsView();
        new DetailsController(orderInProgress, view);
    }
}
