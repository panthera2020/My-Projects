package bike;

public class Bike {
    private boolean isOn;
    private int speed = 0;

    public boolean turnOn() {
        return isOn = true;
    }

    public boolean turnOff() {
        return isOn = false;
    }

    public int getSpeed() {
        return speed;
    }

    public void accelerate() {
        if(isOn) {
            if(speed >= 40) speed += 4;
            else if(speed >= 30) speed += 3;
            else if(speed >= 20) speed += 2;
            else speed++;
        }
    }

    public void brake() {
        if(isOn) {
            if(speed >= 40) speed -= 4;
            else if(speed >= 30) speed -= 3;
            else if(speed > 20) speed -= 2;
            else speed--;
        }
    }
}
