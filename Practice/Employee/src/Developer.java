public class Developer extends Employee {
    private int projectsCompleted;

    public Developer(String name, double baseSalary, int projectsCompleted) {
        super(name, baseSalary);
        this.projectsCompleted = projectsCompleted;
    }

    @Override
    public double calculateBonus(){
        return projectsCompleted * 5000;
    }
}
