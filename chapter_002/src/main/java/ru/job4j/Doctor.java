package ru.job4j;

public class Doctor extends Profession{
    Patient patient;

    public String diagnoseOfPAtient(Patient patient) {
        return patient.diagnose;
    }
}
