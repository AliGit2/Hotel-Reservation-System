public class RoomType {
    private String kind;  // Example: Deluxe, Suite, etc.
    private double cost;  // Price per night

    public RoomType(String kind, double cost) {
        // Defensive Programming: Validate input parameters
        if (kind == null || kind.isBlank()) {
            throw new IllegalArgumentException("Room kind cannot be null or empty");
        }
        if (cost < 0) {
            throw new IllegalArgumentException("Room cost cannot be negative");
        }
        
        this.kind = kind;
        this.cost = cost;
    }

    // Getters for Room details
    public double getCost() { 
        return cost; 
    }

    public String getKind() { 
        return kind; 
    }
}