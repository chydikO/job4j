package ru.job4j.oop.profession.oop;

public class Patient extends Profession {
    private String diagnose;

    public Patient(String name, String surname, String education, String birthday, String diagnose) {
        super( name,  surname,  education, birthday);
        this.diagnose = diagnose;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }
}
