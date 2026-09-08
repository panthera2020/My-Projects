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
        for(int eachStudent = 0; eachStudent < studentPositions.length; eachStudent++){studentPositions[eachStudent] = eachStudent + 1;}

        for(int index = 0; index < gradeBook.size(); index++){
            for(int count = index + 1; count < gradeBook.size(); count++){
                if(averageGrades[index] < averageGrades[count]){
                    int store = studentPositions[index];
                    studentPositions[index] = studentPositions[count];
                    studentPositions[count] = store;
                    double avgStore = averageGrades[index];
                    averageGrades[index] = averageGrades[count];
                    averageGrades[count] = avgStore;
                }
            }
        }
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

    public int getNumberOfStudentsThatFailed(int subject) {
        int numberOfStudentsThatFailed = 0;
        ArrayList<Student> studentsRegistered = checkGradeBook();
        for(Student student : studentsRegistered){
            if(student.checkGrade(subject) < 50){
                numberOfStudentsThatFailed++;
            }
        }
        return numberOfStudentsThatFailed;
    }

    public int getNumberOfStudentsThatPassed(int subject) {
        int numberOfStudentsThatPassed = 0;
        ArrayList<Student> studentsRegistered = checkGradeBook();
        for(Student student : studentsRegistered){
            if(student.checkGrade(subject) >= 50){
                numberOfStudentsThatPassed++;
            }
        }
        return numberOfStudentsThatPassed;
    }

    public int [] getArrayOfFailedStudents() {
        int [] failedStudents = new int[gradeBook.get(0).getNumberOfSubjects()];
        for(int subject = 1; subject <= failedStudents.length; subject++){
            failedStudents[subject - 1] = getNumberOfStudentsThatFailed(subject);
        }
        return failedStudents;
    }

    public int [] getArrayOfPassedStudents() {
        int [] passedStudents = new int[gradeBook.get(0).getNumberOfSubjects()];
        for(int subject = 1; subject <= passedStudents.length; subject++){
            passedStudents[subject - 1] = getNumberOfStudentsThatPassed(subject);
        }
        return passedStudents;
    }

    public int getHardestSubject() {
        int [] failedStudentInEachSubject = getArrayOfFailedStudents();
        int hardestSubject = 1;
        int hardestSubjectIndex = failedStudentInEachSubject[0];
        for(int numberOfFailedStudent = 0; numberOfFailedStudent < failedStudentInEachSubject.length; numberOfFailedStudent++){
            if(failedStudentInEachSubject[numberOfFailedStudent] > hardestSubjectIndex){
                hardestSubjectIndex = failedStudentInEachSubject[numberOfFailedStudent];
                hardestSubject = numberOfFailedStudent + 1;
            }
        }
        return hardestSubject;
    }

    public int getEasiestSubject() {
        int [] passedStudentInEachSubject = getArrayOfPassedStudents();
        int easiestSubject = 1;
        int easiestSubjectIndex = passedStudentInEachSubject[0];
        for(int numberOfPassedStudent = 1; numberOfPassedStudent < passedStudentInEachSubject.length; numberOfPassedStudent++){
            if(passedStudentInEachSubject[numberOfPassedStudent] > easiestSubjectIndex){
                easiestSubjectIndex = passedStudentInEachSubject[numberOfPassedStudent];
                easiestSubject = numberOfPassedStudent + 1;
            }
        }
        return easiestSubject;
    }

    public int getNumberOfPassForEasiestSubject() {
        int [] passedStudentInEachSubject = getArrayOfPassedStudents();
        int numberOfPasses = passedStudentInEachSubject[0];
        for(int numberOfPassedStudent = 1; numberOfPassedStudent < passedStudentInEachSubject.length; numberOfPassedStudent++){
            if(passedStudentInEachSubject[numberOfPassedStudent] > numberOfPasses){
                numberOfPasses = passedStudentInEachSubject[numberOfPassedStudent];
            }
        }
        return numberOfPasses;
    }

    public int getNumberOfFailsForHardestSubject() {
        int [] failedStudentInEachSubject = getArrayOfFailedStudents();
        int numberOfFails = failedStudentInEachSubject[0];
        for (int numberOfFailedStudent : failedStudentInEachSubject) {
            if (numberOfFailedStudent > numberOfFails) {
                numberOfFails = numberOfFailedStudent;
            }
        }
        return numberOfFails;
    }

    public int [][] getAllStudentsScore() {
        ArrayList <int []> allScores = new ArrayList<>();
        ArrayList<Student> studentsRegistered = checkGradeBook();
        for(Student student : studentsRegistered){
            int [] eachStudentGrade = student.getGrades();
            allScores.add(eachStudentGrade);
        }
        return allScores.toArray(new int [][]{});
    }

    public int getOverallHighestScore() {
        int highestScore = 0;
        int [][] allScores = getAllStudentsScore();
        for(int index = 0; index < allScores.length; index++){
            for(int grade = 0; grade < allScores[index].length; grade++){
                if(allScores[index][grade] > highestScore){
                    highestScore = allScores[index][grade];
                }
            }
        }
        return highestScore;
    }

    public int getOverallLowestScore() {
        int [][] allScores = getAllStudentsScore();
        int lowestScore = allScores[0][0];
        for(int index = 0; index < allScores.length; index++){
            for(int grade = 0; grade < allScores[index].length; grade++){
                if(allScores[index][grade] < lowestScore){
                    lowestScore = allScores[index][grade];
                }
            }
        }
        return lowestScore;
    }

    public int getStudentWithHighestOverallScore() {
        int studentWithHighestScore = 1;
        int highestScore = 0;
        int [][] allScores = getAllStudentsScore();
        for(int index = 0; index < allScores.length; index++){
            for(int grade = 0; grade < allScores[index].length; grade++){
                if(allScores[index][grade] > highestScore){
                    highestScore = allScores[index][grade];
                    studentWithHighestScore = index + 1;
                }
            }
        }
        return studentWithHighestScore;
    }

    public int getStudentWithLowestOverallScore() {
        int studentWithLowestScore = 1;
        int [][] allScores = getAllStudentsScore();
        int lowestScore = allScores[0][0];
        for(int index = 0; index < allScores.length; index++){
            for(int grade = 0; grade < allScores[index].length; grade++){
                if(allScores[index][grade] < lowestScore){
                    lowestScore = allScores[index][grade];
                    studentWithLowestScore = index + 1;
                }
            }
        }
        return studentWithLowestScore;
    }

    public int getSubjectWithLowestOverallScore() {
        int subjectWithLowestScore = 1;
        int [][] allScores = getAllStudentsScore();
        int lowestScore = allScores[0][0];
        for (int[] allScore : allScores) {
            for (int grade = 0; grade < allScore.length; grade++) {
                if (allScore[grade] < lowestScore) {
                    lowestScore = allScore[grade];
                    subjectWithLowestScore = grade + 1;
                }
            }
        }
        return subjectWithLowestScore;
    }

    public int getSubjectWithHighestOverallScore() {
        int subjectWithHighestScore = 1;
        int [][] allScores = getAllStudentsScore();
        int highestScore = allScores[0][0];
        for (int[] allScore : allScores) {
            for (int grade = 0; grade < allScore.length; grade++) {
                if (allScore[grade] > highestScore) {
                    highestScore = allScore[grade];
                    subjectWithHighestScore = grade + 1;
                }
            }
        }
        return subjectWithHighestScore;
    }

    public int [] getSumOfStudentsScores() {
        int [] averageScores = new int[gradeBook.size()];
        ArrayList<Student> studentsRegistered = checkGradeBook();
        int count = 0;
        for(Student student : studentsRegistered){
            int [] eachStudentGrade = student.getGrades();
            int sum = 0;
            for (int grade : eachStudentGrade) {
                sum += grade;
            }
            averageScores[count++] = sum;
        }
        return averageScores;
    }

    public int getBestStudent() {
        int [] averageScores = getSumOfStudentsScores();
        int bestStudent = 1;
        int highestScore = averageScores[0];
        for(int index = 0; index < averageScores.length; index++){
            if(averageScores[index] > highestScore){
                highestScore = averageScores[index];
                bestStudent = index + 1;
            }
        }
        return bestStudent;
    }

    public int getBestStudentScore() {
        int [] averageScores = getSumOfStudentsScores();
        int bestStudentScore = averageScores[0];
        for (int averageScore : averageScores) {
            if (averageScore > bestStudentScore) {
                bestStudentScore = averageScore;
            }
        }
        return bestStudentScore;
    }

    public int getWorstStudent() {
        int [] averageScores = getSumOfStudentsScores();
        int worstStudent = 1;
        int lowestScore = averageScores[0];
        for(int index = 0; index < averageScores.length; index++){
            if(averageScores[index] < lowestScore){
                lowestScore = averageScores[index];
                worstStudent = index + 1;
            }
        }
        return worstStudent;
    }

    public int getWorstStudentScore() {
        int [] averageScores = getSumOfStudentsScores();
        int worstStudentScore = averageScores[0];
        for (int averageScore : averageScores) {
            if (averageScore < worstStudentScore) {
                worstStudentScore = averageScore;
            }
        }
        return worstStudentScore;
    }

    public int getTotalSumOfStudentsScores() {
        int [] averageScores = getSumOfStudentsScores();
        int totalSum = 0;
        for(int scores :  averageScores){
            totalSum += scores;
        }
        return totalSum;
    }

    public double getTotalAverageOfStudentScore() {
        return (Math.floor(((double)getTotalSumOfStudentsScores() / gradeBook.size()) * 10)) / 10;
    }

    public int getHighestScoreIn(int subject) {
        int [][] studentsScore = getAllStudentsScore();
        int highestScore = studentsScore[0][subject - 1];
        for(int index = 0; index < studentsScore.length; index++){
            if(studentsScore[index][subject -1] > highestScore){
                highestScore = studentsScore[index][subject -1];
            }
        }
        return highestScore;
    }

    public int getLowestScoreIn(int subject) {
        int [][] studentsScore = getAllStudentsScore();
        int lowestScore = studentsScore[0][subject - 1];
        for(int index = 0; index < studentsScore.length; index++){
            if(studentsScore[index][subject -1] < lowestScore){
                lowestScore = studentsScore[index][subject -1];
            }
        }
        return lowestScore;
    }

    public int getStudentWithHighestScoreIn(int subject) {
        int [][] studentsScore = getAllStudentsScore();
        int studentWithHighestScore = 1;
        int highestScore = studentsScore[0][subject - 1];
        for(int index = 0; index < studentsScore.length; index++){
            if(studentsScore[index][subject -1] > highestScore){
                highestScore = studentsScore[index][subject -1];
                studentWithHighestScore = index + 1;
            }
        }
        return studentWithHighestScore;
    }

    public int getStudentWithLowestScoreIn(int subject) {
        int [][] studentsScore = getAllStudentsScore();
        int studentWithLowestScore = 1;
        int lowestScore = studentsScore[0][subject - 1];
        for(int index = 0; index < studentsScore.length; index++){
            if(studentsScore[index][subject -1] < lowestScore){
                lowestScore = studentsScore[index][subject -1];
                studentWithLowestScore = index + 1;
            }
        }
        return studentWithLowestScore;
    }

    public int getSumOfScoreIn(int subject) {
        int [][] studentsScore = getAllStudentsScore();
        int sumOfScore = 0;
        for(int index = 0; index < studentsScore.length; index++){
            sumOfScore += studentsScore[index][subject -1];
        }
        return sumOfScore;
    }

    public int getNumberOfPassIn(int subject) {
        int [][] studentsScore = getAllStudentsScore();
        int numberOfPass = 0;
        for(int index = 0; index < studentsScore.length; index++){
            if(studentsScore[index][subject -1] >= 50){
                numberOfPass++;
            }
        }
        return numberOfPass;
    }

    public int getNumberOfFailIn(int subject) {
        int [][] studentsScore = getAllStudentsScore();
        int numberOfFail = 0;
        for(int index = 0; index < studentsScore.length; index++){
            if(studentsScore[index][subject -1] < 50){
                numberOfFail++;
            }
        }
        return numberOfFail;
    }


}
