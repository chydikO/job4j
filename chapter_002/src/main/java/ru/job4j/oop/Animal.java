package ru.job4j.oop;

public class Animal {

    private String name;

    public Animal() {
        System.out.println("Class Animal");
    }

    public Animal(String name) {
        this.name = name;
        System.out.println("Class Animal. Constructor with name");
    }
}
