public class GuestTest {
    public static void main(String[] args) {
        testGuestCreationSuccess();
        testGuestCreationFailure();
    }

    private static void testGuestCreationSuccess() {
        // Arrange
        String name = "Ali";
        String address = "Ali@example.com";

        // Act
        Guest guest = new Guest(name, address);

        // Assert
        if (guest.getName().equals(name) && guest.getAddressDetails().equals(address)) {
            System.out.println("testGuestCreationSuccess: Passed");
        } else {
            System.out.println("testGuestCreationSuccess: Failed");
        }
    }

    private static void testGuestCreationFailure() {
        // Arrange & Act
        try {
            new Guest("", ""); // Should trigger defensive validation
            System.out.println("testGuestCreationFailure: Failed (No exception thrown)");
        } catch (IllegalArgumentException e) {
            // Assert
            System.out.println("testGuestCreationFailure: Passed (Validation caught empty input)");
        }
    }
}