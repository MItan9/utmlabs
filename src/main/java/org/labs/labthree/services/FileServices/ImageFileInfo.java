package org.labs.labthree.services.FileServices;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageFileInfo extends FileInfo {
    public ImageFileInfo(File file) {
        super(file);
    }

    @Override
    public void displaySpecificInfo() {
        try {
            var image = ImageIO.read(file);
            System.out.println("Image Size: " + image.getWidth() + "x" + image.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

