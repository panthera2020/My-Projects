public class Airline {
    private String [] SC101 = new String[16];
    private String [] SC102 = new String[20];
    private String [] SC103 = new String[24];

    public Airline() {
        intializeSeats(SC101);
        intializeSeats(SC102);
        intializeSeats(SC103);
    }

    private void intializeSeats(String[] flight){for(int index = 0; index < flight.length; index++){ flight[index] = Seat.AVAILABLE.getStatus();}}

    public String[] checkLagosToAbujaSeats() { return SC101; }

    public String[] checkLagosPortHarcourtSeats() { return SC102;}

    public String [] checkLagosToEnuguSeats() { return SC103;}

    public void bookLagosToAbuja(int row, int seat) {
        validateSeat(seat);
        validateRow(SC101, row);
        validateBooking(SC101, row, seat);
        SC101[getIndexOf(row, seat)] = Seat.RESERVED.getStatus();
    }

    public void bookLagosPortHarcourt(int row, int seat) {
        validateSeat(seat);
        validateRow(SC102, row);
        validateBooking(SC102, row, seat);
        SC102[getIndexOf(row, seat)] = Seat.RESERVED.getStatus();
    }

    public void bookLagosToEnugu(int row, int seat) {
        validateSeat(seat);
        validateRow(SC103, row);
        validateBooking(SC103, row, seat);
        SC103[getIndexOf(row, seat)] = Seat.RESERVED.getStatus();
    }

    private void validateBooking(String [] flight, int row, int seat) {if(flight[getIndexOf(row, seat)].equals(Seat.RESERVED.getStatus())) throw new IllegalArgumentException("Seat is already reserved");}

    private void validateSeat(int seat) { if(seat < 1 || seat > 4) throw new IllegalArgumentException("Seat must be between 1 and 4");}

    private void validateRow(String [] flight, int row) { if(row < 1 || row > flight.length / 4) throw new IllegalArgumentException("Row must be between 1 and "+ flight.length / 4); }

    public int getIndexOf(int row, int seat) { return (row - 1) * 4 + (seat - 1); }
}