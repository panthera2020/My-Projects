package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeacherTest {
    private Teacher teacher;

    @BeforeEach
    public void setUp(){
        teacher = new Teacher();
    }

    @Test
    public void testThatTeacherGradeBookIsEmpty(){
        assertEquals(0,teacher.checkGradeBook().size());
    }

    @Test
    public void testThatTeacherWhenOneStudentIsAdded_GradeBookIsNotEmpty(){
        Student  student1 = new Student();
        teacher.addStudent(student1);
        assertEquals(1,teacher.checkGradeBook().size());
    }

    @Test
    public void testThatTeacherWhenTwoStudentsAreAdded_TwoStudentsAreInGradeBook(){
        Student  student1 = new Student();
        Student  student2 = new Student();
        teacher.addStudent(student1);
        teacher.addStudent(student2);
        assertEquals(2,teacher.checkGradeBook().size());
    }

    @Test
    public void testThatTeacherWhenOneStudentIsAdded_AndSubjectsAndGradesAreAdded_TeacherCanGetTotalGrade(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1,50);
        student1.addGrade(2,75);
        student1.addGrade(3,65);
        teacher.addStudent(student1);
        assertEquals(190.0, teacher.getStudentTotalGrade(student1));
    }

    @Test
    public void testThatWhenOneStudentIsAdded_AndSubjectsAndGradesAreAdded_TeacherCanGetAverageGrade(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1,50);
        student1.addGrade(2,75);
        student1.addGrade(3,65);
        teacher.addStudent(student1);
        assertEquals(63.33,teacher.getStudentAverage(student1));
    }

    @Test
    public void testThatWhenOneStudentIsAdded_AndTeacherGetStudent_StudentIsRegisteredInGradeBook(){
        Student student1 = new Student();
        teacher.addStudent(student1);
        assertEquals(1,teacher.checkGradeBook().size());
    }


    @Test
    public void testThatWhenIAddStudents_AndSubjectsAndGradesAreAdded_WhenICheckStudentsAverageIGetAverageGradeOfEachStudent(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1,50);
        student1.addGrade(2,75);
        student1.addGrade(3,65);
        teacher.addStudent(student1);
        Student  student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1,60);
        student2.addGrade(2,25);
        student2.addGrade(3,55);
        teacher.addStudent(student2);
        double [] expectedAverageGrades = {63.33, 46.66};
        assertArrayEquals(expectedAverageGrades, teacher.getStudentsAverage());
    }

    @Test
    public void tesThatWhenIAddStudents_AndSubjectsAndGradesAreAdded_WhenIGetStudentsAverage_IGetPositionOfEachStudent(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1,50);
        student1.addGrade(2,75);
        student1.addGrade(3,65);
        teacher.addStudent(student1);
        Student  student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1,60);
        student2.addGrade(2,25);
        student2.addGrade(3,55);
        teacher.addStudent(student2);
        double [] expectedAverageGrades = {63.33, 46.66};
        assertArrayEquals(expectedAverageGrades, teacher.getStudentsAverage());
        int [] expectedPositions = {1,2};
        assertArrayEquals(expectedPositions, teacher.getStudentPositions());
    }

    @Test
    public void tesThatWhenIAddStudents_AndSubjectsAndGradesAreAdded_WhenIGetStudentsAverage_IGetPositionOfEachStudentTest2(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1,60);
        student1.addGrade(2,25);
        student1.addGrade(3,55);
        teacher.addStudent(student1);
        Student  student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1,50);
        student2.addGrade(2,75);
        student2.addGrade(3,65);
        teacher.addStudent(student2);
        double [] expectedAverageGrades = {46.66,63.33};
        assertArrayEquals(expectedAverageGrades, teacher.getStudentsAverage());
        int [] expectedPositions = {2,1};
        assertArrayEquals(expectedPositions, teacher.getStudentPositions());
    }

    @Test
    public void testThatWhenIAddOneStudent_AndSubjectsAndGrades_WhenICheckForHighestGrade_IGetHighestGrade(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1,50);
        student1.addGrade(2,75);
        student1.addGrade(3,65);
        teacher.addStudent(student1);
        assertEquals(75,teacher.getStudentHighestScore(student1));
    }

    @Test
    public void testThatWhenIAddOneStudent_AndSubjectsAndGrades_WhenICheckForLowestGrade_IGetLowestGrade(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1,50);
        student1.addGrade(2,75);
        student1.addGrade(3,65);
        teacher.addStudent(student1);
        assertEquals(50,teacher.getStudentLowestScore(student1));
    }

    @Test
    public void testThatWhenIAddOneStudent_AndSubjectsAndGrades_WhenICheckSubjectsPassed_IGetNumberOfSubjectsPassed(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1,50);
        student1.addGrade(2,75);
        student1.addGrade(3,65);
        teacher.addStudent(student1);
        assertEquals(3,teacher.getStudentSubjectsPassed(student1));
    }

    @Test
    public void testThatWhenIAddOneStudent_AndSubjectsAndGrades_WhenICheckStudentsSubjectsFailed_IGetNumberOfSubjectsFailed(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1,20);
        student1.addGrade(2,40);
        student1.addGrade(3,60);
        teacher.addStudent(student1);
        assertEquals(2, teacher.getStudentSubjectsFailed(student1));

    }
}
