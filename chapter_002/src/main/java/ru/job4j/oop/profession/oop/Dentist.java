package ru.job4j.oop.profession.oop;

public class Dentist extends Doctor {

    public Dentist(String name, String surname, String education, String birthday, String academicDegree) {
        super(name, surname, education, birthday, academicDegree);
    }

    public void toTreatTeeth(Patient patient) {
        System.out.printf("Dentist $s to treat teeth $s", this.getName(), patient.getName());
    }
}
