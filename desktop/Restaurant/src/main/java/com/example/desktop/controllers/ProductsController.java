package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Product;
import com.example.desktop.ui.ItemView;
import com.example.desktop.ui.ProductsView;

import java.util.List;

public class ProductsController {
    // TODO: Create view to display product list and one to display a product
    //  - additionally there could be an indication whether product.getQuantity() > product.getMinQuantity();
    // TODO: implement method reloadOrders
    // TODO: implement method to increaseQuantity
    //  @see InterfaceApi increaseProductQuantity

    private ProductsView view;

    private AppDatabase db;

    public ProductsController(ProductsView view) {
        this.view = view;
        db = AppDatabase.getAppDatabase();

        initView();
    }

    private void initView() {
        view.getFrame().setTitle("Products");
        new Thread(this::addProducts).start();
    }

    private void addProducts() {
        List<Product> products = db.getProducts();
        for (Product product: products) {
            ItemView itemView = new ItemView("+", "-");
            new ProductItemController(product, itemView, this);
            view.getScrollablePanel().add(itemView.getPanel());
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
