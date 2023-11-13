package org.labs.labthree.services.FileServices;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TextFileInfo extends FileInfo {
    public TextFileInfo(File file) {
        super(file);
    }

    @Override
    public void displaySpecificInfo() {
        try {
            var lines = Files.readAllLines(file.toPath());
            System.out.println("Line Count: " + lines.size());
            System.out.println("Word Count: " + lines.stream().mapToInt(line -> line.split("\\s+").length).sum());
            System.out.println("Character Count: " + lines.stream().mapToInt(String::length).sum());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

