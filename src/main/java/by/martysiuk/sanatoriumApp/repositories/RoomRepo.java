package by.martysiuk.sanatoriumApp.repositories;

import by.martysiuk.sanatoriumApp.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room, Integer> {
}
