package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student studentOne;

    @BeforeEach
    public void newStudent(){
        studentOne = new Student();
    }

    @Test
    public void testThatWhenIHaveAStudent_SubjectRegisteredIsEmpty(){
        assertThrows(NullPointerException.class,()-> studentOne.getSubjects());
    }

    @Test
    public void testThatWhenIHaveAStudent_SubjectRegisteredIsNotEmpty_GradeIsEmpty(){
        assertThrows(NullPointerException.class,()-> studentOne.getGrades());
    }

    @Test
    public void testThatWhenIHaveAStudent_AndIRegisterNumberOfSubject_IHaveAnArrayOfSubjectSizeCreated(){
        studentOne.registerNumberOfSubjects(3);
        assertEquals(3,studentOne.getSubjects().length);
    }

    @Test
    public void testThatWhenIHaveAStudent_AndIRegisterNumberOfSubject_IHaveAnArrayOfGradeCreated_WithSameSizeAsSubject(){
        studentOne.registerNumberOfSubjects(3);
        assertEquals(3,studentOne.getGrades().length);
    }

    @Test
    public void testThatWhenIHaveAStudent_AndIRegisterANegativeNumberOfSubject_NoChanges(){
        studentOne.registerNumberOfSubjects(-2);
        assertThrows(NullPointerException.class,()-> studentOne.getSubjects());
    }

   @Test
    public void testThatWhenIHaveAStudent_WithOneRegisteredSubjects_SubjectIsOne(){
        studentOne.registerNumberOfSubjects(1);
        assertEquals(1,studentOne.getSubject(1));
    }

    @Test
    public void testThatWhenIHaveAStudent_WithTwoRegisteredSubjects_FirstSubjectIsOneSecondSubjectIsTwo(){
        studentOne.registerNumberOfSubjects(2);
        assertEquals(1,studentOne.getSubject(1));
        assertEquals(2,studentOne.getSubject(2));
    }

    @Test
    public void testWhenIHaveStudent_WithoutRegisteredSubjects_AndIGetSubject_ThrowError(){
        assertThrows(NullPointerException.class,()->studentOne.getSubject(1));
    }

    @Test
    public void testThatWhenIHaveStudent_WithTwoRegisteredSubjects_AndIGetMoreThanTwoSubject_ThrowError(){
        studentOne.registerNumberOfSubjects(2);
        assertThrows(NullPointerException.class,()->studentOne.getSubject(3));
    }

    @Test
    public void testThatWhenIHaveStudent_WithThreeRegisteredSubjects_AndIGetNegativeSubject_ThrowError(){
        studentOne.registerNumberOfSubjects(3);
        assertThrows(NullPointerException.class,()->studentOne.getSubject(-3));
    }

    @Test
    public void testThatWhenIHaveStudent_WithOneRegisteredSubject_WhenIAddGrade_GradeIsAdded(){
        studentOne.registerNumberOfSubjects(1);
        studentOne.addGrade(1,50);
        assertEquals(50,studentOne.checkGrade(1));
    }

    @Test
    public void testThatWhenIHaveStudent_WithoutRegisteredSubject_WhenICheckGrade_ThrowError(){
        assertThrows(NullPointerException.class, ()-> studentOne.checkGrade(2));
    }

    @Test
    public void testThatWhenIHaveStudent_WithOneRegisteredSubject_AndNoGradeIsAdded_ReturnZero(){
        studentOne.registerNumberOfSubjects(1);
        assertEquals(0,studentOne.checkGrade(1));
    }

    @Test
    public void testThatWhenIHaveStudent_WithOneRegisteredSubject_AndGradeAdded_ReturnGradeAdded(){
        studentOne.registerNumberOfSubjects(1);
        studentOne.addGrade(1,50);
        assertEquals(50,studentOne.checkGrade(1));
    }

    @Test
    public void testThatWhenIHaveStudent_WithOneRegisteredSubject_WhenIAddGradeAbove100_ThrowErrorAndNothingIsAdded(){
        studentOne.registerNumberOfSubjects(1);
        assertThrows(IllegalArgumentException.class,()->studentOne.addGrade(1,200));
        assertEquals(0,studentOne.checkGrade(1));
    }

    @Test
    public void testThatWhenIHaveStudent_WithOneRegisteredSubject_WhenIAddGradeBelowZero_ThrowErrorAndNothingIsAdded(){
        studentOne.registerNumberOfSubjects(1);
        assertThrows(IllegalArgumentException.class,()->studentOne.addGrade(1,-19));
        assertEquals(0,studentOne.checkGrade(1));
    }
}
