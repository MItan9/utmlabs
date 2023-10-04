package org.labs.labtwo.behavior.handlers;

import org.labs.labtwo.behavior.OperationsHandler;
import org.labs.labtwo.models.Faculty;
import org.labs.labtwo.models.Student;
import org.labs.labtwo.models.University;

import java.io.PrintStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class FacultyOperationsHandler implements OperationsHandler {
    private University university;

    public FacultyOperationsHandler(University university) {
        this.university = university;
    }

    public void handle(Scanner scanner) {
        System.out.println("Faculty operations");
        System.out.println("What do you want to do?");
        System.out.println("ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year> - new student's enrollment");
        System.out.println("gs/<email> - student graduation");
        System.out.println("ds/<faculty abbreviation> - to show enrolled students");
        System.out.println("dg/<faculty abbreviation> - to show graduated students");
        System.out.println("bf/<faculty abbreviation>/<email> - check whether the student belongs to a faculty");
        System.out.println("b - Back");
        System.out.println("q - Quit Program");

            while (true) {
                label108:
                while (true) {
                    String command = scanner.nextLine();
                    String[] parts = command.split("/");
                    if (command.equals("b")) {
                        return;
                    }

                    PrintStream var10000;
                    String var10001;
                    Faculty faculty;
                    switch (parts[0]) {
                        case "ns":
                            if (parts.length != 8) {
                                System.out.println("Incorrect command. Enter data in the format: ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year>");
                            } else {
                                String facultyAbbreviation = parts[1];
                                String firstName = parts[2];
                                String lastName = parts[3];
                                String email = parts[4];
                                int day = Integer.parseInt(parts[5]);
                                int month = Integer.parseInt(parts[6]);
                                int year = Integer.parseInt(parts[7]);
                                Date dateOfBirth = new Date(year, month, day);
                                Student newStudent = new Student(firstName, lastName, email, dateOfBirth);
                                Faculty targetFaculty = this.university.findFacultyByAbbreviation(facultyAbbreviation);
                                if (targetFaculty != null) {
                                    targetFaculty.addStudent(newStudent);
                                    System.out.println("Student is enrolled in the faculty " + targetFaculty.getName());
                                } else {
                                    System.out.println("Faculty abbreviation " + facultyAbbreviation + " is not found.");
                                }
                            }
                            break;
                        case "gs":
                            if (parts.length != 2) {
                                System.out.println("Incorrect command. Enter a student's email in the format: gs/<email>");
                                break;
                            }

                            String studentEmail = parts[1];
                            Iterator var25 = this.university.getFaculties().iterator();

                            while (var25.hasNext()) {
                                faculty = (Faculty) var25.next();
                                Iterator var27 = faculty.getEnrolledStudents().iterator();

                                while (var27.hasNext()) {
                                    Student student = (Student) var27.next();
                                    if (student.getEmail().equals(studentEmail)) {
                                        faculty.graduateStudent(student);
                                        System.out.println("Student " + studentEmail + " has graduated.");
                                        return;
                                    }
                                }
                            }

                            System.out.println("Student's email " + studentEmail + " is not found.");
                            break;
                        case "ds":
                            if (parts.length != 2) {
                                System.out.println("Incorrect command. Enter faculty abbreviation in the format: ds/<faculty abbreviation>");
                            } else {
                                String facultyAbbrev = parts[1];
                                faculty = this.university.findFacultyByAbbreviation(facultyAbbrev);
                                if (faculty != null) {
                                    List<Student> enrolledStudents = faculty.getEnrolledStudents();
                                    System.out.println("Students enrolled in the faculty " + faculty.getName() + ":");
                                    Iterator var28 = enrolledStudents.iterator();

                                    while (true) {
                                        if (!var28.hasNext()) {
                                            continue label108;
                                        }

                                        Student student = (Student) var28.next();
                                        var10000 = System.out;
                                        var10001 = student.getEmail();
                                        var10000.println(var10001 + " - " + student.getFirstName() + " " + student.getLastName());
                                    }
                                }

                                System.out.println("Faculty abbreviation " + facultyAbbrev + " is not found.");
                            }
                            break;
                        case "dg":
                            if (parts.length != 2) {
                                System.out.println("Incorrect command. Enter faculty abbreviation in the format: dg/<faculty abbreviation>");
                            } else {
                                String facultyAbbreviation2 = parts[1];
                                Faculty targetFaculty2 = this.university.findFacultyByAbbreviation(facultyAbbreviation2);
                                if (targetFaculty2 != null) {
                                    List<Student> graduatedStudents = targetFaculty2.getGraduatedStudents();
                                    System.out.println("Graduated students in " + targetFaculty2.getName() + ":");
                                    Iterator var32 = graduatedStudents.iterator();

                                    while (true) {
                                        if (!var32.hasNext()) {
                                            continue label108;
                                        }

                                        Student student = (Student) var32.next();
                                        var10000 = System.out;
                                        var10001 = student.getEmail();
                                        var10000.println(var10001 + " - " + student.getFirstName() + " " + student.getLastName());
                                    }
                                }

                                System.out.println("Faculty abbreviation " + facultyAbbreviation2 + " is not found.");
                            }
                            break;
                        case "bf":
                            if (parts.length != 3) {
                                System.out.println("Incorrect command. Enter faculty abbreviation and student's email in the format: bf/<faculty abbreviation>/<email>");
                            } else {
                                String facultyAbbreviation3 = parts[1];
                                String studentEmail3 = parts[2];
                                Faculty targetFaculty3 = this.university.findFacultyByAbbreviation(facultyAbbreviation3);
                                if (targetFaculty3 != null) {
                                    Student targetStudent = this.university.findStudentByEmail(studentEmail3);
                                    if (targetStudent != null && targetFaculty3.containsStudent(targetStudent)) {
                                        System.out.println("Student's email " + studentEmail3 + " belongs to the faculty " + targetFaculty3.getName());
                                    } else {
                                        System.out.println("Student's email " + studentEmail3 + " doesn't belong to the faculty " + targetFaculty3.getName());
                                    }
                                } else {
                                    System.out.println("Faculty abbreviation  " + facultyAbbreviation3 + " is not found.");
                                }
                            }
                            break;
                        default:
                            System.out.println("Incorrect command. Please repeat.");
                    }
                }
            }
    }
}
