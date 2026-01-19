import java.util.Date;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        try {
            // 1. Initialize the Chain and Hotel
            HotelChain aliChain = new HotelChain("Ali Hospitality Group");
            Hotel hotel = new Hotel("Camp Nou Grand Resort"); 
            aliChain.addHotel(hotel);

            // 2. Setup Room Inventory
            RoomType suiteType = new RoomType("Graphic Designer Suite", 50000.0);
            Room room902 = new Room(902, suiteType);
            hotel.addRoom(room902);

            // 3. Adding 3 Users to the System
            // User 1: Me (Primary Admin/Guest)
            String id1 = "ALI-161205"; // My Birthday
            aliChain.createReserverPayer(id1, "1111-2222-3333-4444");
            ReserverPayer userAli = ReserverPayer.create(id1, "1111-2222-3333-4444");

            // User 2: Standard Guest
            String id2 = "GUEST-786";
            aliChain.createReserverPayer(id2, "5555-6666-7777-8888");

            // User 3: VIP Guest
            String id3 = "VIP-999";
            aliChain.createReserverPayer(id3, "9999-0000-1111-2222");

            // 4. Create a Reservation for the primary user (Ali)
            Date checkIn = new Date();
            Date checkOut = new Date(checkIn.getTime() + 259200000L); // 3-day stay
            Reservation res = Reservation.create(checkIn, checkOut, suiteType, 1);
            aliChain.makeReservation(userAli, res);

            // 5. Register the Guest in the Room
            room902.createGuest("Ali", "Karachi, Pakistan");

            // --- Output for BS(SE) Hard Copy ---
            System.out.println("==========================================");
            System.out.println("   ALI HOSPITALITY SYSTEM - EXECUTION     ");
            System.out.println("==========================================");
            System.out.println("Hotel: " + hotel.getName());
            System.out.println("Primary Guest: Ali");
            System.out.println("Room Number: " + room902.getNumber());
            System.out.println("------------------------------------------");
            System.out.println("SYSTEM STATUS: 3 Users Successfully Loaded");
            System.out.println("Confirmed IDs: " + id1 + ", " + id2 + ", " + id3);
            System.out.println("Booking Status: Confirmed and Verified");
            System.out.println("==========================================");

        } catch (Exception e) {
            System.out.println("System Alert: " + e.getMessage());
        }
    }
}