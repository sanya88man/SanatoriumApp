package by.martysiuk.sanatoriumApp.dao;

import by.martysiuk.sanatoriumApp.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByRole(String role);

    /*@Modifying
    @Transactional
    @Query("update Role r set r.role = :role where r.id = :id")
    void updateRole(String role, int id);*/
}
