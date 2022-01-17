package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Product;
import com.example.desktop.ui.ProductItemView;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Class responsible for controlling view of particular product.
 */
public class ProductItemController {

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

    /**
     * Set basic settings of view.
     */
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

    /**
     * Updates setting for text listeners in view.
     */
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

    /**
     * Adds button which enable to change quantity of product.
     */
    public void updateActionListener() {
        view.getButton().addActionListener(e -> new Thread(this::changeQuantity).start());
    }

    /**
     * Changes quantities of product in database and in view.
     */
    public void changeQuantity() {
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
