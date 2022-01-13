package by.martysiuk.sanatoriumApp.repositories;

import by.martysiuk.sanatoriumApp.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {
    @Query("select o from Order o where o.userId = :userId")
    List<Order> findMyOrdersByUserId(int userId);

    @Modifying
    @Transactional
    @Query("delete from Order o where o.id = :id")
    void deleteByID(int id);
}
