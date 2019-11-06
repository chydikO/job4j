package ru.job4j.oop.profession.oop;

import java.util.regex.Pattern;

public class Surgeon extends Doctor {


    public Surgeon(String name, String surname, String education, String birthday, String academicDegree) {
        super(name, surname, education, birthday, academicDegree);
    }

    public void doSurgery(Patient patient) {
        System.out.format("Surgeon $s do Surgery patient $s",  this.getName(),patient.getName());
    }
}
