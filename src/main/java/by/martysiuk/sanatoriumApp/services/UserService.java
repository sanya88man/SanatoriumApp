package by.martysiuk.sanatoriumApp.services;

import by.martysiuk.sanatoriumApp.models.User;

import java.util.List;

public interface UserService {
    User showUserByUsername(String username);

    void saveUser(User user);

    List<User> showUsers();

    void deleteUser(String username);

    void addAdmin(String username);

    void unblockUser(User user);

    void blockUser(String username);
}
