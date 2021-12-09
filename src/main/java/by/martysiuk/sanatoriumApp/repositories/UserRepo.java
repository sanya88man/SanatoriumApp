package by.martysiuk.sanatoriumApp.repositories;

import by.martysiuk.sanatoriumApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepo extends JpaRepository<User, String> {
    User findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);
}
