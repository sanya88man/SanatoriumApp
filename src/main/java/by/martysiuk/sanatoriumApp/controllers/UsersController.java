package by.martysiuk.sanatoriumApp.controllers;

import by.martysiuk.sanatoriumApp.models.User;
import by.martysiuk.sanatoriumApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/users")
    public String showUsers(Model model, @ModelAttribute("user") User user) {
        model.addAttribute("listUsers", userService.showUsers());
        System.out.println(userService.showUserByUsername("admin"));
        return "users/showUsers";
    }
}
