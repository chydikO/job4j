package ru.job4j;


public class Patient extends Profession{
    private String diagnose;

    public Patient(String name, String profession, String diagnose) {
        super(name, profession);
        this.diagnose = diagnose;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }
}
