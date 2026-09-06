package student;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
            TO DISPLAY ALL GRADES       -> PRESS 3
            ===============================================
            TO EXIT                     -> PRESS 0
            ===============================================
                       \s""";
                ArrayList<Student> eachStudent = new ArrayList<>();
                int numberOfStudents = 0;
                String numberOfSubjects = "";
                String studentNumber = "";

                int studentMenuChoice = -1;
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
