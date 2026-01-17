public class Room {
    private int number;
    private RoomType type; // Relationship: Each Room must have a RoomType

    public Room(int number, RoomType type) {
        // Defensive Programming: Ensuring valid room data
        if (number <= 0) {
            throw new IllegalArgumentException("Room number must be positive");
        }
        if (type == null) {
            throw new IllegalArgumentException("RoomType cannot be null");
        }
        this.number = number;
        this.type = type;
    }

    // UML Operation: createGuest()
    // This creates and links a guest to the current room
    public void createGuest(String name, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Guest name is required");
        }
        // In a full system, you might store the Guest object here
        System.out.println("Guest " + name + " assigned to Room " + number);
    }

    // Getter for the room number (Used in Main and Tests)
    public int getNumber() {
        return number;
    }

    // Getter for the RoomType
    public RoomType getType() {
        return type;
    }
}