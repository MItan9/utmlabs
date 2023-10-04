package org.labs.labtwo.behavior.handlers;

import org.labs.labtwo.behavior.OperationsHandler;
import org.labs.labtwo.models.Faculty;
import org.labs.labtwo.models.University;

import java.util.Scanner;

public class GeneralOperationsHandler implements OperationsHandler {
    private University university;

    public GeneralOperationsHandler(University university) {
        this.university = university;
    }

    public void handle(Scanner scanner) {
        System.out.println("General operations");

        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("nf/<faculty name>/<faculty abbreviation>/<field> - create faculty");
            System.out.println("ss/<student email> - search student and show faculty");
            System.out.println("df - display faculties");
            System.out.println("df/<field> - display all faculties of a field");
            System.out.println("b - Back");
            System.out.println("q - Quit Program");
            String command = scanner.nextLine();
            String[] parts = command.split("/");
            if (command.equals("b")) {
                return;
            }

            switch (parts[0]) {
                case "nf":
                    if (parts.length != 4) {
                        System.out.println("Incorrect command. Enter data in the format: nf/<faculty name>/<faculty abbreviation>/<field>");
                    } else {
                        this.university.createFaculty(parts[1], parts[2], parts[3]);
                        System.out.println("The faculty is created");
                    }
                    break;
                case "ss":
                    if (parts.length != 2) {
                        System.out.println("Incorrect command. Enter data in the format: ss/<student email>");
                    } else {
                        Faculty faculty = this.university.findFacultyByStudentEmail(parts[1]);
                        if (faculty != null) {
                            System.out.println("Student belongs to the faculty " + faculty.getAbbreviation());
                        } else {
                            System.out.println("Student not found in faculties.");
                        }
                    }
                    break;
                case "df":
                    if (parts.length == 1) {
                        this.university.displayFaculties();
                    } else if (parts.length == 2) {
                        this.university.displayFacultiesByField(parts[1]);
                    } else {
                        System.out.println("Incorrect command. Use df or df/<field>.");
                    }
                    break;
                default:
                    System.out.println("Incorrect command. Repeat,please");
            }
        }
    }
}
