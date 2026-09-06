package bike;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {
    private Bike bike;

    @BeforeEach
    public void setUp() {
        bike = new Bike();
    }

    @Test
    public void testThatWhenIHaveABike_AndITurnBikeOn_BikeIsOn(){
        assertTrue(bike.turnOn());
    }

    @Test
    public void testThatWhenIHaveABike_AndITurnOnTurnOff_BikeIsOff(){
        assertTrue(bike.turnOn());
        assertFalse(bike.turnOff());
    }

    @Test
    public void testThatWhenIHaveBike_AndBikeIsOn_AndICheckSpeed_SpeedIsZero(){
        assertTrue(bike.turnOn());
        assertEquals(0,bike.getSpeed());
    }

    @Test
    public void testThatWhenBikeIsOn_AndIAccelerateSpeedIncreaseByOne(){
        assertTrue(bike.turnOn());
        assertEquals(0,bike.getSpeed());
        bike.accelerate();
        assertEquals(1,bike.getSpeed());
    }

    @Test
    public void testThatWhenBikeIsOn_AndIAccelerateOnce_AndDecelerateSpeedDecreaseByOne(){
        assertTrue(bike.turnOn());
        assertEquals(0,bike.getSpeed());
        bike.accelerate();
        assertEquals(1,bike.getSpeed());
        bike.brake();
        assertEquals(0,bike.getSpeed());
    }

    @Test
    public void testThatWhenBikeIsOff_AndIAccelerate_SpeedIsZero(){
        assertFalse(bike.turnOff());
        assertEquals(0,bike.getSpeed());
        bike.accelerate();
        assertEquals(0,bike.getSpeed());
    }

    @Test
    public void testThatWhenBikeIsOn_AndIAccelerate_WhenSpeedGetsTo20_SpeedIncreaseByTwo(){
        assertTrue(bike.turnOn());
        assertEquals(0, bike.getSpeed());
        for(int increaseSpeed = 1; increaseSpeed <= 20; increaseSpeed++){
            bike.accelerate();
        }
        assertEquals(20, bike.getSpeed());
        bike.accelerate();
        assertEquals(22,bike.getSpeed());
    }

    @Test
    public void testThatWhenBikeIsOn_AndIAccelerate_WhenSpeedGetsTo30_SpeedIncreaseByThree(){
        assertTrue(bike.turnOn());
        assertEquals(0, bike.getSpeed());
        for(int increaseSpeed = 1; increaseSpeed <= 20; increaseSpeed++){
            bike.accelerate();
        }
        assertEquals(20, bike.getSpeed());
        for(int increaseSpeed = 1; increaseSpeed <= 5; increaseSpeed++){
            bike.accelerate();
        }
        assertEquals(30, bike.getSpeed());
        bike.accelerate();
        assertEquals(33,bike.getSpeed());
    }

    @Test
    public void testThatWhenBikeIsOn_AndIAccelerate_WhenSpeedGetsTo40_SpeedIncreaseByFour(){
        assertTrue(bike.turnOn());
        assertEquals(0, bike.getSpeed());
        for(int increaseSpeed = 1; increaseSpeed <= 20; increaseSpeed++){
            bike.accelerate();
        }
        assertEquals(20, bike.getSpeed());
        for(int increaseSpeed = 1; increaseSpeed <= 5; increaseSpeed++){
            bike.accelerate();
        }
        assertEquals(30, bike.getSpeed());
        for(int increaseSpeed = 1; increaseSpeed <= 4; increaseSpeed++){
            bike.accelerate();
        }
        assertEquals(42, bike.getSpeed());
        bike.accelerate();
        assertEquals(46,bike.getSpeed());
    }
    @Test
    public void testThatWhenBikeIsOff_AndIPressBrakes_SpeedIsZero(){
        assertFalse(bike.turnOff());
        bike.brake();
        assertEquals(0,bike.getSpeed());
    }

    @Test
    public void testThatWhenBikeIsOn_AndIAccelerate_WhenSpeedIsBelow20_AndIPressBrakes_SpeedDecreaseByOne(){
        assertTrue(bike.turnOn());
        assertEquals(0,bike.getSpeed());
        for(int increaseSpeed = 1; increaseSpeed <= 20; increaseSpeed++){
            bike.accelerate();
        }
        bike.brake();
        assertEquals(19,bike.getSpeed());
    }

    @Test
    public void testThatWhenBikeIsOne_AndIAccelerate_WhenSpeedIsAbove20_AndIPressBrakes_SpeedDecreaseByTwo(){
        assertTrue(bike.turnOn());
        assertEquals(0,bike.getSpeed());
        for(int increaseSpeed = 1; increaseSpeed <= 22; increaseSpeed++){
            bike.accelerate();
        }
        assertEquals(24, bike.getSpeed());
        bike.brake();
        assertEquals(22,bike.getSpeed());
    }

    @Test
    public void testThatWhenBikeIsOn_AndIAccelerate_WhenSpeedIsAbove30_AndIPressBrakes_SpeedDecreaseByThree(){
        assertTrue(bike.turnOn());
        assertEquals(0,bike.getSpeed());
        for(int increaseSpeed = 1; increaseSpeed <= 26; increaseSpeed++){
            bike.accelerate();
        }
        assertEquals(33,bike.getSpeed());
        bike.brake();
        assertEquals(30,bike.getSpeed());
    }

    @Test
    public void testThatWhenBikeIsOn_AndIAccelerate_WhenSpeedIsAbove40_AndIPressBrakes_SpeedDecreaseByFour(){
        assertTrue(bike.turnOn());
        assertEquals(0,bike.getSpeed());
        for(int increaseSpeed = 1; increaseSpeed <= 30; increaseSpeed++){
            bike.accelerate();
        }
        assertEquals(46,bike.getSpeed());
        bike.brake();
        assertEquals(42,bike.getSpeed());
    }
}
