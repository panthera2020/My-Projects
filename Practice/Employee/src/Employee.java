public class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateBonus(){
        return 0.0;
    }

    public String getPaySlip(){
        return name + ": #"  + baseSalary + " Bonus: #"+ calculateBonus() + " Total: #" + (baseSalary + calculateBonus()) ;
    }
}
