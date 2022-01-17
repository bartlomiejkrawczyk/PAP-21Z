package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.*;
import com.example.desktop.ui.DetailsView;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Class responsible for controlling frame with details.
 */
public class DetailsController {

    private final DetailsView view;
    private final AppDatabase db;
    private final Order order;

    public DetailsController(Order newOrder, DetailsView newView) {
        this.view = newView;
        this.order = newOrder;
        db = AppDatabase.getAppDatabase();

        initView();
    }

    private void initView(){
        new Thread(this::addDetails).start();
    }

    private void addImage(String imagePath) {
        BufferedImage img;
        img = db.getImage(imagePath);
        if (img != null) {
            Image image = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(image);
            view.getLabel().setIcon(imageIcon);
        } else {
            view.getLabel().setIcon(null);
        }

        view.getFrame().pack();
    }

    private void addDetails() {
        Dish dish = db.getDishById(order.getDish().getId());

        String details = "\nName:\t" + dish.getName() + "\n\n";

        if (order.getRequests().size() > 0) {
            StringBuilder requests = new StringBuilder();
            for (SpecialRequest req : order.getRequests()) {
                requests.append("\n\t").append(req.getRequest());
            }
            details += "Special requests:" + requests + "\n\n";
        }

        if (dish.getRecipes().size() > 0) {
            StringBuilder recipe = new StringBuilder();
            int step = 1;
            for (Recipe rec : dish.getRecipes()) {
                recipe.append("\n\t")
                        .append(step)
                        .append(". ")
                        .append(rec.getRecipe());
                step++;
            }
            details += "Recipe:" + recipe + "\n\n";
        }

        if (dish.getIngredients().size() > 0) {
            StringBuilder ingredients = new StringBuilder();
            for (Ingredient ingredient : dish.getIngredients()) {
                Product product = db.getProductById(ingredient.getProductId());
                if (product.getName() != null) {
                    ingredients.append("\n\t")
                            .append(String.format("%1$-28s", product.getName()))
                            .append(String.format("%1$15s", ingredient.getQuantity() + " " + product.getUnit()));
                }
            }
            details += "Ingredients:    " + ingredients;
        }

        String imagePath = dish.getImagePath();

        if (imagePath != null) {
            BufferedImage img = new BufferedImage(300, 300, 1);
            Image image = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(image);
            view.getLabel().setIcon(imageIcon);

            new Thread(() -> addImage(imagePath)).start();
        }
        details += "\n";

        view.getTextArea().append(details);
        if (System.getProperty("os.name").equals("Windows 10"))
            view.getTextArea().setFont(new Font("Consolas", Font.PLAIN, 14));
        else
            view.getTextArea().setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        view.getFrame().pack();
    }
}
