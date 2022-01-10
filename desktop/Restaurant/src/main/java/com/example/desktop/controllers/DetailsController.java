package com.example.desktop.controllers;

import com.example.desktop.App;
import com.example.desktop.AppDatabase;
import com.example.desktop.entities.*;
import com.example.desktop.ui.DetailsView;
import retrofit2.Call;
import retrofit2.Response;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DetailsController {

    private DetailsView view;
    private AppDatabase db;
    private Order order;

    private String details;

    public DetailsController(Order newOrder, DetailsView newView){
        this.view = newView;
        this.order = newOrder;
        details = "";
        db = AppDatabase.getAppDatabase();

        initView();
    }

    private void initView(){
        new Thread(this::addDetails).start();
    }

    private void addImage(String imagePath, JLabel label){
        BufferedImage img = null;
        img = db.getImage(imagePath);
        if (img != null) {
            Image dimg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            label.setIcon(imageIcon);
        } else {
            label.setIcon(null);
        }
    }

    private void addDetails(){
        String name;
        String requests = new String(" ");
        StringBuilder recipe = new StringBuilder(new String(" "));
        StringBuilder ingredients = new StringBuilder(new String(" "));
        String imagePath = new String(" ");

        Product product;
        Dish dish = db.getDishFromOrder(order);

        name = dish.getName();
        imagePath = dish.getImagePath();

        for (SpecialRequest req: order.getRequests()){
            requests += req.getRequest() + "\n\t";
        }

        int step = 1;
        for (Recipe rec: dish.getRecipes()){
            recipe.append(step).append(". ");
            recipe.append(rec.getRecipe()).append("\n\t");
            step++;
        }

        for (Ingredient ingr: dish.getIngredients()){
            product = db.getProductFromIngredient(ingr);
            if (!product.getName().isEmpty()){
                ingredients.append(ingr.getQuantity()).append(" ");
                ingredients.append(product.getUnit()).append(" ");
                ingredients.append(product.getName()).append("\n\t");
            }
        }

        if (name.isEmpty() || name.equals(" ")) name = "null \n";
        if (requests.isEmpty() || requests.equals(" ")) requests = "null \n";
        if ((recipe.length() == 0) || recipe.toString().equals(" ")) recipe = new StringBuilder("null \n");
        if ((ingredients.length() == 0) || ingredients.toString().equals(" ")) ingredients = new StringBuilder("null \n");
        if (imagePath.isEmpty() || imagePath.equals(" ")) imagePath = "null \n";

        details += "Name: " + name + "\n\n";
        details += "Special requests: " + requests + "\n";
        details += "Recipe:           " + recipe + "\n";
        details += "Ingredients:    " + ingredients + "\n";

        addImage(imagePath, view.getLabel());
        if (view.getLabel().getIcon() != null) {
            view.getTextArea().append(details);
            view.getFrame().pack();
        } else {
            view.getFrame().setVisible(false);
        }
    }
}
