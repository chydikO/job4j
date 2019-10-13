package ru.job4j.professions;

public class Student  extends Profession {
    private String group;

    public Student(String name, String profession, String group) {
        super(name, profession);
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}