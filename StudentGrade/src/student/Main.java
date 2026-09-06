package student;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Function function = new Function();

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
            ===============================================
            TO EXIT                     -> PRESS 0
            ===============================================
                       \s""";
                ArrayList<Student> eachStudent = new ArrayList<>();
                int studentMenuChoice = -1;
                int numberOfStudents = 0;
                while(studentMenuChoice != 0){
                    IO.println(registerStudentMenu);
                    IO.println("How many students do you have?");
                    String studentNumber = input.nextLine();
                    IO.println("How many subjects do they offer?");
                    String numberOfSubjects = input.nextLine();
                    if(function.isInputValid(studentNumber) && studentNumber.equals("1") && function.isNumberOfSubjectValid(numberOfSubjects)){
                        numberOfStudents = Integer.parseInt(numberOfSubjects);
                        eachStudent = new ArrayList<>(numberOfStudents);
                        for(int newStudent = 0; newStudent < numberOfStudents; newStudent++){
                            Student newStudents = new Student();
                            newStudents.registerNumberOfSubjects(Integer.parseInt(numberOfSubjects));
                            eachStudent.add(newStudents);
                        }
                        IO.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>");
                        IO.println("Saved successfully");
                        IO.println();
                    }else if(function.isInputValid(studentNumber) && studentNumber.equals("2") && function.isNumberOfSubjectValid(numberOfSubjects)){
                        for(int student = 0; student < eachStudent.size(); student++){
                            for(int subject = 0; subject < Integer.parseInt(numberOfSubjects); subject++){
                                IO.println("Entering score for student " + (student +  1));
                                IO.println("Enter score for subject " + eachStudent.get(student).getSubject(subject + 1));
                                int score = input.nextInt();
                                eachStudent.get(student).addGrade(subject + 1, score);
                                IO.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>");
                                IO.println("Saved successfully");
                            }
                        }
                    }else if(function.isInputValid(studentNumber) && studentNumber.equals("0")){
                        studentMenuChoice = 0;
                    }else{
                        IO.println("Invalid Input");
                    }
                }
            }else if(function.isInputValid(choice) && choice.equals("0")){
                teacherMenuChoice = 0;
            }else{
                IO.println();
                IO.println("Invalid choice. \nEnter Valid Choice.");
            }

        }
    }
}
