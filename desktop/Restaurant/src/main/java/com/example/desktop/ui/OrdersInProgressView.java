package com.example.desktop.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class OrdersInProgressView {

    private JPanel panelRight;
    private JPanel scrollablePanelRight;
    private JPanel panelRightTitle;

    private JScrollPane scrollFrameRight;
    private JLabel panelRightTitleText;

    private Border blackLine;


    public OrdersInProgressView(){
        panelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        scrollablePanelRight = new JPanel();
        scrollFrameRight = new JScrollPane(scrollablePanelRight);
        panelRightTitle = new JPanel();
        panelRightTitleText = new JLabel("Orders in progress:");
        blackLine = BorderFactory.createLineBorder(Color.black);

        panelRightTitleText.setForeground(Color.WHITE);

        panelRightTitle.setBorder(blackLine);
        panelRightTitle.setBackground(Color.DARK_GRAY);
        panelRightTitle.add(panelRightTitleText);

        scrollablePanelRight.setLayout(new BoxLayout(scrollablePanelRight, BoxLayout.Y_AXIS));
        scrollablePanelRight.setAutoscrolls(true);
        scrollFrameRight.setPreferredSize(new Dimension(400, 350));

        panelRight.setBorder(blackLine);
        panelRight.setPreferredSize(new Dimension(400, 150));
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.add(panelRightTitle);
        panelRight.add(scrollFrameRight);

    }

    public JPanel getPanelRight() {
        return panelRight;
    }

    public JPanel getScrollablePanelRight() {
        return scrollablePanelRight;
    }

    public JPanel getPanelRightTitle() {
        return panelRightTitle;
    }

    public JScrollPane getScrollFrameRight() {
        return scrollFrameRight;
    }

    public JLabel getPanelRightTitleText() {
        return panelRightTitleText;
    }
}
