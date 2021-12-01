package com.example.desktop.ui;

import com.example.desktop.App;
import com.example.desktop.entities.Recipe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class GUITest {
    private GUI gui;

    @Before
    public void prepareNetworkSys() {
        App.createNetworkSys();
        gui = new GUI();
    }

    @Test
    public void testDownloadAllRecipes() {
        List<Recipe> recipes = gui.downloadAllRecipes();

        assertEquals(17, recipes.size());
    }

    @Test
    public void testGetOneRecipe(){
        List<Recipe> recipes = gui.downloadAllRecipes();
        Vector<String> currRecipe = gui.getOneRecipe(1, recipes);

        assertEquals(8, currRecipe.size());
    }
}