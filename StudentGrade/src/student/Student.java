package student;

public class Student {
    private int [] subjects;
    private int [] grades;

    public int [] getSubjects(){
        if(subjects == null) throw new NullPointerException("subjects is null");
        return subjects;
    }

    public int[] getGrades(){
        if(grades == null)throw new NullPointerException("grades is null");
        return grades;
    }

    public void registerNumberOfSubjects(int numberOfSubjects) {
        if(numberOfSubjects > 0){
            this.subjects = new int [numberOfSubjects];
            this.grades = new int [numberOfSubjects];
        }
    }

    public int getSubject(int subject) {
        if(subjects == null || subject > subjects.length || subject < 0) throw new NullPointerException("subjects is null");
        return subject;
    }

    public void addGrade(int subject, int grade) {
        if(grade > 100) throw new IllegalArgumentException("grade is greater than 100");
        if(grade < 0) throw new IllegalArgumentException("grade is less than 0");
        if(grade < 100) grades[subject - 1] = grade;
    }

    public int checkGrade(int subject) {
        if(subjects == null || subject > subjects.length || subject < 0) throw new NullPointerException("subjects is null");
        if(subject > 0) return grades[subject - 1];
        return 0;
    }

}
