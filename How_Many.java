public class How_Many {
    private int number;

    public How_Many(int number) {
        // Defensive Programming: Ensuring the count is logical
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        this.number = number;
    }
}