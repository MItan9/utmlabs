package org.labs.labthree.services.FileServices;

import java.io.File;

public class FileInfoFactory {

    // Method to create and return the appropriate FileInfo subclass instance
    public static FileInfo getFileInfo(File file) {
        String extension = getFileExtension(file);

        switch (extension.toLowerCase()) {
            case "txt":
                return new TextFileInfo(file);
            case "png":
            case "jpg":
                return new ImageFileInfo(file);
            case "py":
            case "java":
                return new CodeFileInfo(file);
            default:
                return null; // Return null or a default FileInfo implementation for unsupported file types
        }
    }

    // Helper method to extract the file extension
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        int lastIndexOfDot = fileName.lastIndexOf(".");
        if (lastIndexOfDot > 0) {
            return fileName.substring(lastIndexOfDot + 1);
        } else {
            return ""; // Return an empty string if there is no extension
        }
    }
}
