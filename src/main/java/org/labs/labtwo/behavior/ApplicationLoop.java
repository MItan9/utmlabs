package org.labs.labtwo.behavior;

import org.labs.labtwo.behavior.handlers.FacultyOperationsHandler;
import org.labs.labtwo.behavior.handlers.GeneralOperationsHandler;
import org.labs.labtwo.behavior.handlers.StudentHandler;
import org.labs.labtwo.models.University;

import java.util.Scanner;

public class ApplicationLoop {
    private University university;
    private OperationsHandler generalHandler;
    private OperationsHandler facultyHandler;
    private OperationsHandler studentHandler;

    public ApplicationLoop(University university) {
        this.university = university;
        this.generalHandler = new GeneralOperationsHandler(university);
        this.facultyHandler = new FacultyOperationsHandler(university);
        this.studentHandler = new StudentHandler();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to TUM's student management system!");
            System.out.println("What do you want to do?");
            System.out.println("g - General operations");
            System.out.println("f - Faculty operations");
            System.out.println("s - Student operations");
            System.out.println("q - Quit Program");
            switch (scanner.nextLine()) {
                case "g":
                    this.generalHandler.handle(scanner);
                    break;
                case "f":
                    this.facultyHandler.handle(scanner);
                    break;
                case "s":
                    this.studentHandler.handle(scanner);
                    break;
                case "q":
                    System.out.println("Quit Program");
                    return;
                default:
                    System.out.println("Incorrect selection. Please repeat.");
            }
        }
    }
}
