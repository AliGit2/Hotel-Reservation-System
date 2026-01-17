import static org.junit.Assert.*;
import org.junit.Test;

public class How_ManyTest {

    @Test
    public void testHowManyCreation_ShouldSetValidNumber() {
        // Arrange
        int expectedNumber = 5;

        // Act
        How_Many hm = new How_Many(expectedNumber);

        // Assert
        assertEquals("The number should match the expected value", expectedNumber, hm.getNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHowMany_WithZero_ShouldThrowException() {
        // Arrange & Act
        new How_Many(0); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHowMany_WithNegativeNumber_ShouldThrowException() {
        // Arrange & Act
        new How_Many(-1);
    }
}