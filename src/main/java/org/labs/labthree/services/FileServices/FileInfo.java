package org.labs.labthree.services.FileServices;

import org.labs.labthree.SupportingTools.DateFormat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

public abstract class FileInfo {
    protected File file;
    protected BasicFileAttributes attrs;

    public FileInfo(File file) {
        this.file = file;
        try {
            this.attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayBasicInfo() {
        System.out.println("File Name: " + file.getName());
        System.out.println("Created Date: " + DateFormat.formatDate(attrs.creationTime().toMillis()));
        System.out.println("Updated Date: " + DateFormat.formatDate(file.lastModified()));
    }

    public abstract void displaySpecificInfo();
}

