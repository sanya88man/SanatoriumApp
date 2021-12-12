package by.martysiuk.sanatoriumApp.services;

import by.martysiuk.sanatoriumApp.models.Room;
import by.martysiuk.sanatoriumApp.repositories.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepo roomRepo;

    @Autowired
    public RoomServiceImpl(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public List<Room> showRooms() {
        return roomRepo.findAll();
    }

    @Override
    public Room showRoom(int id) {
        return roomRepo.getById(id);
    }

    @Override
    public void updateRoom(Room room) {
        roomRepo.save(room);
    }
}
