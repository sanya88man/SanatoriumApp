package by.martysiuk.sanatoriumApp.repositories;

import by.martysiuk.sanatoriumApp.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
