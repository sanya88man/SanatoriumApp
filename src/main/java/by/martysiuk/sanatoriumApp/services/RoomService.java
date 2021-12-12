package by.martysiuk.sanatoriumApp.services;

import by.martysiuk.sanatoriumApp.models.Room;

import java.util.List;

public interface RoomService {
    List<Room> showRooms();

    Room showRoom(int id);

    void updateRoom(Room room);
}
