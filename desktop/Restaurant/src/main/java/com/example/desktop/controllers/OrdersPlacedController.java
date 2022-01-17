package com.example.desktop.controllers;

import com.example.desktop.AppDatabase;
import com.example.desktop.entities.Order;
import com.example.desktop.ui.ItemView;
import com.example.desktop.ui.OrdersPlacedView;

import java.util.List;

/**
 * Class responsible for controlling panel in which are placed views
 * of only placed orders.
 */
public class OrdersPlacedController {

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

    /**
     * Reloads orders by: first, removing all, second, adding them again
     * and then by refreshing whole panel.
     */
    public void reloadOrders() {
        view.getScrollablePanel().removeAll();
        addOrders();
        renewPanel();
    }


    /**
     * Refreshes whole panel.
     */
    private void renewPanel() {
        view.getScrollablePanel().revalidate();
        view.getScrollablePanel().repaint();
        view.getPanel().revalidate();
        view.getPanel().repaint();
    }

    /**
     * Removes itemView from list of placed orders and from panel.
     */
    public void removeItemView(ItemView itemView) {
        db.getOrdersPlaced().remove(itemView.getOrder());
        view.getScrollablePanel().remove(itemView.getPanel());
        renewPanel();
    }


    private void initView() {
        new Thread(this::addOrders).start();
    }

}
