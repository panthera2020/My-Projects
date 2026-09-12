public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, int topSpeed ,int numberOfDoors) {
        super(brand, topSpeed);
        this.numberOfDoors = numberOfDoors;
    }

    public String getBrand() {
        return super.getBrand();
    }

    public int getTopSpeed() {
        return super.getTopSpeed();
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public String describe(){
        return "This is a " + getBrand() + " with a Top Speed Of " + getTopSpeed() + " km/h and has " + numberOfDoors + " doors";
    }
}
