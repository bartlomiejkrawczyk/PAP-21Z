package com.example.desktop.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class OrdersInProgressView {

    private Border blackLine = BorderFactory.createLineBorder(Color.black);

    private JPanel panel;
    private JPanel scrollablePanel;
    private JPanel panelTitle;

    private JScrollPane scrollFrame;
    private JLabel panelTitleText;



    public OrdersInProgressView(){
        panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.setBorder(blackLine);
        panel.setPreferredSize(new Dimension(400, 150));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panelTitle = new JPanel();
        panelTitle.setBorder(blackLine);
        panelTitle.setBackground(Color.DARK_GRAY);

        panelTitleText = new JLabel("Orders in progress:");
        panelTitleText.setForeground(Color.WHITE);
        panelTitle.add(panelTitleText);

        panel.add(panelTitle);

        scrollablePanel = new JPanel();
        scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));
        scrollablePanel.setAutoscrolls(true);

        scrollFrame = new JScrollPane(scrollablePanel);
        scrollFrame.setPreferredSize(new Dimension(400, 350));
        panel.add(scrollFrame);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JPanel getScrollablePanel() {
        return scrollablePanel;
    }

    public JPanel getPanelTitle() {
        return panelTitle;
    }

    public JScrollPane getScrollFrame() {
        return scrollFrame;
    }

    public JLabel getPanelTitleText() {
        return panelTitleText;
    }
}
