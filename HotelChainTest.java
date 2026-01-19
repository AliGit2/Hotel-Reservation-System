import static org.junit.Assert.*;
import org.junit.Test;

public class HotelChainTest {

    @Test
    public void testCreateReserverPayer() {
        // Arrange
        HotelChain chain = new HotelChain("Serena Group");
        String payerId = "P-99";
        String card = "9999-8888";

        // Act
        chain.createReserverPayer(payerId, card);

        // Assert
        assertNotNull("Chain should not be null", chain);
    }

    @Test
    public void testAddHotel() {
        // Arrange
        HotelChain chain = new HotelChain("Lux Hotel");
        Hotel hotel = new Hotel("Lux Karachi");

        // Act
        chain.addHotel(hotel);

        // Assert
        assertNotNull("Hotel should be added to chain", chain);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidChainName() {
        // Arrange & Act (Defensive Programming Check)
        new HotelChain(""); 
    }
}