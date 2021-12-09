package by.martysiuk.sanatoriumApp.dao;

import by.martysiuk.sanatoriumApp.models.Role;
import by.martysiuk.sanatoriumApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface UserRepo extends JpaRepository<User, String> {
    User findByUsername(String username);

    @Transactional                                                   //@Query("from User as u where u.username = ?1")
    void deleteByUsername(String username);                          //@Query("delete from User u where u.username = :username")

    /*@Modifying
    @Transactional
    @Query("update User u set u.username = :username, u.enabled = :enabled where u.id = :id")
    void updateUser(String username, boolean enabled, int id);*/
}
