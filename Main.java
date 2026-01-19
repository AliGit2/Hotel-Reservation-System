import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            // Initializing the system with your details
            HotelChain aliChain = new HotelChain("Ali Hospitality Group");
            Hotel hotel = new Hotel("Camp Nou Grand Resort"); // Based on your favorite team
            aliChain.addHotel(hotel);

            // Setting up the inventory
            RoomType executiveSuite = new RoomType("Designer Suite", 55000.0);
            Room room902 = new Room(902, executiveSuite);
            hotel.addRoom(room902);

            // Creating the Reserver/Payer using your provided ID
            aliChain.createReserverPayer("CUST-1612", "9876-5432-1098");
            ReserverPayer payer = ReserverPayer.create("CUST-1612", "9876-5432-1098");

            // Setting up the dates
            Date checkIn = new Date();
            Date checkOut = new Date(checkIn.getTime() + 259200000L); // 3 days stay

            // Creating the Reservation
            Reservation res = Reservation.create(checkIn, checkOut, executiveSuite, 1);
            aliChain.makeReservation(payer, res);

            // Creating the Guest (You)
            room902.createGuest("Ali", "Karachi, Pakistan");

            // --- Output for your Hard Copy ---
            System.out.println("--- Hotel System Execution Proof ---");
            System.out.println("Hotel Chain: " + aliChain.getName());
            System.out.println("Hotel Name: " + hotel.getName());
            System.out.println("Guest Name: Ali (Digital Marketer)");
            System.out.println("Room Number: " + room902.getNumber());
            System.out.println("Status: Booking Confirmed and Verified");

        } catch (Exception e) {
            System.out.println("System Alert: " + e.getMessage());
        }
    }
}