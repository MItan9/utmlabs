package org.labs.labthree.services.FileServices;
import java.io.File;


public class FileService {

    private final String folderPath;

    public FileService(String folderPath) {
        this.folderPath = folderPath;
    }

    public void info(String fileName) {
        File file = new File(folderPath + "/" + fileName);
        if (file.exists()) {
            FileInfo fileInfo = FileInfoFactory.getFileInfo(file);
            if (fileInfo != null) {
                fileInfo.displayBasicInfo();
                fileInfo.displaySpecificInfo();
            } else {
                System.out.println("Unsupported file type.");
            }
        } else {
            System.out.println(fileName + " does not exist.");
        }
    }
}
