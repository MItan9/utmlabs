// основные функции для доступа и проверки файлов в директории
package org.labs.labthree.services;

import java.io.File;

abstract public class GitTracker {

    protected final String folderPath;

    public GitTracker(String folderPath) {
        this.folderPath = folderPath;
    }


    // проверяет, существует ли директория и является ли она действительно директорией.
    // Если нет, метод печатает сообщение об ошибке и возвращает null.
    protected File[] getListOfFiles() {
        var folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("It's not a valid directory: " + folderPath);
            return null;
        }

        var listOfFiles = folder.listFiles();

//Если директория существует, метод пытается получить список файлов с помощью listFiles().
// Если это не удаётся, он снова печатает сообщение об ошибке и возвращает null.
        if (listOfFiles == null) {
            System.out.println("Unable to list files from the directory: " + folderPath);
            return null;
        }
//Если всё проходит успешно, метод возвращает массив файлов.
        return listOfFiles;
    }

    public abstract void scanDirectory();
}
