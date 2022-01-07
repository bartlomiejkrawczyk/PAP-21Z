package com.example.desktop.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class OrdersInProgressView {

    private JPanel panel;
    private JPanel scrollablePanel;
    private JPanel panelTitle;

    private JScrollPane scrollFrame;
    private JLabel panelTitleText;

    private Border blackLine;


    public OrdersInProgressView(){
        panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        scrollablePanel = new JPanel();
        scrollFrame = new JScrollPane(scrollablePanel);
        panelTitle = new JPanel();
        panelTitleText = new JLabel("Orders in progress:");
        blackLine = BorderFactory.createLineBorder(Color.black);

        panelTitleText.setForeground(Color.WHITE);

        panelTitle.setBorder(blackLine);
        panelTitle.setBackground(Color.DARK_GRAY);
        panelTitle.add(panelTitleText);

        scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));
        scrollablePanel.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension(400, 350));

        panel.setBorder(blackLine);
        panel.setPreferredSize(new Dimension(400, 150));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panelTitle);
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
