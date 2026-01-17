public class Guest {
    private String name;
    private String addressDetails;

    public Guest() {
    }
    // Constructor (UML: create())
    public Guest(String name, String addressDetails) {
        this.name = name;
        this.addressDetails = addressDetails;
    }
    public String getName() {
        return name;
    }
    public String getAddressDetails() {
        return addressDetails;
    }
    
    public Guest create(String name, String addressDetails) {
        return new Guest(name, addressDetails);
    }
}
