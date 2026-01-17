import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. Setup a different Hotel Chain (Titan Hospitality)
            HotelChain myChain = new HotelChain("Titan Hospitality Group");
            Hotel myHotel = new Hotel("The Grand Palace Karachi");
            myChain.addHotel(myHotel);

            // 2. Setup Luxury Suite
            RoomType premium = new RoomType("Executive Suite", 45000.0);
            Room r902 = new Room(902, premium);
            myHotel.addRoom(r902);

            // 3. Create Payer with different ID
            myChain.createReserverPayer("CUST-8821", "9876543210987654");
            ReserverPayer payer = ReserverPayer.create("CUST-8821", "9876543210987654");

            // 4. Setup Dates (Today for 3 days)
            Date checkIn = new Date();
            Date checkOut = new Date(checkIn.getTime() + (3L * 24 * 60 * 60 * 1000));
            
            // 5. Create Reservation for the Executive Suite
            Reservation myRes = Reservation.create(checkIn, checkOut, premium, 1);
            myChain.makeReservation(payer, myRes);

            // 6. Register a different Guest
            r902.createGuest("Zain Mansoor", "DHA Phase 6, Karachi");

            // 7. Output Result
            System.out.println("--- Booking Confirmation ---");
            System.out.println("Hotel: " + myHotel.getName());
            System.out.println("Guest: Zain Mansoor");
            System.out.println("Room: " + r902.getNumber());
            System.out.println("Status: Confirmed and Verified");
            
        } catch (Exception e) {
            System.out.println("System Alert: " + e.getMessage());
        }
    }
}