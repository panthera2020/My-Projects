public class Student {
    private String name;
    private int gradeLevel;

    public Student(String name) {
        this.name = name;
        gradeLevel = 1;
    }

    public String getName() {return name;}

    public void updateName(String newName) {this.name = newName;}

    public int getGradeLevel() { return gradeLevel;}

    public void promote() { if (gradeLevel < 12) gradeLevel++;}

    public boolean hasPassed(int score) { return score >= 50;}

    public boolean isGradauting() {return gradeLevel == 12; }
}
