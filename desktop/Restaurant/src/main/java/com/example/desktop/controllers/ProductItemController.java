package com.example.desktop.controllers;

import com.example.desktop.entities.Product;
import com.example.desktop.ui.ItemView;
import com.example.desktop.ui.ProductsView;

public class ProductItemController {

    private Product product;
    private ItemView view;
    private ProductsController parentController;

    public ProductItemController(Product product, ItemView view, ProductsController parentController) {
        this.product = product;
        this.view = view;
        this.parentController = parentController;

        this.updateView();
        this.updateActionListener();
    }

    public void updateView() {
        this.view.getLabel().setText(
                product.getName()
                        + ", "
                        + product.getQuantity()
                        + " "
                        + product.getUnit()
        );
    }

    public void updateActionListener() {
        view.getButton1().addActionListener(e -> changeQuantity(true));
        view.getButton2().addActionListener(e -> changeQuantity(false));
    }

    public void changeQuantity(boolean increment) {
        if (increment) {
//            @ TODO:   INCREMENT QUANTITY
        }
        else {
//            @ TODO:   DECREMENT QUANTITY
//                      + CHECK IF > MIN_QUANTITY
        }
    }
}
