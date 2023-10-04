package org.labs.labtwo.models;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private String abbreviation;
    private StudyField field;
    private List<Student> enrolledStudents = new ArrayList();
    private List<Student> graduatedStudents = new ArrayList();

    public Faculty(String name, String abbreviation, StudyField studyField) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.field = studyField;
    }

    public void addStudent(Student student) {
        this.enrolledStudents.add(student);
    }

    public void graduateStudent(Student student) {
        this.enrolledStudents.remove(student);
        this.graduatedStudents.add(student);
    }

    public List<Student> getEnrolledStudents() {
        return this.enrolledStudents;
    }

    public List<Student> getGraduatedStudents() {
        return this.graduatedStudents;
    }

    public boolean containsStudent(Student student) {
        return this.enrolledStudents.contains(student);
    }

    public String getName() {
        return this.name;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public StudyField getField() {
        return this.field;
    }

    public void setField(StudyField field) {
        this.field = field;
    }
}
