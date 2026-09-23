import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student student;

    @BeforeEach
    public void setUp() {
        student = new Student("Bola");
    }
    @Test
    public void testThatStudentHasName() {
        assertEquals("Bola", student.getName());
    }

    @Test
    public void testThatWhenStudentUpdateName_NameIsUpdated() {
        assertEquals("Bola", student.getName());
        student.updateName("Ola");
        assertEquals("Ola", student.getName());
    }

    @Test
    public void testThatWhenStudentIsCreatedGradeLevelIsOne(){
        assertEquals(1,student.getGradeLevel());
    }

    @Test
    public void testThatWhenIPromoteStudentOnceGradeLevelIsTwo(){
        student.promote();
        assertEquals(2,student.getGradeLevel());
    }

    @Test
    public void testThatWhenIPromoteStudentTwiceGradeLevelIsThree(){
        student.promote();
        student.promote();
        assertEquals(3,student.getGradeLevel());
    }

    @Test
    public void testThatStudentCannotBePromotedMoreThanGrade12(){
        for(int promote = 0; promote < 20; promote++){
            student.promote();
        }
        assertEquals(12,student.getGradeLevel());
    }

    @Test
    public void testThatWhenStudentScores50AndAbove_ReturnsTrueThatStudentPassed(){
        assertTrue(student.hasPassed(55));
    }

    @Test
    public void testThatWhenStudentScoresBelow50_ReturnsFalseThatStudentPassed(){
        assertFalse(student.hasPassed(45));
    }

    @Test
    public void testThatWhenStudentReachesGradeLevel12_ReturnsTrueThatStudentIsGraduating(){
        for(int promote = 0; promote < 12; promote++){
            student.promote();
        }
        assertTrue(student.isGradauting());
    }

    @Test
    public void testThatWhenStudentGradeLevelIsNot12_ReturnsFalseThatStudentIsGraduating(){
        assertFalse(student.isGradauting());
    }
}
