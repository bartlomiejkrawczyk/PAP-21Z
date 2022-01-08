package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.ui.GuiView;

import javax.swing.*;

public class GuiController {

    GuiView view;
    AppDatabase db;

    public GuiController(GuiView view){
        this.view = view;
        db = AppDatabase.getAppDatabase();

        initView();
    }

    private void initView(){
        new Thread(this::updateView).start();
    }

    private void updateView(){
        db.downloadOrders();
        Timer t = new Timer(20_000, e -> db.downloadOrders());
        t.start();

    }

    public static void main(String[] args){
        GuiView view = new GuiView();
        new GuiController(view);
    }
}


