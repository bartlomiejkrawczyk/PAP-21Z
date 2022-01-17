package com.example.desktop.controllers;

import com.example.desktop.ui.CooksView;
import com.example.desktop.ui.ProductsView;
import com.example.desktop.ui.TaskBarView;

/**
 * Class responsible for controlling bar in which we place
 * other buttons.
 */
public class TaskBarController {

    private final TaskBarView view;

    public TaskBarController(TaskBarView view){
        this.view = view;

        updateActionListener();
    }

    private void updateActionListener(){
        view.getButton1().addActionListener(e -> showCooks());
        view.getButton2().addActionListener(e -> showProducts());
    }

    private void showCooks(){
        CooksView cooksView = new CooksView();
        new LogIOController(cooksView);
    }

    private void showProducts() {
        ProductsView productsView = new ProductsView();
        new ProductsController(productsView);
    }
}
