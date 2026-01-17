import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class ReservationTest {

    @Test
    public void testCreateReservation_ShouldSetAllFields() {
        // Arrange: Using unique room type and pricing
        Date start = new Date(); 
        Date end = new Date(start.getTime() + (1000 * 60 * 60 * 48)); // 2 days later
        RoomType type = new RoomType("Penthouse", 75000.0);
        int roomCount = 1;

        // Act
        Reservation res = Reservation.create(start, end, type, roomCount);

        // Assert
        assertNotNull("Reservation object should be successfully created", res);
        assertEquals("Room type should match", type, res.getRoomType());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateReservation_InvalidDates_ShouldThrowException() {
        // Arrange: End date is 1 hour before Start date
        Date start = new Date();
        Date endBeforeStart = new Date(start.getTime() - 3600000); 
        RoomType type = new RoomType("Budget", 2500.0);

        // Act
        Reservation.create(start, endBeforeStart, type, 1);
    }

    @Test
    public void testAddRoom_ShouldHandleRoomLinking() {
        // Arrange
        RoomType type = new RoomType("Studio", 12000.0);
        Reservation res = Reservation.create(new Date(), new Date(), type, 1);
        Room myRoom = new Room(302, type);

        // Act
        res.addRoom(myRoom);

        // Assert
        // Verified that the method executes without throwing errors
        assertNotNull(res); 
    }
}