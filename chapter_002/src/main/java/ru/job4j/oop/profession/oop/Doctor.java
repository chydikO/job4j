package ru.job4j.oop.profession.oop;

public class Doctor extends Profession {
    private String academicDegree;

    public Doctor(String name, String surname, String education, String birthday, String academicDegree) {
        super(name, surname, education, birthday);
        this.academicDegree = academicDegree;
    }

    public Diagnose heal(Patient patient) {
        Diagnose check = new Diagnose();
        return check.diagnoseOf(patient);
    }
}
