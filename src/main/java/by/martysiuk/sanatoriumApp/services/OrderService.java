package by.martysiuk.sanatoriumApp.services;

import by.martysiuk.sanatoriumApp.models.Order;

import java.util.List;

public interface OrderService {
    Order showOrder(int id);

    List<Order> showAllOrders();

    void deleteOrder(int id);

    void saveOrder(Order order);

    List<Order> showMyOrders(int id);
}
