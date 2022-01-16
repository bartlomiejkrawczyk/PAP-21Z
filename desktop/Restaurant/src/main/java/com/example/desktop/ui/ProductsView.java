package com.example.desktop.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ProductsView {

        private JFrame frame;
        private JPanel panel;
        private JPanel scrollablePanel;

    public ProductsView() {
        frame = new JFrame("Products");

        frame.setPreferredSize(new Dimension(800, 450));
        frame.setMinimumSize(new Dimension(800, 450));
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 0));

        panel = new JPanel();
        scrollablePanel = new JPanel();
        JScrollPane scrollFrame = new JScrollPane(scrollablePanel);
        scrollFrame.getVerticalScrollBar().setUnitIncrement(16);

        scrollFrame.setPreferredSize(new Dimension(300, 240));
        scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));
        scrollablePanel.setAutoscrolls(true);

        panel.add(scrollFrame);

        Border blackLine = BorderFactory.createLineBorder(Color.black);

        panel.setBorder(blackLine);
        panel.setPreferredSize(new Dimension(300, 30));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        frame.add(panel, BorderLayout.LINE_START);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JPanel getScrollablePanel() {
        return scrollablePanel;
    }

    public static void main(String[] args) {

        ProductsView productsView = new ProductsView();
    }
}


