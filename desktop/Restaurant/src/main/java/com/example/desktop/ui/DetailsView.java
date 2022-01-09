package com.example.desktop.ui;

// okienko z nazwą disha (z disha), special requests (z orderu),
// recipe (z disha) i ingredients (składniki z disha)

import javax.swing.*;
import java.awt.*;

public class DetailsView {

    private JFrame frame;
    private JTextArea textArea;
    private Font font;
    private JLabel label;

    public DetailsView(){
        frame = new JFrame("Order details");
        textArea = new JTextArea();
        font = new Font("Serif", Font.ITALIC, 15);
        label = new JLabel();

        label.setMinimumSize(new Dimension(100, 100));

        textArea.setFont(font);
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setResizable(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(textArea);
//        frame.add(label);

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

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

}
