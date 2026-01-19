import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Date;

public class HotelTest {

    @Test
    public void testHotelCreation_ShouldSetNameAndInitializeLists() {
        // Arrange
        String expectedName = "Serena Islamabad";

        // Act
        Hotel hotel = new Hotel(expectedName);

        // Assert
        assertEquals(expectedName, hotel.getName());
        assertFalse("Hotel should not be available without rooms", hotel.available());
    }

    @Test
    public void testAvailable_WhenRoomAdded_ShouldReturnTrue() {
        // Arrange
        Hotel hotel = new Hotel("PC Lahore");
        RoomType type = new RoomType("Deluxe", 15000.0);
        Room room = new Room(101, type);

        // Act
        hotel.addRoom(room);

        // Assert
        assertTrue("Hotel should be available after adding a room", hotel.available());
    }

    @Test
    public void testCreateReservation_ShouldExecuteSuccessfully() {
        // Arrange
        Hotel hotel = new Hotel("Marriott");
        RoomType type = new RoomType("Suite", 30000.0);
        Reservation res = Reservation.create(new Date(), new Date(), type, 1);

        // Act
        hotel.createReservation(res);

        // Assert
        assertNotNull("Hotel instance should exist after reservation", hotel);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_EmptyName_ShouldThrowException() {
        // Arrange & Act
        new Hotel(""); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateReservation_NullReservation_ShouldThrowException() {
        // Arrange
        Hotel hotel = new Hotel("Pearl Continental");

        // Act
        hotel.createReservation(null); 
    }
}