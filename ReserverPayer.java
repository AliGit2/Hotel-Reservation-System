public class ReserverPayer {
    // UML Attributes
    private String id;
    private String creditCardDetails;
    
    // Relationship: ReserverPayer is linked to one Reservation
    private Reservation reservation;

    // Private constructor for internal use
    private ReserverPayer(String id, String creditCardDetails) {
        this.id = id;
        this.creditCardDetails = creditCardDetails;
    }

    // UML Operation: Static factory method to create a Payer
    public static ReserverPayer create(String id, String creditCardDetails) {
        if (id == null || id.isBlank() || creditCardDetails == null) {
            throw new IllegalArgumentException("Valid ID and Card details are required");
        }
        return new ReserverPayer(id, creditCardDetails);
    }

    // Linking the payer to a specific reservation
    public void makeReservation(Reservation res) {
        if (res == null) {
            throw new IllegalArgumentException("Cannot link a null reservation to this payer");
        }
        this.reservation = res;
        // Simple console log for tracking
        System.out.println("Reservation successfully linked to Payer ID: " + id);
    }

    // Getters for attributes and relationships
    public String getId() {
        return id;
    }

    public String getCreditCardDetails() {
        return creditCardDetails;
    }

    public Reservation getReservation() {
        return reservation;
    }
}