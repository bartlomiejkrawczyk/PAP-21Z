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

    private JButton buttonCooks;
    private JButton buttonRecipes;

    public GuiView(){
        frame = new JFrame("Kitchen application");
        panelLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//        scrollablePanel = new JPanel();
//        scrollablePanelRight = new JPanel();
        panelTop = new JPanel();


        panelLeft.setBorder(blackLine);
        panelLeft.setPreferredSize(new Dimension(400, 150));
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));

        panelRight.setBorder(blackLine);
        panelRight.setPreferredSize(new Dimension(400, 150));
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));

        panelTop.setBorder(blackLine);
        panelTop.setPreferredSize(new Dimension(800, 25));
        panelTop.setBackground(Color.GRAY);
        panelTop.setLayout(null);

        JPanel panelLeftTitle = new JPanel();
        panelLeftTitle.setBorder(blackLine);
        panelLeftTitle.setBackground(Color.DARK_GRAY);

        JPanel panelRightTitle = new JPanel();
        panelRightTitle.setBorder(blackLine);
        panelRightTitle.setBackground(Color.DARK_GRAY);

        JLabel panelLeftTitleText = new JLabel("Orders placed:");
        panelLeftTitleText.setForeground(Color.WHITE);

        panelLeftTitle.add(panelLeftTitleText);
        panelLeft.add(panelLeftTitle);

        JLabel panelRightTitleText = new JLabel("Orders in progress:");
        panelRightTitleText.setForeground(Color.WHITE);

        panelRightTitle.add(panelRightTitleText);
        panelRight.add(panelRightTitle);

//        scrollFrame = new JScrollPane(scrollablePanel);
//        scrollFrameRight = new JScrollPane(scrollablePanelRight);
        blackLine = BorderFactory.createLineBorder(Color.black);


        //buttonCooks.setBounds(1, 1, 100, 23); ?
        //buttonRecipes.setBounds(1, 1, 100, 23); ?

        frame.setMinimumSize(new Dimension(800, 450));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

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

    public JButton getButtonCooks() {
        return buttonCooks;
    }

    public JButton getButtonRecipes() {
        return buttonRecipes;
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
