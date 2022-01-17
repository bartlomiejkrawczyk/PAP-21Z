package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.ItemView;
import com.example.desktop.ui.OrdersPlacedView;

import java.util.List;

public class OrdersPlacedController {
    /**
     * Class responsible for controlling panel in which are placed views
     * of only placed orders.
     */

    private final OrdersPlacedView view;
    private final AppDatabase db;
    private final OrdersInProgressController ordersInProgressController;

    public OrdersPlacedController(OrdersPlacedView view, OrdersInProgressController ordersInProgressController) {
        this.view = view;
        this.ordersInProgressController = ordersInProgressController;
        db = AppDatabase.getAppDatabase();

        initView();

    }

    private void addOrders() {
        List<Order> ordersPlaced = db.getOrdersPlaced();
        for (Order order : ordersPlaced) {
            ItemView itemView = new ItemView("Assign", "Details");
            order.setDish(db.getDishById(order.getDish().getId()));
            itemView.setOrder(order);
            new OrderPlacedItemController(order, itemView, this, ordersInProgressController);
            view.getScrollablePanel().add(itemView.getPanel());
        }
    }

    public void reloadOrders() {
        /**
         * Reloads orders by: first, removing all, second, adding them again
         * and then by refreshing whole panel.
         */
        view.getScrollablePanel().removeAll();
        addOrders();
        renewPanel();
    }


    private void renewPanel() {
        /**
         * Refreshes whole panel.
         */
        view.getScrollablePanel().revalidate();
        view.getScrollablePanel().repaint();
        view.getPanel().revalidate();
        view.getPanel().repaint();
    }

    public void removeItemView(ItemView itemView) {
        /**
         * Removes itemView from list of placed orders and from panel.
         */
        db.getOrdersPlaced().remove(itemView.getOrder());
        view.getScrollablePanel().remove(itemView.getPanel());
        renewPanel();
    }


    private void initView() {
        new Thread(this::addOrders).start();
    }

    public OrdersPlacedView getView() {
        return view;
    }

    public AppDatabase getDb() {
        return db;
    }

}
