package student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Function function = new Function();
        Teacher teacher = new Teacher();

        String welcomeMessage = """
            =============================================
            WELCOME TO LAGBAJA STUDENT MANAGEMENT SYSTEM
            =============================================
            TO REGISTER STUDENTS GRADES -> PRESS 1
            TO EXIT                     -> PRESS 0
            =============================================
            """;
        int teacherMenuChoice = -1;
        while(teacherMenuChoice != 0){
            IO.println(welcomeMessage);
            String choice = input.nextLine();
            if(function.isInputValid(choice) && choice.equals("1")){
                String registerStudentMenu = """
            ===============================================
            TO ENTER NUMBER OF STUDENTS -> PRESS 1
            TO ENTER GRADES             -> PRESS 2
            TO DISPLAY ALL GRADES       -> PRESS 3
            TO DISPLAY SUMMARY          -> PRESS 4
            ===============================================
            TO EXIT                     -> PRESS 0
            ===============================================
                       \s""";
                ArrayList<Student> eachStudent = new ArrayList<>();
                int numberOfStudents = 0;
                String numberOfSubjects = "";

                int studentMenuChoice = -1;
                String studentNumber = "";
                while(studentMenuChoice != 0){
                    IO.println(registerStudentMenu);
                    String studentMenu = input.nextLine();
                    if(function.isInputValid(studentMenu) && studentMenu.equals("1")){

                        IO.println("How many students do you have?");
                        studentNumber = input.nextLine();
                        IO.println("How many subjects do they offer?");
                        numberOfSubjects = input.nextLine();
                        if(function.isNumberOfSubjectValid(studentNumber) && function.isNumberOfSubjectValid(numberOfSubjects)){
                            numberOfStudents = Integer.parseInt(studentNumber);
                            eachStudent = new ArrayList<>(numberOfStudents);
                            for(int newStudent = 0; newStudent < numberOfStudents; newStudent++){
                                Student newStudents = new Student();
                                newStudents.registerNumberOfSubjects(Integer.parseInt(numberOfSubjects));
                                eachStudent.add(newStudents);
                                teacher.addStudent(newStudents);
                            }
                            IO.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>");
                            IO.println("Saved successfully");
                            IO.println();
                        }
                    }else if(function.isInputValid(studentMenu) && studentMenu.equals("2")){
                        if(eachStudent.isEmpty()){
                            IO.println("No students registered");
                        }else{
                            for(int student = 0; student < eachStudent.size(); student++){
                                for(int subject = 1; subject <= Integer.parseInt(numberOfSubjects); subject++){
                                    IO.println("Entering score for student " + (student +  1));
                                    IO.println("Enter score for subject " + eachStudent.get(student).getSubject(subject));
                                    int score = input.nextInt();
                                    eachStudent.get(student).addGrade(subject, score);
                                    IO.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>");
                                    IO.println("Saved successfully");
                                }
                            }
                        }
                    }else if(function.isInputValid(studentMenu) && studentMenu.equals("0")){
                        studentMenuChoice = 0;
                    }else if(function.isInputValid(studentMenu) && studentMenu.equals("3")){
                        if(eachStudent.isEmpty()){
                            IO.println("No students registered");
                        }else{
                            int [] studentsPosition = teacher.getStudentPositions();
                            IO.println("================================================================");
                            System.out.printf(" %-10s", "STUDENTS");
                            for(int subject = 1; subject <= Integer.parseInt(numberOfSubjects); subject++){
                                System.out.printf(" %5s", "SUB" + subject);
                            }
                            System.out.printf(" %5s %5s %5s%n", "TOTAL", "AVE", "POS");
                            IO.println("================================================================");
                            int count = 0;
                            int position = 0;
                            for (Student student : eachStudent) {
                                count++;

                                System.out.printf(" %-10s", "Student " + count);
                                for(int subject = 1; subject <= Integer.parseInt(numberOfSubjects); subject++){
                                    System.out.printf(" %5s", student.checkGrade(subject));
                                }
                                System.out.printf(" %5s %5s %5s%n", teacher.getStudentTotalGrade(student), teacher.getStudentAverage(student), studentsPosition[position]);

                                position++;
                            }
                            IO.println("================================================================");
                        }
                    }else if(function.isInputValid(studentMenu) && studentMenu.equals("4")){
                        if(eachStudent.isEmpty()){
                            IO.println("No students registered");
                        }else{
                            IO.println("SUBJECT SUMMARY");
                            for(int student = 0; student < Integer.parseInt(numberOfSubjects); student++){
                                IO.println("Subject" + (student + 1));
                                IO.println("Highest Scoring Student is Student " + teacher.getStudentWithHighestScoreIn(student + 1) + " scoring " + teacher.getHighestScoreIn(student + 1));
                                IO.println("Lowest Scoring Student is Student " + teacher.getStudentWithLowestScoreIn(student + 1) +  " scoring " + teacher.getLowestScoreIn(student + 1));
                                IO.println("Total Score : " + teacher.getSumOfScoreIn(student + 1));
                                IO.println("Average Score : " + (teacher.getSumOfScoreIn(student + 1) / eachStudent.size()));
                                IO.println("Number of passes : " + teacher.getNumberOfPassIn(student + 1));
                                IO.println("Number of failures : " + teacher.getNumberOfFailIn(student + 1));
                                IO.println();
                            }

                            IO.println("The hardest subject is Subject " + teacher.getHardestSubject() + " with " + teacher.getNumberOfFailIn(teacher.getHardestSubject()) + " failures ");
                            IO.println("The easiest subject is Subject " + teacher.getEasiestSubject() + " with " + teacher.getNumberOfPassIn(teacher.getEasiestSubject()) + " passes ");
                            IO.println("The Overall highest score is scored by Student " + teacher.getStudentWithHighestOverallScore() + "  in " + teacher.getSubjectWithHighestOverallScore() + " scoring " + teacher.getOverallHighestScore());
                            IO.println("The Overall lowest score is scored by Student " + teacher.getStudentWithLowestOverallScore() + " in " +  teacher.getSubjectWithLowestOverallScore() + " scoring " + teacher.getOverallLowestScore());
                            IO.println();
                            IO.println("CLASS SUMMARY");
                            IO.println("================================================================");
                            IO.println("Best Graduating Student is Student " + teacher.getStudentWithHighestOverallScore() + " scoring " + teacher.getBestStudentScore());
                            IO.println("================================================================");

                            IO.println();
                            IO.println();
                            IO.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            IO.println("Worst Graduating Student is Student " + teacher.getStudentWithLowestOverallScore() + " scoring " + teacher.getWorstStudentScore());
                            IO.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                            IO.println();
                            IO.println();
                            IO.println("================================================================");
                            IO.println("Class Total Score: " + teacher.getTotalSumOfStudentsScores());
                            IO.println("Class Average Score: " + teacher.getTotalAverageOfStudentScore());
                            IO.println("================================================================");
                            IO.println();
                            IO.println();
                        }
                    }
                    else{
                        IO.println("Invalid input!");
                    }
                }
            }else if(function.isInputValid(choice) && choice.equals("0")){
                teacherMenuChoice = 0;
            }else{
                IO.println();
                IO.println("Invalid choice. \nEnter Valid Choice.");
                IO.println();
            }

        }
    }
}
