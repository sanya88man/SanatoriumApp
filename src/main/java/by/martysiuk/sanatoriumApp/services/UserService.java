package by.martysiuk.sanatoriumApp.services;

import by.martysiuk.sanatoriumApp.models.User;

import java.util.List;

public interface UserService {
    User showUserByUsername(String username);

    void saveUser(User user);

    List<User> showUsers();

    void deleteUser(String username);

    void unblockUser(User user);

    void blockUser(User user);

    //void updateUser(User user);
}
