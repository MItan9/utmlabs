package org.labs.labtwo.models;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class University {
    private List<Faculty> faculties = new ArrayList();

    public University() {
    }

    public void createFaculty(String name, String abbreviation, String field) {
        if (!StudyField.isValidField(field)) {
            System.out.println("Invalid field. Available fields: MECHANICAL_ENGINEERING, SOFTWARE_SYSTEMS_ENGINEERING, FOOD_TECHNOLOGY, URBANISM_ARCHITECTURE, VETERINARY_MEDICINE");
        } else {
            StudyField studyField = StudyField.valueOf(field);
            Faculty faculty = new Faculty(name, abbreviation, studyField);
            this.faculties.add(faculty);
        }
    }

    public Faculty findFacultyByStudentEmail(String studentEmail) {
        Iterator var2 = this.faculties.iterator();

        while (var2.hasNext()) {
            Faculty faculty = (Faculty) var2.next();
            Iterator var4 = faculty.getEnrolledStudents().iterator();

            while (var4.hasNext()) {
                Student student = (Student) var4.next();
                if (student.getEmail().equals(studentEmail)) {
                    return faculty;
                }
            }
        }

        return null;
    }

    public void displayFaculties() {
        System.out.println("org.labs.labtwo.models.Faculty list in the university:");
        Iterator var1 = this.faculties.iterator();

        while (var1.hasNext()) {
            Faculty faculty = (Faculty) var1.next();
            PrintStream var10000 = System.out;
            String var10001 = faculty.getAbbreviation();
            var10000.println(var10001 + " - " + faculty.getName());
        }

    }

    public void displayFacultiesByField(String field) {
        System.out.println("Faculties in the field of " + field + ":");
        Iterator var2 = this.faculties.iterator();
        try {
            StudyField studyField = StudyField.valueOf(field);

            while (var2.hasNext()) {
                Faculty faculty = (Faculty) var2.next();

                var fieldCurrent = faculty.getField();

                if (fieldCurrent.equals(studyField)) {
                    PrintStream var10000 = System.out;
                    String var10001 = faculty.getAbbreviation();
                    var10000.println(var10001 + " - " + faculty.getName());
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect Field Type");
        }

    }

    public List<Faculty> getFaculties() {
        return this.faculties;
    }

    public Faculty findFacultyByAbbreviation(String abbreviation) {
        Iterator var2 = this.faculties.iterator();

        Faculty faculty;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            faculty = (Faculty) var2.next();
        } while (!faculty.getAbbreviation().equals(abbreviation));

        return faculty;
    }

    public Student findStudentByEmail(String email) {
        Iterator var2 = this.faculties.iterator();

        while (var2.hasNext()) {
            Faculty faculty = (Faculty) var2.next();
            Iterator var4 = faculty.getEnrolledStudents().iterator();

            while (var4.hasNext()) {
                Student student = (Student) var4.next();
                if (student.getEmail().equals(email)) {
                    return student;
                }
            }
        }

        return null;
    }
}
