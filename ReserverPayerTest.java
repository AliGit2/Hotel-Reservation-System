import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class ReserverPayerTest {

    @Test
    public void testCreateReserverPayer_ShouldSetCorrectDetails() {
        // Arrange: Using unique customer data
        String expectedId = "USER-77";
        String expectedCard = "9876-0000-1111";

        // Act
        ReserverPayer payer = ReserverPayer.create(expectedId, expectedCard);

        // Assert
        assertNotNull("Payer object should be created", payer);
        assertEquals(expectedId, payer.getId());
        assertEquals(expectedCard, payer.getCreditCardDetails());
    }

    @Test
    public void testMakeReservation_ShouldLinkReservationToPayer() {
        // Arrange
        ReserverPayer payer = ReserverPayer.create("USER-99", "5555-6666");
        RoomType type = new RoomType("Standard", 5000.0);
        
        // Using the static create method from our Reservation class
        Reservation res = Reservation.create(new Date(), new Date(), type, 1);

        // Act
        payer.makeReservation(res);

        // Assert
        assertNotNull("Reservation should be linked", payer.getReservation());
        assertEquals("The linked reservation should match", res, payer.getReservation());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate_WithNullId_ShouldThrowException() {
        // Arrange & Act: Defensive programming check
        ReserverPayer.create(null, "1234-5678");
    }
}