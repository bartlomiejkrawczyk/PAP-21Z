package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Product;
import com.example.desktop.ui.ProductItemView;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ProductItemController {
    /**
     * Class responsible for controlling view of particular product.
     */

    private final Product product;
    private final ProductItemView view;
    private final AppDatabase db;

    public ProductItemController(Product product, ProductItemView view) {
        this.product = product;
        this.view = view;
        db = AppDatabase.getAppDatabase();

        this.updateView();
        this.updateActionListener();
        this.updateFocusListener();
    }

    public void updateView() {
        /**
         * Set basic settings of view.
         */
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
        /**
         * Updates setting for text listeners in view.
         */
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
        /**
         * Adds button which enable to change quantity of product.
         */
        view.getButton().addActionListener(e -> new Thread(this::changeQuantity).start());
    }

    public void changeQuantity() {
        /**
         * Changes quantities of product in database and in view.
         */
        String text = view.getInputTextField().getText();
        long value;
        try {
            value = Long.parseLong(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    new JFrame(),
                    e,
                    "Invalid Number",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        db.incrementProductQuantity(product, value);
        view.getQuantityAndUnit().setText(
                product.getQuantity()
                        + " ("
                        + product.getUnit()
                        + ")"
        );
        view.getInputTextField().setText("Enter amount");
    }
}
