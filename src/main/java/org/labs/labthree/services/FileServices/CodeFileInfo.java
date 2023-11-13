package org.labs.labthree.services.FileServices;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Pattern;

public class CodeFileInfo extends FileInfo {
    public CodeFileInfo(File file) {
        super(file);
    }

    @Override
    public void displaySpecificInfo() {
        System.out.println("Line Count: " + getLineCount());
        System.out.println("Class Count: " + getClassCount());
        System.out.println("Method Count: " + getMethodCount());
    }

    private int getLineCount() {
        try {
            return (int) Files.lines(file.toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int getClassCount() {
        try {
            var lines = Files.readAllLines(file.toPath());
            var content = String.join(" ", lines);

            var classPattern = Pattern.compile("\\bclass\\b");
            var classMatcher = classPattern.matcher(content);

            int count = 0;
            while (classMatcher.find()) {
                count++;
            }
            return count;

        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private int getMethodCount() {
        try {
            var lines = Files.readAllLines(file.toPath());
            var content = String.join(" ", lines);

            var methodPattern = Pattern.compile("(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *\\{? *\\n?");
            var methodMatcher = methodPattern.matcher(content);

            int count = 0;
            while (methodMatcher.find()) {
                count++;
            }
            return count;

        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
