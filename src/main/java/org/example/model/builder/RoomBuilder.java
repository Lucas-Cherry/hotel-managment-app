package org.example.model.builder;

import org.example.model.Category;
import org.example.model.Hotel;
import org.example.model.Room;

public class RoomBuilder {

    private Room room;

    public RoomBuilder() {
        room = new Room();
    }

    public RoomBuilder setHotelId(int hotelId) {
        this.room.setHotelId(hotelId);
        return this;
    }

    public RoomBuilder setCategoryId(int categoryId) {
        this.room.setCategoryId(categoryId);
        return this;
    }

    public RoomBuilder setRoomNumber(int roomNumber) {
        this.room.setRoomNumber(roomNumber);
        return this;
    }
    public RoomBuilder setFloor(int floor) {
        this.room.setFloor(floor);
        return this;
    }

    public RoomBuilder setPrivateRestroom(boolean privateRestroom) {
        this.room.setPrivateRestroom(privateRestroom);
        return this;
    }

    public RoomBuilder setId(int id) {
        this.room.setId(id);
        return this;
    }

    public Room getRoom() {
        return this.room;
    }
}
