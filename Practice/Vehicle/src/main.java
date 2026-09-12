public class main {
    public static void main(String[] args) {
        Car newCar = new Car("Toyota",180, 4);
        Motorcycle newMotorcycle = new Motorcycle("Harley-Davidson", 160, true);

        IO.println(newCar.describe());
        IO.println(newMotorcycle.describe());
    }
}
