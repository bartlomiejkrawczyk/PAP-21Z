package com.example.desktop.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class OrdersPlacedView {

    private final JPanel panel;
    private final JPanel panelTitle;
    private final JLabel panelTitleText;
    private final JPanel scrollablePanel;
    private final JScrollPane scrollFrame;

    public OrdersPlacedView() {

        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        panel.setBorder(blackLine);
        panel.setPreferredSize(new Dimension(400, 150));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panelTitle = new JPanel();
        panelTitle.setBorder(blackLine);
        panelTitle.setMaximumSize(new Dimension(5000, 35));
        panelTitle.setBackground(Color.DARK_GRAY);

        panelTitleText = new JLabel("Orders placed:");
        panelTitleText.setForeground(Color.WHITE);
        panelTitle.add(panelTitleText);

        panel.add(panelTitle);

        scrollablePanel = new JPanel();
        scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));
        scrollablePanel.setAutoscrolls(true);

        scrollFrame = new JScrollPane(scrollablePanel);
        scrollFrame.setPreferredSize(new Dimension(400, 350));
        scrollFrame.getVerticalScrollBar().setUnitIncrement(16);
        panel.add(scrollFrame);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        OrdersPlacedView view = new OrdersPlacedView();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(view.getPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JPanel getPanelTitle() {
        return panelTitle;
    }

    public JLabel getPanelTitleText() {
        return panelTitleText;
    }

    public JPanel getScrollablePanel() {
        return scrollablePanel;
    }

    public JScrollPane getScrollFrame() {
        return scrollFrame;
    }
}
