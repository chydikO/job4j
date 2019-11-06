package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private String fio;
    private String group;
    private String receiptDate;

    public Student() {
    }

    public Student(String fio, String group, String receiptDate) {
        this.fio = fio;
        this.group = group;
        this.receiptDate = receiptDate;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getFio() {
        return fio;
    }

    public String getGroup() {
        return group;
    }

    public String getReceiptDate() {
        return receiptDate;
    }
}
