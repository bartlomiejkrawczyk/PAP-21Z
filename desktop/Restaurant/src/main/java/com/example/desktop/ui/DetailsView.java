package com.example.desktop.ui;

// okienko z nazwą disha (z disha), special requests (z orderu),
// recipe (z disha) i ingredients (składniki z disha)

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DetailsView {

    private JFrame frame;
    private JTextArea textArea;
    private Font font;
    private JLabel label;
    private JPanel panel;
    private Border blackLine;

    public DetailsView(){
        frame = new JFrame("Order details");
        textArea = new JTextArea();
        font = new Font("Serif", Font.ITALIC, 15);
        label = new JLabel();
        panel = new JPanel();
        blackLine = BorderFactory.createLineBorder(Color.black);

//        label.setPreferredSize(new Dimension(200, 200));
        textArea.setMinimumSize(new Dimension(100, 300));
        label.setBorder(blackLine);

        textArea.setFont(font);
        panel.setBackground(Color.white);
//        frame.setMinimumSize(new Dimension(400, 400));
        frame.setResizable(false);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.add(label);
        panel.add(textArea);

        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        String infos = new String("");
        infos = "Name: lazania" + "\n";
        infos = infos + "Requests: sthsth" + "\n";
        infos = infos + "   sthsth" + "\n";
        DetailsView sth = new DetailsView();
        sth.getTextArea().append(infos);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JLabel getLabel() { return label; }

    public JPanel getPanel() { return panel; }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

}
