package org.labs.labthree.Files;

public class Dachshund {
    private String name;
    private int age;
    private String color;
    private double weight;

    public Dachshund(String name, int age, String color, double weight) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;
    }

    // Method to make the Dachshund bark
    public void bark() {
        System.out.println(name + " the Dachshund is barking!");
    }

    // Method to display Dachshund's information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " years");
        System.out.println("Color: " + color);
        System.out.println("Weight: " + weight + " kg");
    }

    // Getters and setters for Dachshund's properties
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

