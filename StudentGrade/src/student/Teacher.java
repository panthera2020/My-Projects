package student;

import java.util.ArrayList;

public class Teacher {
    private ArrayList<Student> gradeBook = new ArrayList<>();

    public ArrayList<Student> checkGradeBook() {return gradeBook;}

    public void addStudent(Student newStudent) {gradeBook.add(newStudent);}

    public double getStudentTotalGrade(Student student) {
        double sum = 0;
        for(int studentGrade : student.getGrades()) sum += studentGrade;
        return sum;
    }

    public Student getStudent(int studentID) {return gradeBook.get(studentID - 1);}

    public double getStudentAverage(Student student1) {return Math.floor((getStudentTotalGrade(student1)/student1.getGrades().length) * 100) / 100;}

    public double [] getStudentsAverage() {
        double [] studentAverage = new double[gradeBook.size()];
        for(int eachStudent = 1; eachStudent <= gradeBook.size(); eachStudent++){studentAverage[eachStudent - 1] = getStudentAverage(getStudent(eachStudent));}
        return  studentAverage;
    }


    public int [] getStudentPositions() {
        double [] averageGrades = getStudentsAverage();
        int [] studentPositions = new int[gradeBook.size()];
        for(int eachStudent = 0; eachStudent < studentPositions.length; eachStudent++){studentPositions[eachStudent] = eachStudent;-+}

        for(int index = 0; index < gradeBook.size(); index++){
            for(int count = 1; count < gradeBook.size(); count++){
                if(averageGrades[index] < averageGrades[count]){
                    int store = studentPositions[index];
                    studentPositions[index] = studentPositions[count];
                    studentPositions[count] = store;
                }
            }
        }

        for(int index = 0; index < studentPositions.length; index++){++studentPositions[index];}

        return studentPositions;
    }

    public int getStudentHighestScore(Student student1) {
        int highestScore = 0;
        for(int studentGrade : student1.getGrades()){if(studentGrade > highestScore){highestScore = studentGrade;}}
        return highestScore;
    }

    public int getStudentLowestScore(Student student1) {
        int lowestScore = student1.getGrades()[0];
        for(int studentGrade : student1.getGrades()){if(studentGrade < lowestScore){lowestScore = studentGrade;}}
        return lowestScore;
    }

    public int getStudentSubjectsPassed(Student student1) {
        int subjectsPassed = 0;
        for(int studentGrade : student1.getGrades()){if(studentGrade >= 50){subjectsPassed++;}}
        return subjectsPassed;
    }

    public int getStudentSubjectsFailed(Student student1) {
        int subjectsFailed = 0;
        for(int studentGrade : student1.getGrades()){if(studentGrade < 50){subjectsFailed++;}}
        return subjectsFailed;
    }
}
