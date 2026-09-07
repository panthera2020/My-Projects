package student;

import java.util.ArrayList;

public class Teacher {
    private ArrayList<Student> gradeBook = new ArrayList<>();


    public ArrayList<Student> checkGradeBook() {
        return gradeBook;
    }

    public void addStudent(Student newStudent) {
        gradeBook.add(newStudent);
    }
}
