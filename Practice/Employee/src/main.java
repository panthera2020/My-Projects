public class main {
    public static void main(String[] args) {
        Developer developer = new Developer("Chidi", 300_000,5);
        Manager manager = new Manager("Amaka", 450_000,2);

        IO.println(developer.getPaySlip());
        IO.println(manager.getPaySlip());
    }
}
