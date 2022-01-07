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

    private Dish getDish(){

        try {
            Call<Dish> call = App.interfaceApi.getDishById(order.getDish().getId());
            Response<Dish> res = call.execute();
            if (res.isSuccessful() && res.body() != null) {
                return res.body();
            } //else {
            // TODO: Handle response error
            //}
        } catch (IOException e){
            // TODO: Handle response error
        }

        return order.getDish();
    }

    private Product getProduct(Ingredient ingr){
        try {
            Call<Product> cal = App.interfaceApi.getProductById(ingr.getProductId());
            Response<Product> resp = cal.execute();
            if (resp.isSuccessful() && resp.body() != null) {
                return resp.body();
            } //else {
            // TODO: Handle response error
            //}
        } catch (IOException e) {
            // TODO: Handle response error
        }

        return new Product();
    }

    private void addDetails(){
        String name;
        String requests = new String("");
        String recipe = new String("");
        String ingredients = new String("");

        Dish dish = getDish();
        Product product;

        name = dish.getName();

        for (SpecialRequest req: order.getRequests()){
            requests += req.getRequest() + "\n";
        }

        for (Recipe rec: dish.getRecipes()){
            recipe += rec.getRecipe() + "\n";
        }

        for (Ingredient ingr: dish.getIngredients()){
            product = getProduct(ingr);
            if (!product.getName().isEmpty()){
                ingredients += product.getName() + "\n";
            }
        }

        details += "Name: " + name + "Special requests: " + requests;
        details += "Recipe: " + recipe + "Ingredients: " + ingredients;

        view.getTextArea().append(details);
    }
}
