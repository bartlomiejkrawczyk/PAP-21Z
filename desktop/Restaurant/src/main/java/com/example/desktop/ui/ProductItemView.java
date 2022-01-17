package com.example.desktop.ui;

import com.example.desktop.entities.Product;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Class creating and facilitating view of whole panel enabling us to
 * see product and its quantity.
 */
public class ProductItemView {

    private JPanel panel;
    private JLabel productName;
    private JLabel quantityAndUnit;

    private JTextField inputTextField;
    private JButton button;

    private Product product;

    public ProductItemView() {

        Border blackLine = BorderFactory.createLineBorder(Color.black);

        panel = new JPanel();
        panel.setBorder(blackLine);
        panel.setPreferredSize(new Dimension(350, 28));
        panel.setMaximumSize(new Dimension(5000, 28));
        panel.setMinimumSize(new Dimension(100, 28));
        panel.setLayout(new GridLayout(1, 4));

        productName = new JLabel();
//        productName.setBounds(25, 0, 250, 30);

        inputTextField = new JTextField(3);
        inputTextField.setSize(40, 28);

        quantityAndUnit = new JLabel();
//        quantityAndUnit.setBounds(25, 30, 250, 30);

        button = new JButton();
        button.setSize(150, 28);

        panel.add(productName);
        panel.add(quantityAndUnit);
        panel.add(inputTextField);
        panel.add(button);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ProductItemView view = new ProductItemView();
        view.getButton().setText("Update quantity");
        view.getProductName().setText("Cola");
        view.getQuantityAndUnit().setText("18 Litres");

        frame.add(view.getPanel());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    } //TODO: remove this

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
