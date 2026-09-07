package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}
