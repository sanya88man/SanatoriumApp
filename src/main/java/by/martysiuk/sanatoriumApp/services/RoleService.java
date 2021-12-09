package by.martysiuk.sanatoriumApp.services;

import by.martysiuk.sanatoriumApp.models.User;

public interface RoleService {
    void addAdminRole(User user);

    void addUserRole(User user);
}
