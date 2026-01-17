import java.util.ArrayList;
import java.util.List;

public class HotelChain {
    private String name;
    private List<Hotel> hotels;
    private List<ReserverPayer> payers;

    public HotelChain(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Invalid chain name");
        this.name = name;
        this.hotels = new ArrayList<>();
        this.payers = new ArrayList<>();
    }

    public void createReserverPayer(String id, String card) {
        if (id == null || card == null) throw new IllegalArgumentException("Invalid payer details");
        ReserverPayer newPayer = ReserverPayer.create(id, card);
        this.payers.add(newPayer);
    }

    public void addPayer(ReserverPayer payer) {
        if (payer != null) {
            this.payers.add(payer);
        }
    }

    public void makeReservation(ReserverPayer payer, Reservation res) {
        if (payer != null && res != null && payers.contains(payer)) {
            payer.makeReservation(res);
        }
    }

    public void addHotel(Hotel hotel) {
        if (hotel != null) {
            this.hotels.add(hotel);
        }
    }

    public void cancelReservation() { 
        System.out.println("Reservation cancelled.");
    }
    
    public void checkInGuest() {
        System.out.println("Guest checked in.");
    }
    
    public void checkOutGuest() { 
        System.out.println("Guest checked out.");
    }

    public String getName() {
        return name;
    }
}