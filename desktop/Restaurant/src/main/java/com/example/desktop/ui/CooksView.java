package com.example.desktop.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CooksView {

    private JFrame frame;
    private JPanel panel;
//    private JPanel panelTitle;
    private JPanel scrollablePanel;
    private JScrollPane scrollFrame;

    public CooksView() {
        frame = new JFrame();
        // Set frame sizes
        frame.setMinimumSize(new Dimension(200, 200));
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 0));

        // Create UI elements
        panel = new JPanel();
//        panelTitle = new JPanel();
        scrollablePanel = new JPanel();
        scrollFrame = new JScrollPane(scrollablePanel);
        scrollFrame.getVerticalScrollBar().setUnitIncrement(16);

        // Add UI element to frame
        scrollFrame.setPreferredSize(new Dimension(300, 240));
        scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));
        scrollablePanel.setAutoscrolls(true);

//        panelTitle.setBackground(Color.DARK_GRAY);
//        panelTitle.setBounds(1, 1, 300, 30);
//        panel.add(panelTitle);
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


    public static void main(String[] args) {
        new CooksView();
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

    public JScrollPane getScrollFrame() {
        return scrollFrame;
    }
}
