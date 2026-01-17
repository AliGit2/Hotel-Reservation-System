import static org.junit.Assert.*;
import org.junit.Test;

public class RoomTypeTest {

    @Test
    public void testRoomTypeCreation_ShouldSetCorrectValues() {
        // Arrange: Using unique room category and price
        String expectedKind = "Presidential Suite";
        double expectedCost = 120000.0;

        // Act
        RoomType room = new RoomType(expectedKind, expectedCost);

        // Assert
        assertEquals("Room kind should match the input", expectedKind, room.getKind());
        // Delta 0.001 is used for comparing double values accurately
        assertEquals("Room cost should match the input", expectedCost, room.getCost(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRoomTypeCreation_NegativeCost_ShouldThrowException() {
        // Arrange
        String kind = "Economy";
        double negativeCost = -50.0;

        // Act & Assert
        // Exception is expected due to negative price validation
        new RoomType(kind, negativeCost);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRoomTypeCreation_EmptyKind_ShouldThrowException() {
        // Act & Assert: Testing empty string validation
        new RoomType("", 5000.0);
    }
}