package ru.job4j.pojo;


public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Ivanov Ivan Ivanovich");
        student.setGroup("IT-1239");
        student.setReceiptDate(PojoUtils.getDate());

        System.out.printf("Student FIO: %s, group: %s, date: %s",
                                    student.getFio(), student.getGroup(), student.getReceiptDate());
    }
}
