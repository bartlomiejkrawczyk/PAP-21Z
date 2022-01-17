package com.example.desktop.controllers;

import com.example.desktop.entities.Product;
import com.example.desktop.ui.ItemView;
import com.example.desktop.ui.ProductView;
import com.example.desktop.ui.ProductsView;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ProductItemController {

    private Product product;
    private ProductView view;
    private ProductsController parentController;

    public ProductItemController(Product product, ProductView view, ProductsController parentController) {
        this.product = product;
        this.view = view;
        this.parentController = parentController;

        this.updateView();
        this.updateActionListener();
        this.updateFocusListener();
    }

    public void updateView() {
        view.getInputTextField().setText("Enter amount");
        view.getButton().setText("Update quantity");
        view.getProductName().setText(product.getName());
        view.getQuantityAndUnit().setText(
                product.getQuantity()
                + " ("
                + product.getUnit()
                + ")"
        );
    }

    public void updateFocusListener() {
        view.getInputTextField().addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                view.getInputTextField().setText("Enter amount");
            }

            @Override
            public void focusGained(FocusEvent e) {
                view.getInputTextField().setText("");
            }
        });
    }

    public void updateActionListener() {
        view.getButton().addActionListener(e -> changeQuantity());
    }

    public void changeQuantity() {
        String text = view.getInputTextField().getText();
        try {
            int value = Integer.parseInt(text);
        } catch (NumberFormatException e) {
//            @ TODO:   handle text is not int exception
        }

        //  (możliwe, że bez dwóch przypadków na increment i decrement)
        if (Integer.parseInt(text) > 0) {
//            @ TODO:   increment quantity
        }
        else {
//            @ TODO:   decrement quantity
//                      + check if quantity >= min_quantity
        }
    }
}
