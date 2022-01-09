package com.example.desktop.controllers;

import com.example.desktop.App;
import com.example.desktop.AppDatabase;
import com.example.desktop.entities.*;
import com.example.desktop.ui.DetailsView;
import retrofit2.Call;
import retrofit2.Response;

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


    private void addDetails(){
        String name;
        String requests = new String(" ");
        String recipe = new String(" ");
        String ingredients = new String("  ");

        Product product;
        Dish dish = db.getDishFromOrder(order);

        name = dish.getName();

        for (SpecialRequest req: order.getRequests()){
            requests += req.getRequest() + "\n\t";
        }

        for (Recipe rec: dish.getRecipes()){
            recipe += rec.getRecipe() + "\n\t";
        }

        for (Ingredient ingr: dish.getIngredients()){
            product = db.getProductFromIngredient(ingr);
            if (!product.getName().isEmpty()){
                ingredients += product.getName() + "\n\t";
            }
        }

        if (name.isBlank()){
        name = "null \n";
        }
        if (requests.isBlank()) {
            requests = "null \n";
        }
        if (recipe.isBlank()){
            recipe = "null \n";
        }
        if (ingredients.isBlank()){
            ingredients = "null \n";
        }

        details += "Name: " + name + "\n\n";
        details += "Special requests: " + requests + "\n";
        details += "Recipe: " + recipe + "\n";
        details += "Ingredients: " + ingredients + "\n";

        view.getTextArea().append(details);
    }
}
