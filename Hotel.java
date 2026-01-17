import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Hotel name cannot be empty");
        }
        this.name = name;
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public boolean available() {
        return !rooms.isEmpty();
    }

    public void createReservation(Reservation res) {
        if (res == null) {
            throw new IllegalArgumentException("Reservation cannot be null");
        }
        this.reservations.add(res);
    }

    public void addRoom(Room room) {
        if (room != null) {
            this.rooms.add(room);
        }
    }

    public String getName() {
        return name;
    }

    public List<Room> getRooms() {
        return new ArrayList<>(rooms);
    }
}