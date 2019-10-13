package ru.job4j.professions;

class Teacher extends Profession {
    private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void studentStudy() {
        System.out.println("student study");
    }
}