package org.labs.comands;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileSnapshot {
    private final Map<String, FileInfo> files;
    private final Map<String, Long> originalModifiedTimes;

    public FileSnapshot() {
        files = new HashMap<>();
        originalModifiedTimes = new HashMap<>();
    }

    public void commit() {
        originalModifiedTimes.clear();
        for (FileInfo fileInfo : files.values()) {
            originalModifiedTimes.put(fileInfo.getName(), fileInfo.getLastModifiedTime());
        }
        System.out.println("Created Snapshot at: " + getCurrentTime());
    }

    public void info(String filename) {
        if (files.containsKey(filename)) {
            FileInfo fileInfo = files.get(filename);
            System.out.println("File: " + fileInfo.getName());
            System.out.println("Extension: " + fileInfo.getExtension());
            System.out.println("Creation Time: " + formatDate(fileInfo.getCreationTime()));
            System.out.println("Last Modified Time: " + formatDate(fileInfo.getLastModifiedTime()));
            if (fileInfo.isImage()) {
                System.out.println("Image Size: " + fileInfo.getImageSize());
            } else if (fileInfo.isText()) {
                System.out.println("Number of Lines: " + fileInfo.getNumLines());
                System.out.println("Number of Words: " + fileInfo.getNumWords());
                System.out.println("Number of Characters: " + fileInfo.getNumChars());
            } else if (fileInfo.isProgram()) {
                System.out.println("Number of Lines: " + fileInfo.getNumLines());
                System.out.println("Number of Classes: " + fileInfo.getNumClasses());
                System.out.println("Number of Methods: " + fileInfo.getNumMethods());
            }
        } else {
            System.out.println("File not found: " + filename);
        }
    }

    public void status() {
        for (String filename : files.keySet()) {
            FileInfo fileInfo = files.get(filename);
            String status = "unchanged";
            if (originalModifiedTimes.containsKey(filename) &&
                    fileInfo.getLastModifiedTime() > originalModifiedTimes.get(filename)) {
                status = "modified since last snapshot";
            }
            String currentTimeStatus = "unchanged";
            if (fileInfo.getLastModifiedTime() > System.currentTimeMillis() - 1000) {
                currentTimeStatus = "modified since current time";
            }
            System.out.println("File: " + fileInfo.getName() + ", Status: " + status + ", Current Time Status: " + currentTimeStatus);
        }
    }

    private String formatDate(long time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date(time));
    }

    private String getCurrentTime() {
        return formatDate(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        FileSnapshot fileSnapshot = new FileSnapshot();

        try {
            Path directoryPath = Paths.get("C:\\Users\\ZenBook\\IdeaProjects\\class\\src\\LaboratoryTwo\\src\\main\\java\\org\\labs");
            Files.walk(directoryPath)
                    .filter(Files::isRegularFile)
                    .forEach(file -> {
                        String filename = file.getFileName().toString();
                        FileInfo fileInfo = new FileInfo(file);
                        fileSnapshot.files.put(filename, fileInfo);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a command (commit, info <filename>, status): ");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");
            if (parts.length >= 1) {
                switch (parts[0]) {
                    case "commit":
                        fileSnapshot.commit();
                        break;
                    case "info":
                        if (parts.length == 2) {
                            fileSnapshot.info(parts[1]);
                        } else {
                            System.out.println("Invalid info command. Usage: info <filename>");
                        }
                        break;
                    case "status":
                        fileSnapshot.status();
                        break;
                    default:
                        System.out.println("Invalid command.");
                }
            }
        }
    }
}

class FileInfo {
    private String name;
    private String extension;
    private long creationTime;
    private long lastModifiedTime;
    private int imageSize;
    private int numLines;
    private int numWords;
    private int numChars;
    private int numClasses;
    private int numMethods;

    public FileInfo(Path filePath) {
        name = filePath.getFileName().toString();
        extension = getFileExtension(name);
        try {
            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            creationTime = attrs.creationTime().toMillis();
            lastModifiedTime = attrs.lastModifiedTime().toMillis();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (isImage()) {
            imageSize = getImageSize(filePath);
        } else if (isText()) {
            countTextFileInfo(filePath);
        } else if (isProgram()) {
            countProgramFileInfo(filePath);
        }
    }

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public long getLastModifiedTime() {
        return lastModifiedTime;
    }

    public int getImageSize() {
        return imageSize;
    }

    public int getNumLines() {
        return numLines;
    }

    public int getNumWords() {
        return numWords;
    }

    public int getNumChars() {
        return numChars;
    }

    public int getNumClasses() {
        return numClasses;
    }

    public int getNumMethods() {
        return numMethods;
    }

    public boolean isImage() {
        return extension.equals("jpg") || extension.equals("png");
    }

    public boolean isText() {
        return extension.equals("txt");
    }

    public boolean isProgram() {
        return extension.equals("java") || extension.equals("py");
    }

    private String getFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf(".");
        if (lastDotIndex > 0) {
            return filename.substring(lastDotIndex + 1);
        }
        return "";
    }

    private int getImageSize(Path filePath) {
        try {
            return (int) Files.size(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void countTextFileInfo(Path filePath) {
        try {
            List<String> lines = Files.readAllLines(filePath);
            numLines = lines.size();
            numChars = lines.stream().mapToInt(String::length).sum();
            numWords = lines.stream()
                    .mapToInt(line -> line.split("\\s+").length)
                    .sum();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void countProgramFileInfo(Path filePath) {
        try {
            List<String> lines = Files.readAllLines(filePath);
            numLines = lines.size();
            numClasses = (int) lines.stream()
                    .filter(line -> line.trim().startsWith("class "))
                    .count();
            numMethods = (int) lines.stream()
                    .filter(line -> line.trim().startsWith("public") || line.trim().startsWith("private"))
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}