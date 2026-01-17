import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reservation {
    private Date reservationDate;
    private Date startDate;
    private Date endDate;
    private int numberOfRooms; 
    
    // Relationships as per UML
    private RoomType roomType; 
    private List<Room> rooms;

    // Private constructor for the Factory Method pattern
    private Reservation(Date start, Date end, RoomType type, int num) {
        // Validation: Dates and RoomType
        if (start == null || end == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }
        if (end.before(start)) {
            throw new IllegalArgumentException("Check-out date cannot be before Check-in date");
        }
        if (type == null) {
            throw new IllegalArgumentException("RoomType must be assigned to a reservation");
        }
        if (num <= 0) {
            throw new IllegalArgumentException("Number of rooms must be at least 1");
        }
        
        this.reservationDate = new Date(); // Automatically sets to current time
        this.startDate = start;
        this.endDate = end;
        this.numberOfRooms = num;
        this.roomType = type;
        this.rooms = new ArrayList<>();
    }

    // UML: Static Factory Method create()
    public static Reservation create(Date start, Date end, RoomType type, int num) {
        return new Reservation(start, end, type, num);
    }

    // Linking actual Room objects to this reservation
    public void addRoom(Room room) {
        if (room != null) {
            this.rooms.add(room);
        }
    }

    // Getters for testing and display
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public RoomType getRoomType() { return roomType; }
}