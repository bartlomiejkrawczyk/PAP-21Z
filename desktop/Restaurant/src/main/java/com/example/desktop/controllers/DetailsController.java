package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.*;
import com.example.desktop.ui.DetailsView;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DetailsController {

    private final DetailsView view;
    private final AppDatabase db;
    private final Order order;

    private String details;

    public DetailsController(Order newOrder, DetailsView newView) {
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
        BufferedImage img;
        img = db.getImage(imagePath);
        if (img != null) {
            Image image = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(image);
            label.setIcon(imageIcon);
        } else {
            label.setIcon(null);
        }
    }

    private void addDetails() {
        String name;
        StringBuilder requests = new StringBuilder(" ");
        StringBuilder recipe = new StringBuilder(" ");
        StringBuilder ingredients = new StringBuilder(" ");
        String imagePath;

        Product product;
        Dish dish = db.getDishById(order.getDish().getId());

        name = dish.getName();
        imagePath = dish.getImagePath();

        for (SpecialRequest req : order.getRequests()) {
            requests.append(req.getRequest()).append("\n\t");
        }

        int step = 1;
        for (Recipe rec : dish.getRecipes()) {
            recipe.append(step).append(". ");
            recipe.append(rec.getRecipe()).append("\n\t");
            step++;
        }

        for (Ingredient ingredient : dish.getIngredients()) {
            product = db.getProductById(ingredient.getProductId());
            if (!product.getName().isEmpty()) {
                ingredients.append(ingredient.getQuantity()).append(" ");
                ingredients.append(product.getUnit()).append(" ");
                ingredients.append(product.getName()).append("\n\t");
            }
        }

        if (name.isEmpty() || name.equals(" ")) name = "null \n";
        if ((requests.length() == 0) || requests.toString().equals(" ")) requests = new StringBuilder("null \n");
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
