package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.ui.CooksView;
import com.example.desktop.ui.TaskBarView;

//dodanie action listenera do buttona w view,
public class TaskBarController {

    private TaskBarView view;

    private AppDatabase db;

    public TaskBarController(TaskBarView view){
        this.view = view;

        db = AppDatabase.getAppDatabase();
        updateActionListener();
    }

    private void updateActionListener(){
        view.getButton().addActionListener(e -> showCooks());
    }

    private void showCooks(){
        CooksView cooksView = new CooksView();
        new LogIOController(cooksView);
    }
}
