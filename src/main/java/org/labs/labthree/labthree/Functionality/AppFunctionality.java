package org.labs.labthree.Functionality;

import org.labs.labthree.services.GitFileTracker;

import java.util.Scanner;

public class AppFunctionality {

    private final String folderPath;

    public AppFunctionality(String folderPath) {
        this.folderPath = folderPath;
    }

    public void run() {
        var detector = new GitFileTracker(folderPath);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command (commit, info, status, exit):");
            String command = scanner.nextLine();
            switch (command) {
                case "commit" -> detector.commit();
                case "info" -> {
                    System.out.println("Enter file name:");
                    String fileName = scanner.nextLine();
                    detector.info(fileName);
                }
                case "status" -> detector.status();
                case "exit" -> {
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid command.");
            }
        }
    }

}
