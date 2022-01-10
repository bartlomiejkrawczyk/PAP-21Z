package com.example.desktop.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class OrdersInProgressView {

    private final JPanel panel;
    private final JPanel scrollablePanel;

    public OrdersInProgressView() {
        panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        panel.setBorder(blackLine);
        panel.setPreferredSize(new Dimension(400, 150));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel panelTitle = new JPanel();
        panelTitle.setBorder(blackLine);
        panelTitle.setMaximumSize(new Dimension(5000, 35));
        panelTitle.setBackground(Color.DARK_GRAY);

        JLabel panelTitleText = new JLabel("Orders in progress:");
        panelTitleText.setForeground(Color.WHITE);
        panelTitle.add(panelTitleText);

        panel.add(panelTitle);

        scrollablePanel = new JPanel();
        scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));
        scrollablePanel.setAutoscrolls(true);

        JScrollPane scrollFrame = new JScrollPane(scrollablePanel);
        scrollFrame.setPreferredSize(new Dimension(400, 350));
        scrollFrame.getVerticalScrollBar().setUnitIncrement(16);
        panel.add(scrollFrame);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JPanel getScrollablePanel() {
        return scrollablePanel;
    }

}
