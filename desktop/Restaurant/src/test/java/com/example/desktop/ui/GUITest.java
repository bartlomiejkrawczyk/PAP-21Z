package com.example.desktop.ui;

import com.example.desktop.App;
import com.example.desktop.entities.Recipe;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

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

        assert(recipes.size() >0) ;
    }

}