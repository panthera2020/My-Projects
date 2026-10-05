import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AirlineTest {
    private  Airline airline;

    @BeforeEach
    public void setUp() {
        airline = new Airline();
    }

    @Test
    public void testThatAirlineSeatsAreAvailable() {
        String empty = "O";
        String[] seatsForLagosToAbuja = airline.checkLagosToAbujaSeats();
        String [] seatsForLagosToEnugu = airline.checkLagosToEnuguSeats();
        String [] seatsForLagosToPortHarcourt = airline.checkLagosPortHarcourtSeats();
        for (String seat : seatsForLagosToAbuja) {assertEquals(empty, seat);}
        for (String seat : seatsForLagosToEnugu) { assertEquals(empty, seat); }
        for (String seat : seatsForLagosToPortHarcourt) { assertEquals(empty, seat); }
    }

    @Test
    public void testThatAirlineCanBookSeatFromLagosToAbuja() {
        airline.bookLagosToAbuja(1, 1);
        String[] seats = airline.checkLagosToAbujaSeats();
        assertEquals("X", seats[0]);
    }

    @Test
    public void testThatWhenIBookSeatFromLagosToAbujaCannotBeBookedAgain_ErrorIsThrown() {
        airline.bookLagosToAbuja(1, 1);
        String[] seats = airline.checkLagosToAbujaSeats();
        assertEquals("X", seats[0]);
        assertThrows(IllegalArgumentException.class, () -> airline.bookLagosToAbuja(1, 1));
    }

    @Test
    public void testThatWhenIBookIncorrectSeatNumberForLagosToAbujaErrorIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> airline.bookLagosToAbuja(1, 7));
    }

    @Test
    public void testThatWhenIBookIncorrectRowNumberForLagosToAbujaErrorIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> airline.bookLagosToAbuja(5, 3));
    }

    @Test
    public void testThatAirlineCanBookSeatFromLagosToPortHarcourt() {
        airline.bookLagosPortHarcourt(1, 1);
        String[] seats = airline.checkLagosPortHarcourtSeats();
        assertEquals("X", seats[0]);
    }

    @Test
    public void testThatWhenIBookSeatFromLagosToPortHarcourtCannotBeBookedAgain_ErrorIsThrown() {
        airline.bookLagosPortHarcourt(1, 1);
        assertThrows(IllegalArgumentException.class, () -> airline.bookLagosPortHarcourt(1, 1));
    }

    @Test
    public void testThatWhenIBookIncorrectSeatNumberForLagosPortHarcourtErrorIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> airline.bookLagosPortHarcourt(1, 7));
    }

    @Test
    public void testThatWhenIBookIncorrectRowNumberForLagosPortHarcourtErrorIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> airline.bookLagosPortHarcourt(6, 3));
    }

    @Test
    public void testThatAirlineCanBookSeatFromLagosToEnugu() {
        airline.bookLagosToEnugu(2, 3);
        String[] seats = airline.checkLagosToEnuguSeats();
        assertEquals("X", seats[airline.getIndexOf(2, 3)]);
    }

    @Test
    public void testThatWhenIBookSeatFromLagosToEnuguCannotBeBookedAgain_ErrorIsThrown() {
        airline.bookLagosToEnugu(2, 3);
        assertThrows(IllegalArgumentException.class, () -> airline.bookLagosToEnugu(2, 3));
    }

    @Test
    public void testThatWhenIBookIncorrectSeatNumberForLagosToEnuguErrorIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> airline.bookLagosToEnugu(1, 5));
    }

    @Test
    public void testThatWhenIBookIncorrectRowNumberForLagosToEnuguErrorIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> airline.bookLagosToEnugu(7, 3));
    }

    @Test
    public void testThatMultipleSeatsCanBeBookedOnDifferentFlights() {
        airline.bookLagosToAbuja(1, 1);
        airline.bookLagosPortHarcourt(2, 2);
        airline.bookLagosToEnugu(3, 3);

        assertEquals("X", airline.checkLagosToAbujaSeats()[0]);
        assertEquals("X", airline.checkLagosPortHarcourtSeats()[airline.getIndexOf(2, 2)]);
        assertEquals("X", airline.checkLagosToEnuguSeats()[airline.getIndexOf(3, 3)]);
    }
}
