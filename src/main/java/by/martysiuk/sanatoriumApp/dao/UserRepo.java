package by.martysiuk.sanatoriumApp.dao;

import by.martysiuk.sanatoriumApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
    User findByUsername(String username);

    void deleteByUsername(String username);
}
