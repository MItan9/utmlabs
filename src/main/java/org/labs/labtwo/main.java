package org.labs.labtwo;

import org.labs.labtwo.behavior.ApplicationLoop;
import org.labs.labtwo.models.University;

public class main {

    public static void main(String[] args) {
        University university = new University();
        ApplicationLoop applicationLoop = new ApplicationLoop(university);
        applicationLoop.start();
    }
}