package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Product;
import com.example.desktop.ui.ProductView;
import com.example.desktop.ui.ProductsView;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class ProductsController {

    private final ProductsView view;

    private final AppDatabase db;

    private final Timer timer;

    public ProductsController(ProductsView view) {
        this.view = view;
        db = AppDatabase.getAppDatabase();
        timer = new Timer(20_000, e -> {
            db.downloadProducts();
            reloadProducts();
        });

        initView();
        timer.start();
    }

    private void initView() {
        view.getFrame().setTitle("Products");
        view.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                timer.stop();
            }
        });
        new Thread(this::addProducts).start();
    }

    private void addProducts() {
        List<Product> products = db.getProductsDownloadIfEmpty();
        for (Product product: products) {
            ProductView productView = new ProductView();
            productView.setProduct(product);
            new ProductItemController(product, productView);
            view.getScrollablePanel().add(productView.getPanel());
        }
    }

    public void reloadProducts() {
        view.getScrollablePanel().removeAll();
        addProducts();
        renewPanel();
    }

    private void renewPanel() {
        view.getScrollablePanel().revalidate();
        view.getScrollablePanel().repaint();
        view.getPanel().revalidate();
        view.getPanel().repaint();
    }

    public ProductsView getView() {
        return view;
    }

    public AppDatabase getDb() {
        return db;
    }
}
