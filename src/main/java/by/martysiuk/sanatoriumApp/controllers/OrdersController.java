package by.martysiuk.sanatoriumApp.controllers;

import by.martysiuk.sanatoriumApp.models.Order;
import by.martysiuk.sanatoriumApp.models.Room;
import by.martysiuk.sanatoriumApp.models.User;
import by.martysiuk.sanatoriumApp.services.OrderService;
import by.martysiuk.sanatoriumApp.services.RoomService;
import by.martysiuk.sanatoriumApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class OrdersController {
    private final OrderService orderService;
    private final RoomService roomService;
    private final UserService userService;

    @Autowired
    public OrdersController(OrderService orderService, RoomService roomService, UserService userService) {
        this.orderService = orderService;
        this.roomService = roomService;
        this.userService = userService;
    }

    @PostMapping("/user/orders/{id}")
    String createOrder(@ModelAttribute("order") @Valid Order order,
                       BindingResult bindingResult, @PathVariable int id,
                       HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            return "orders/showOrder";
        }
        User user = userService.showUserByUsername(httpServletRequest.getRemoteUser());
        Room room = roomService.showRoom(id);

        order.setUserId(user.getId());
        order.setRoomId(room.getId());
        order.setUser(user);
        order.setRoom(room);
        orderService.saveOrder(order);
        return "redirect:/user/myOrders";
    }

    @GetMapping("/user/orders/{id}/new")
    String newOrder(@ModelAttribute("order") Order order, Model model,
                    @PathVariable int id) {
        model.addAttribute("room", roomService.showRoom(id));
        return "orders/showOrder";
    }

    @GetMapping("/user/myOrders")
    String showMyOrders(Model model, HttpServletRequest httpServletRequest) {
        User user = userService.showUserByUsername(httpServletRequest.getRemoteUser());
        model.addAttribute("orders",
                orderService.showMyOrders(user.getId()));
        return "orders/showMyOrders";
    }

    @GetMapping("/admin/orders")
    String showAllOrders(Model model) {
        model.addAttribute("orders", orderService.showAllOrders());
        return "orders/showAllOrders";
    }

    @DeleteMapping("/admin/orders/delete")
    String deleteOrderByAdmin(@ModelAttribute("order") Order order) {
        orderService.deleteOrder(order.getId());
        return "redirect:/admin/orders";
    }

    @DeleteMapping("/user/orders/delete")
    String deleteOrderByUser(@ModelAttribute("order") Order order) {
        orderService.deleteOrder(order.getId());
        return "redirect:/user/myOrders";
    }
}
