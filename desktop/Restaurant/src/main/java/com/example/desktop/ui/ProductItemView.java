package com.example.desktop.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Class creating and facilitating view of whole panel enabling us to
 * see product and its quantity.
 */
public class ProductItemView {

    private final JPanel panel;
    private final JLabel productName;
    private final JLabel quantityAndUnit;

    private final JTextField inputTextField;
    private final JButton button;

    public ProductItemView() {

        Border blackLine = BorderFactory.createLineBorder(Color.black);

        panel = new JPanel();
        panel.setBorder(blackLine);
        panel.setPreferredSize(new Dimension(350, 28));
        panel.setMaximumSize(new Dimension(5000, 28));
        panel.setMinimumSize(new Dimension(100, 28));
        panel.setLayout(new GridLayout(1, 4));

        productName = new JLabel();

        inputTextField = new JTextField(3);
        inputTextField.setSize(40, 28);

        quantityAndUnit = new JLabel();

        button = new JButton();
        button.setSize(150, 28);

        panel.add(productName);
        panel.add(quantityAndUnit);
        panel.add(inputTextField);
        panel.add(button);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getProductName() {
        return productName;
    }

    public JLabel getQuantityAndUnit() {
        return quantityAndUnit;
    }

    public JTextField getInputTextField() {
        return inputTextField;
    }

    public JButton getButton() {
        return button;
    }

}
