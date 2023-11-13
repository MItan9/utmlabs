package org.labs.labthree.services;

import org.labs.labthree.SupportingTools.DateFormat;
import org.labs.labthree.services.FileServices.FileService;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//GitFileTracker наследуется от абстрактного класса GitTracker.
//Это означает, что GitFileTracker наследует все защищённые
// и публичные свойства и методы класса GitTracker.
//Наследование позволяет GitFileTracker использовать метод
// getListOfFiles из GitTracker для получения списка файлов в заданной директории.
public class GitFileTracker extends GitTracker {

    private List<String> changeMessages = new ArrayList<>(); //Хранит сообщения о статусе изменений файлов.

    private long snapshotTime = System.currentTimeMillis(); //Хранит время создания снимка.

    private final Map<String, Long> fileLastModifiedMap = new HashMap<>(); //Сопоставляет имена файлов с временем их последнего изменения.


    public GitFileTracker(String folderPath) {
        super(folderPath);
    } //Инициализирует GitTracker с указанным путём к папке.

    @Override
    //Сканирует директорию и сравнивает файлы с последним снимком.
    public void scanDirectory() {
        File[] listOfFiles = getListOfFiles();
        if (listOfFiles == null) return;

    //Создаёт список сообщений о статусе изменений файлов.
        changeMessages = new ArrayList<>();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                long lastModified = file.lastModified();
                if (fileLastModifiedMap.containsKey(file.getName())) {
                    if (fileLastModifiedMap.get(file.getName()) != lastModified) {
                        changeMessages.add(file.getName() + " - Changed");
                    } else {
                        changeMessages.add(file.getName() + " - No Change");
                    }
                } else {
                    changeMessages.add(file.getName() + " - Added");
                }
            }
        }

        for (String fileName : new HashMap<>(fileLastModifiedMap).keySet()) {
            File file = new File(folderPath + "/" + fileName);
            if (!file.exists()) {
                changeMessages.add(fileName + " - Deleted");
            }
        }
    }

    //Сохраняет текущее состояние файлов, обновляя fileLastModifiedMap и snapshotTime.
    public void commit() {
        File[] listOfFiles = getListOfFiles();
        if (listOfFiles == null) return;

        for (File file : listOfFiles) {
            if (file.isFile()) {
                long lastModified = file.lastModified();
                fileLastModifiedMap.put(file.getName(), lastModified);
            }
        }

        snapshotTime = System.currentTimeMillis();
        System.out.println("Created Snapshot at: " + DateFormat.formatDate(snapshotTime));
    }

    //Принимает имя файла и использует FileService для отображения информации об этом файле.
    public void info(String fileName) {
        var fileService = new FileService(folderPath);
        fileService.info(fileName);
    }

    //Показывает статус изменений с момента последнего коммита.
    public void status() {
        if (fileLastModifiedMap.isEmpty()) {
            System.out.println("There are no any snapshots. You have to execute command commit.");
            return;
        }


        //полиморфизм проявляется в переопределении абстрактного метода scanDirectory
        scanDirectory();

        System.out.println("Created Snapshot at: " + DateFormat.formatDate(snapshotTime));
        for (String message : changeMessages) {
            System.out.println(message);
        }
    }

}
