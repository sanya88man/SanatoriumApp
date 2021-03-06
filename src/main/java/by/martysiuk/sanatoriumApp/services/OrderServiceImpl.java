package by.martysiuk.sanatoriumApp.services;

import by.martysiuk.sanatoriumApp.models.Order;
import by.martysiuk.sanatoriumApp.models.Room;
import by.martysiuk.sanatoriumApp.models.User;
import by.martysiuk.sanatoriumApp.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public Order showOrder(int id) {
        return orderRepo.getById(id);
    }

    @Override
    public List<Order> showAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public void deleteOrder(int id) {
        //orderRepo.deleteById(id);//удаляет родительские
        orderRepo.deleteByID(id);
    }

    @Override
    public void saveOrder(Order order, User user, Room room) {
        order.setUserId(user.getId());
        order.setRoomId(room.getId());
        order.setUser(user);
        order.setRoom(room);
        orderRepo.save(order);
    }

    @Override
    public List<Order> showMyOrders(int id) {
        return orderRepo.findAllByUserId(id);
    }
}
