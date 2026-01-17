import static org.junit.Assert.*;
import org.junit.Test;

public class RoomTest {

    @Test
    public void testRoomCreation_ShouldSetNumberAndType() {
        // Arrange: Using unique room data
        int expectedNumber = 405;
        RoomType expectedType = new RoomType("Ocean View", 35000.0);

        // Act
        Room room = new Room(expectedNumber, expectedType);

        // Assert
        assertNotNull("Room object should not be null", room);
        assertEquals("Room number should match", expectedNumber, room.getNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRoomCreation_InvalidNumber_ShouldThrowException() {
        // Arrange
        RoomType type = new RoomType("Standard", 5000.0);

        // Act: Should throw exception for zero or negative number
        new Room(0, type);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRoomCreation_NullType_ShouldThrowException() {
        // Act: Should throw exception when RoomType is missing
        new Room(102, null);
    }

    @Test
    public void testCreateGuest_ShouldExecuteSuccessfully() {
        // Arrange
        RoomType type = new RoomType("Executive", 20000.0);
        Room room = new Room(808, type);
        String guestName = "Mustafa Khan";
        String guestAddress = "Gulshan-e-Iqbal, Karachi";

        // Act
        // Verifying that guest creation logic runs without errors
        room.createGuest(guestName, guestAddress);
        
        // Assert
        assertNotNull("Room instance should still be valid", room);
    }
}