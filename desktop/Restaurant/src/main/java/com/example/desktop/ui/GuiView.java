package com.example.desktop.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GuiView {

    private JFrame frame;
    private JPanel panelLeft;
    private JPanel panelRight;
    private JPanel panelTop;

//    private JPanel scrollablePanel;
//    private JPanel scrollablePanelRight;
//    private JScrollPane scrollFrame;
//    private JScrollPane scrollFrameRight;

    private Border blackLine;

    public GuiView(){
        frame = new JFrame("Kitchen application");
        blackLine = BorderFactory.createLineBorder(Color.black);

        frame.setMinimumSize(new Dimension(800, 450));
        frame.setResizable(false);

//        scrollablePanel = new JPanel();
//        scrollablePanelRight = new JPanel();
//        scrollFrame = new JScrollPane(scrollablePanel);
//        scrollFrameRight = new JScrollPane(scrollablePanelRight);

        addPanelLeft();
        addPanelRight();
        addPanelTop();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void addPanelLeft(){
        panelLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panelLeftTitle = new JPanel();
        JLabel panelLeftTitleText = new JLabel("Orders placed:");

        panelLeft.setBorder(blackLine);
        panelLeft.setPreferredSize(new Dimension(400, 150));
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));

        panelLeftTitle.setBorder(blackLine);
        panelLeftTitle.setBackground(Color.DARK_GRAY);

        panelLeftTitleText.setForeground(Color.WHITE);

        panelLeftTitle.add(panelLeftTitleText);
        panelLeft.add(panelLeftTitle);

        frame.add(panelLeft, BorderLayout.LINE_START);
    }

    private void addPanelRight(){
        panelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel panelRightTitle = new JPanel();
        JLabel panelRightTitleText = new JLabel("Orders in progress:");

        panelRight.setBorder(blackLine);
        panelRight.setPreferredSize(new Dimension(400, 150));
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));

        panelRightTitle.setBorder(blackLine);
        panelRightTitle.setBackground(Color.DARK_GRAY);

        panelRightTitleText.setForeground(Color.WHITE);

        panelRightTitle.add(panelRightTitleText);
        panelRight.add(panelRightTitle);

        frame.add(panelRight, BorderLayout.LINE_END);
    }

    private void addPanelTop(){
        panelTop = new JPanel();

        panelTop.setBorder(blackLine);
        panelTop.setPreferredSize(new Dimension(800, 25));
        panelTop.setBackground(Color.GRAY);
        panelTop.setLayout(null);

        frame.add(panelTop, BorderLayout.NORTH);
    }

    public JPanel getPanelLeft(){
        return panelLeft;
    }

    public JPanel getPanelRight() {
        return panelRight;
    }

    public JPanel getPanelTop() {
        return panelTop;
    }

    public Border getBlackLine() {
        return blackLine;
    }

    //    public JPanel getScrollablePanel() {
//        return scrollablePanel;
//    }
//
//    public JPanel getScrollablePanelRight() {
//        return scrollablePanelRight;
//    }
//
//    public JScrollPane getScrollFrame() {
//        return scrollFrame;
//    }
//
//    public JScrollPane getScrollFrameRight() {
//        return scrollFrameRight;
//    }
}
