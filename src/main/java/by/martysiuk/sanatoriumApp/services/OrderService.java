package by.martysiuk.sanatoriumApp.services;

import by.martysiuk.sanatoriumApp.models.Order;
import by.martysiuk.sanatoriumApp.models.Room;
import by.martysiuk.sanatoriumApp.models.User;

import java.util.List;

public interface OrderService {
    Order showOrder(int id);

    List<Order> showAllOrders();

    void deleteOrder(int id);

    void saveOrder(Order order, User user, Room room);

    List<Order> showMyOrders(int id);
}
