
public enum Seat {
    AVAILABLE("O"),
    RESERVED("X");

    private final String symbol;

    Seat(String symbol) {
        this.symbol = symbol;
    }

    public String getStatus() {
        return symbol;
    }
}
