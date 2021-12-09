package by.martysiuk.sanatoriumApp.controllers;

import by.martysiuk.sanatoriumApp.models.User;
import by.martysiuk.sanatoriumApp.services.RoleService;
import by.martysiuk.sanatoriumApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UsersController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String index() {
        return "users/index";
    }

    @GetMapping("/403")
    public String error403() {
        return "users/403";
    }

    @GetMapping("/users/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/newUser";
    }

    @PostMapping("/users/processRegister")
    public String createUser(@ModelAttribute("user") User user) {
        if (userService.showUserByUsername(user.getUsername()) != null) {
            return "users/errAddUser";
        }
        userService.saveUser(user);
        return "users/registerSuccess";
    }

    @GetMapping("/admin/users")
    public String showUsers(Model model, @ModelAttribute("user") User user) {
        model.addAttribute("listUsers", userService.showUsers());
        //model.addAttribute("listRoles", userService.showRoles());
        return "users/showUsers";
    }

    @DeleteMapping("/admin/users/delete")
    public String deleteUser(@ModelAttribute("user") User user) {
        if (userService.showUserByUsername(user.getUsername()) == null) {
            return "users/userNotExist";
        }
        userService.deleteUser(user.getUsername());
        return "redirect:/admin/users";
    }

    @PostMapping("admin/users/newAdmin")
    public String addAdmin(@ModelAttribute("user") User user) {
        user = userService.showUserByUsername(user.getUsername());
        if (user == null) {
            return "users/userNotExist";
        }
        roleService.addAdmin(user);
        return "redirect:/admin/users";
    }

    @PatchMapping("admin/users/block")
    public String blockUser(@ModelAttribute("user") User user) {
        user = userService.showUserByUsername(user.getUsername());
        if (user == null) {
            return "users/userNotExist";
        }
        userService.blockUser(user);
        return "redirect:/admin/users";
    }

    @PatchMapping("admin/users/unblock")
    public String unblockUser(@ModelAttribute("user") User user) {
        user = userService.showUserByUsername(user.getUsername());
        if (user == null) {
            return "users/userNotExist";
        }
        userService.unblockUser(user);
        return "redirect:/admin/users";
    }
}
