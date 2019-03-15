package ru.job4j.professions;

public class Doctor extends Profession {
    private Patient patient;

    public Doctor(String name, String profession, Patient patient) {
        super(name, profession);
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String diagnoseOfPatient(Patient patient) {
        return "Diagnose of patient " + patient.getDiagnose();
    }
}
