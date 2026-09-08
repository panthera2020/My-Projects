package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeacherTest {
    private Teacher teacher;

    @BeforeEach
    public void setUp() {
        teacher = new Teacher();
    }

    @Test
    public void testThatTeacherGradeBookIsEmpty() {
        assertEquals(0, teacher.checkGradeBook().size());
    }

    @Test
    public void testThatTeacherWhenOneStudentIsAdded_GradeBookIsNotEmpty() {
        Student student1 = new Student();
        teacher.addStudent(student1);
        assertEquals(1, teacher.checkGradeBook().size());
    }

    @Test
    public void testThatTeacherWhenTwoStudentsAreAdded_TwoStudentsAreInGradeBook() {
        Student student1 = new Student();
        Student student2 = new Student();
        teacher.addStudent(student1);
        teacher.addStudent(student2);
        assertEquals(2, teacher.checkGradeBook().size());
    }

    @Test
    public void testThatTeacherWhenOneStudentIsAdded_AndSubjectsAndGradesAreAdded_TeacherCanGetTotalGrade() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 50);
        student1.addGrade(2, 75);
        student1.addGrade(3, 65);
        teacher.addStudent(student1);
        assertEquals(190.0, teacher.getStudentTotalGrade(student1));
    }

    @Test
    public void testThatWhenOneStudentIsAdded_AndSubjectsAndGradesAreAdded_TeacherCanGetAverageGrade() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 50);
        student1.addGrade(2, 75);
        student1.addGrade(3, 65);
        teacher.addStudent(student1);
        assertEquals(63.33, teacher.getStudentAverage(student1));
    }

    @Test
    public void testThatWhenOneStudentIsAdded_AndTeacherGetStudent_StudentIsRegisteredInGradeBook() {
        Student student1 = new Student();
        teacher.addStudent(student1);
        assertEquals(1, teacher.checkGradeBook().size());
    }


    @Test
    public void testThatWhenIAddStudents_AndSubjectsAndGradesAreAdded_WhenICheckStudentsAverageIGetAverageGradeOfEachStudent() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 50);
        student1.addGrade(2, 75);
        student1.addGrade(3, 65);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 60);
        student2.addGrade(2, 25);
        student2.addGrade(3, 55);
        teacher.addStudent(student2);
        double[] expectedAverageGrades = {63.33, 46.66};
        assertArrayEquals(expectedAverageGrades, teacher.getStudentsAverage());
    }

    @Test
    public void tesThatWhenIAddStudents_AndSubjectsAndGradesAreAdded_WhenIGetStudentsAverage_IGetPositionOfEachStudent() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 50);
        student1.addGrade(2, 75);
        student1.addGrade(3, 65);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 60);
        student2.addGrade(2, 25);
        student2.addGrade(3, 55);
        teacher.addStudent(student2);
        double[] expectedAverageGrades = {63.33, 46.66};
        assertArrayEquals(expectedAverageGrades, teacher.getStudentsAverage());
        int[] expectedPositions = {1, 2};
        assertArrayEquals(expectedPositions, teacher.getStudentPositions());
    }

    @Test
    public void tesThatWhenIAddStudents_AndSubjectsAndGradesAreAdded_WhenIGetStudentsAverage_IGetPositionOfEachStudentTest2() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 60);
        student1.addGrade(2, 25);
        student1.addGrade(3, 55);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 50);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        double[] expectedAverageGrades = {46.66, 63.33};
        assertArrayEquals(expectedAverageGrades, teacher.getStudentsAverage());
        int[] expectedPositions = {2, 1};
        assertArrayEquals(expectedPositions, teacher.getStudentPositions());
    }

    @Test
    public void testThatWhenIAddOneStudent_AndSubjectsAndGrades_WhenICheckForHighestGrade_IGetHighestGrade() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 50);
        student1.addGrade(2, 75);
        student1.addGrade(3, 65);
        teacher.addStudent(student1);
        assertEquals(75, teacher.getStudentHighestScore(student1));
    }

    @Test
    public void testThatWhenIAddOneStudent_AndSubjectsAndGrades_WhenICheckForLowestGrade_IGetLowestGrade() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 50);
        student1.addGrade(2, 75);
        student1.addGrade(3, 65);
        teacher.addStudent(student1);
        assertEquals(50, teacher.getStudentLowestScore(student1));
    }

    @Test
    public void testThatWhenIAddOneStudent_AndSubjectsAndGrades_WhenICheckSubjectsPassed_IGetNumberOfSubjectsPassed() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 50);
        student1.addGrade(2, 75);
        student1.addGrade(3, 65);
        teacher.addStudent(student1);
        assertEquals(3, teacher.getStudentSubjectsPassed(student1));
    }

    @Test
    public void testThatWhenIAddOneStudent_AndSubjectsAndGrades_WhenICheckStudentsSubjectsFailed_IGetNumberOfSubjectsFailed() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 20);
        student1.addGrade(2, 40);
        student1.addGrade(3, 60);
        teacher.addStudent(student1);
        assertEquals(2, teacher.getStudentSubjectsFailed(student1));

    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_WhenICheckForNoOfStudentsThatFailedASubject_IGetNumberOfStudentsThatFailedThatSubject() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 40);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        assertEquals(2, teacher.getNumberOfStudentsThatFailed(1));
        assertEquals(0, teacher.getNumberOfStudentsThatFailed(2));
        assertEquals(1, teacher.getNumberOfStudentsThatFailed(3));
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_WhenICheckForNoOfStudentsThatPassedASubject_IGetNumberOfStudentsThatPassedThatSubject() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        assertEquals(1, teacher.getNumberOfStudentsThatPassed(1));
        assertEquals(3, teacher.getNumberOfStudentsThatPassed(2));
        assertEquals(2, teacher.getNumberOfStudentsThatPassed(3));
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForNumberOfStudentsThatFailedForEachSubject() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 40);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[] expectedArrayOfStudentsThatFailedEachSubjects = {2, 0, 1};
        assertArrayEquals(expectedArrayOfStudentsThatFailedEachSubjects, teacher.getArrayOfFailedStudents());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForNumberOfStudentsThatPasseForEachSubject() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[] expectedArrayOfStudentsThatFailedEachSubjects = {1, 3, 2};
        assertArrayEquals(expectedArrayOfStudentsThatFailedEachSubjects, teacher.getArrayOfPassedStudents());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForHardestSubject() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[] expectedArrayOfStudentsThatFailedEachSubjects = {2, 0, 1};
        int[] expectedArrayOfPassedStudents = {1, 3, 2};
        assertArrayEquals(expectedArrayOfStudentsThatFailedEachSubjects, teacher.getArrayOfFailedStudents());
        assertArrayEquals(expectedArrayOfPassedStudents, teacher.getArrayOfPassedStudents());
        assertEquals(1, teacher.getHardestSubject());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForEasiestSubject() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[] expectedArrayOfStudentsThatFailedEachSubjects = {2, 0, 1};
        int[] expectedArrayOfPassedStudents = {1, 3, 2};
        assertArrayEquals(expectedArrayOfStudentsThatFailedEachSubjects, teacher.getArrayOfFailedStudents());
        assertArrayEquals(expectedArrayOfPassedStudents, teacher.getArrayOfPassedStudents());
        assertEquals(2, teacher.getEasiestSubject());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForNumberOfPassesForEasiestSubject() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[] expectedArrayOfStudentsThatFailedEachSubjects = {2, 0, 1};
        int[] expectedArrayOfPassedStudents = {1, 3, 2};
        assertArrayEquals(expectedArrayOfStudentsThatFailedEachSubjects, teacher.getArrayOfFailedStudents());
        assertArrayEquals(expectedArrayOfPassedStudents, teacher.getArrayOfPassedStudents());
        assertEquals(2, teacher.getEasiestSubject());
        assertEquals(3, teacher.getNumberOfPassForEasiestSubject());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForNumberOfFailsForHardestSubject() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[] expectedArrayOfStudentsThatFailedEachSubjects = {2, 0, 1};
        int[] expectedArrayOfPassedStudents = {1, 3, 2};
        assertArrayEquals(expectedArrayOfStudentsThatFailedEachSubjects, teacher.getArrayOfFailedStudents());
        assertArrayEquals(expectedArrayOfPassedStudents, teacher.getArrayOfPassedStudents());
        assertEquals(2, teacher.getEasiestSubject());
        assertEquals(2, teacher.getNumberOfFailsForHardestSubject());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForAllTheGradesOfAllTheStudents_ICanGetHighestScoreForEachSubject(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[][] expectedScoresOfStudents = {{45, 75, 25}, {20, 75, 65}, {90, 75, 65}};
        assertArrayEquals(expectedScoresOfStudents, teacher.getAllStudentsScore());
        assertEquals(90, teacher.getHighestScoreIn(1));
    }



    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForAllTheGradesOfAllTheStudents_ICanGetStudentWithHighestScoreInSubject(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[][] expectedScoresOfStudents = {{45, 75, 25}, {20, 75, 65}, {90, 75, 65}};
        assertArrayEquals(expectedScoresOfStudents, teacher.getAllStudentsScore());
        assertEquals(3, teacher.getStudentWithHighestScoreIn(1));
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForAllTheGradesOfAllTheStudents_ICanGetLowestScoreForEachSubject(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[][] expectedScoresOfStudents = {{45, 75, 25}, {20, 75, 65}, {90, 75, 65}};
        assertArrayEquals(expectedScoresOfStudents, teacher.getAllStudentsScore());
        assertEquals(20, teacher.getLowestScoreIn(1));
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForAllTheGradesOfAllTheStudents_ICanGetStudentWithLowestScoreInSubject(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[][] expectedScoresOfStudents = {{45, 75, 25}, {20, 75, 65}, {90, 75, 65}};
        assertArrayEquals(expectedScoresOfStudents, teacher.getAllStudentsScore());
        assertEquals(2, teacher.getStudentWithLowestScoreIn(1));
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForAllTheGradesOfAllTheStudents_AndGetTheSumOfAnySubject(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[][] expectedScoresOfStudents = {{45, 75, 25}, {20, 75, 65}, {90, 75, 65}};
        assertArrayEquals(expectedScoresOfStudents, teacher.getAllStudentsScore());
        assertEquals(155, teacher.getSumOfScoreIn(1));
        assertEquals(225, teacher.getSumOfScoreIn(2));
        assertEquals(155, teacher.getSumOfScoreIn(3));
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForAllTheGradesOfAllTheStudents_AndGetTheNumberOfPassForAnySubject(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[][] expectedScoresOfStudents = {{45, 75, 25}, {20, 75, 65}, {90, 75, 65}};
        assertArrayEquals(expectedScoresOfStudents, teacher.getAllStudentsScore());
        assertEquals(1, teacher.getNumberOfPassIn(1));
        assertEquals(3, teacher.getNumberOfPassIn(2));
        assertEquals(2, teacher.getNumberOfPassIn(3));
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForAllTheGradesOfAllTheStudents_AndGetTheNumberOfFailsForAnySubject(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[][] expectedScoresOfStudents = {{45, 75, 25}, {20, 75, 65}, {90, 75, 65}};
        assertArrayEquals(expectedScoresOfStudents, teacher.getAllStudentsScore());
        assertEquals(2, teacher.getNumberOfFailIn(1));
        assertEquals(0, teacher.getNumberOfFailIn(2));
        assertEquals(1, teacher.getNumberOfFailIn(3));
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForAllTheGradesOfAllTheStudents() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[][] expectedScoresOfStudents = {{45, 75, 25}, {20, 75, 65}, {90, 75, 65}};
        assertArrayEquals(expectedScoresOfStudents, teacher.getAllStudentsScore());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForAllTheGradesOfAllTheStudents_AndGetStudentWithTheOverallHighestScore() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[][] expectedScoresOfStudents = {{45, 75, 25}, {20, 75, 65}, {90, 75, 65}};
        assertArrayEquals(expectedScoresOfStudents, teacher.getAllStudentsScore());
        assertEquals(3, teacher.getStudentWithHighestOverallScore());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForAllTheGradesOfAllTheStudents_AndGetStudentWithTheOverallLowestScore() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[][] expectedScoresOfStudents = {{45, 75, 25}, {20, 75, 65}, {90, 75, 65}};
        assertArrayEquals(expectedScoresOfStudents, teacher.getAllStudentsScore());
        assertEquals(2, teacher.getStudentWithLowestOverallScore());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForAllTheGradesOfAllTheStudents_AndGetSubjectWithTheOverallLowestScore() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[][] expectedScoresOfStudents = {{45, 75, 25}, {20, 75, 65}, {90, 75, 65}};
        assertArrayEquals(expectedScoresOfStudents, teacher.getAllStudentsScore());
        assertEquals(1, teacher.getSubjectWithLowestOverallScore());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_ICanCheckForAllTheGradesOfAllTheStudents_AndGetSubjectWithTheOverallHighestScore() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[][] expectedScoresOfStudents = {{45, 75, 25}, {20, 75, 65}, {90, 75, 65}};
        assertArrayEquals(expectedScoresOfStudents, teacher.getAllStudentsScore());
        assertEquals(1, teacher.getSubjectWithHighestOverallScore());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_IGetAllTheTotalScoresOfEachStudent() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[] expectedAverageScoresOfStudents = {145, 160, 230};
        assertArrayEquals(expectedAverageScoresOfStudents, teacher.getSumOfStudentsScores());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_IGetAllTheTotalScoresOfEachStudent_IGetTheOverallBestStudent() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[] expectedAverageScoresOfStudents = {145, 160, 230};
        assertArrayEquals(expectedAverageScoresOfStudents, teacher.getSumOfStudentsScores());
        assertEquals(3, teacher.getBestStudent());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_IGetAllTheTotalScoresOfEachStudent_IGetTheOverallBestStudentTotalScore() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[] expectedAverageScoresOfStudents = {145, 160, 230};
        assertArrayEquals(expectedAverageScoresOfStudents, teacher.getSumOfStudentsScores());
        assertEquals(230, teacher.getBestStudentScore());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_IGetAllTheTotalScoresOfEachStudent_IGetTheOverallWorstStudent() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[] expectedAverageScoresOfStudents = {145, 160, 230};
        assertArrayEquals(expectedAverageScoresOfStudents, teacher.getSumOfStudentsScores());
        assertEquals(1, teacher.getWorstStudent());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_IGetAllTheTotalScoresOfEachStudent_IGetTheOverallWorstStudentTotalScore() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[] expectedAverageScoresOfStudents = {145, 160, 230};
        assertArrayEquals(expectedAverageScoresOfStudents, teacher.getSumOfStudentsScores());
        assertEquals(145, teacher.getWorstStudentScore());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_IGetAllTheTotalScoresOfEachStudent_IGetSumOfEachStudentsScore() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[] expectedAverageScoresOfStudents = {145, 160, 230};
        assertArrayEquals(expectedAverageScoresOfStudents, teacher.getSumOfStudentsScores());
        assertEquals(535, teacher.getTotalSumOfStudentsScores());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_IGetAllTheTotalSAverageForAllStudents() {
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[] expectedAverageScoresOfStudents = {145, 160, 230};
        assertArrayEquals(expectedAverageScoresOfStudents, teacher.getSumOfStudentsScores());
        assertEquals(535, teacher.getTotalSumOfStudentsScores());
        assertEquals(178.3, teacher.getTotalAverageOfStudentScore());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_IGetOverallHighestScore(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[][] expectedScoresOfStudents = {{45, 75, 25}, {20, 75, 65}, {90, 75, 65}};
        assertArrayEquals(expectedScoresOfStudents, teacher.getAllStudentsScore());
        assertEquals(90, teacher.getOverallHighestScore());
    }

    @Test
    public void testThatWhenStudentsAreAdded_AndSubjectsAndGradesAreAdded_IGetOverallLowestScore(){
        Student student1 = new Student();
        student1.registerNumberOfSubjects(3);
        student1.addGrade(1, 45);
        student1.addGrade(2, 75);
        student1.addGrade(3, 25);
        teacher.addStudent(student1);
        Student student2 = new Student();
        student2.registerNumberOfSubjects(3);
        student2.addGrade(1, 20);
        student2.addGrade(2, 75);
        student2.addGrade(3, 65);
        teacher.addStudent(student2);
        Student student3 = new Student();
        student3.registerNumberOfSubjects(3);
        student3.addGrade(1, 90);
        student3.addGrade(2, 75);
        student3.addGrade(3, 65);
        teacher.addStudent(student3);
        int[][] expectedScoresOfStudents = {{45, 75, 25}, {20, 75, 65}, {90, 75, 65}};
        assertArrayEquals(expectedScoresOfStudents, teacher.getAllStudentsScore());
        assertEquals(20, teacher.getOverallLowestScore());
    }
}