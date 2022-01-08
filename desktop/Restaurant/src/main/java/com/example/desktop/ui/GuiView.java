package com.example.desktop.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GuiView {

    //JFrame?
    private JPanel panelLeft; // = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel panelRight; // = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private JPanel panelTop; // = new JPanel();
    private JPanel scrollablePanel; // = new JPanel();
    private JPanel scrollablePanelRight; // = new JPanel();

    private JScrollPane scrollFrame; // = new JScrollPane(scrollablePanel);
    private JScrollPane scrollFrameRight; // = new JScrollPane(scrollablePanelRight);
    private Border blackline; // = BorderFactory.createLineBorder(Color.black);
                // later change to blackLine

    private JButton buttonCooks; // = new JButton("Cooks");
    private JButton buttonRecipes; // = new JButton("Recipes");

    public GuiView(){
        panelLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        scrollablePanel = new JPanel();
        scrollablePanelRight = new JPanel();
        panelTop = new JPanel();

        scrollFrame = new JScrollPane(scrollablePanel);
        scrollFrameRight = new JScrollPane(scrollablePanelRight);
        blackline = BorderFactory.createLineBorder(Color.black);

        buttonCooks = new JButton("Cooks");
        buttonRecipes = new JButton("Recipes");

        //buttonCooks.setBounds(1, 1, 100, 23); ?
        //buttonRecipes.setBounds(1, 1, 100, 23); ?

    }

    public JPanel getPanelLeft(){
        return panelLeft;
    }

    public void setPanelLeft(JPanel panelLeft){
        this.panelLeft = panelLeft;
    }


    public JPanel getPanelRight() {
        return panelRight;
    }

    public JPanel getPanelTop() {
        return panelTop;
    }

    public JPanel getScrollablePanel() {
        return scrollablePanel;
    }

    public JPanel getScrollablePanelRight() {
        return scrollablePanelRight;
    }

    public JScrollPane getScrollFrame() {
        return scrollFrame;
    }

    public JScrollPane getScrollFrameRight() {
        return scrollFrameRight;
    }

    public Border getBlackline() {
        return blackline;
    }

    public JButton getButtonCooks() {
        return buttonCooks;
    }

    public JButton getButtonRecipes() {
        return buttonRecipes;
    }

    public void setPanelRight(JPanel panelRight) {
        this.panelRight = panelRight;
    }

    public void setPanelTop(JPanel panelTop) {
        this.panelTop = panelTop;
    }

    public void setScrollablePanel(JPanel scrollablePanel) {
        this.scrollablePanel = scrollablePanel;
    }

    public void setScrollablePanelRight(JPanel scrollablePanelRight) {
        this.scrollablePanelRight = scrollablePanelRight;
    }

    public void setScrollFrame(JScrollPane scrollFrame) {
        this.scrollFrame = scrollFrame;
    }

    public void setScrollFrameRight(JScrollPane scrollFrameRight) {
        this.scrollFrameRight = scrollFrameRight;
    }

    public void setBlackline(Border blackline) {
        this.blackline = blackline;
    }

    public void setButtonCooks(JButton buttonCooks) {
        this.buttonCooks = buttonCooks;
    }

    public void setButtonRecipes(JButton buttonRecipes) {
        this.buttonRecipes = buttonRecipes;
    }
}
