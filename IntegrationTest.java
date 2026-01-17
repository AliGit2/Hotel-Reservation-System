import java.util.Date;

public class IntegrationTest {
    public static void main(String[] args) {
        try {
            // --- 1. Arrange: Initialize the objects ---
            
            // Create a hotel instance
            Hotel hotel = new Hotel("Beach Resort");
            
            // Define the type of room and create a specific room
            RoomType suiteType = new RoomType("Suite", 50000.0);
            Room room = new Room(505, suiteType);
            
            // Add the room to the hotel (Aggregation)
            hotel.addRoom(room);

            // Setup the person paying for the reservation
            ReserverPayer payer = ReserverPayer.create("P-100", "5555-4444-3333-2222");
            
            // Define booking dates (Start today, end in 5 days)
            Date startDate = new Date();
            Date endDate = new Date(startDate.getTime() + (5 * 24 * 60 * 60 * 1000));

            // --- 2. Act: Execute the booking process ---
            
            // Create the reservation record
            Reservation res = Reservation.create(startDate, endDate, suiteType, 1);
            
            // Link the specific room to this reservation
            res.addRoom(room); 
            
            // Register the reservation with the hotel and the payer
            hotel.createReservation(res);
            payer.makeReservation(res);

            // --- 3. Assert: Verify the system state ---
            
            // Check if the hotel has rooms and if the payer is linked to the reservation
            boolean isHotelReady = hotel.available();
            boolean isReservationLinked = (payer.getReservation() == res);

            if (isHotelReady && isReservationLinked) {
                System.out.println("SUCCESS: Integration Test Passed. Full booking flow is working.");
                System.out.println("Hotel: " + hotel.getName());
                System.out.println("Room: 505 Type: " + suiteType.getKind());
                System.out.println("Payer ID: " + payer.getId());
            } else {
                System.out.println("FAILURE: Integration Test Failed. Data mismatch detected.");
            }

        } catch (Exception e) {
            System.out.println("ERROR: Test crashed. " + e.getMessage());
            e.printStackTrace();
        }
    }
}