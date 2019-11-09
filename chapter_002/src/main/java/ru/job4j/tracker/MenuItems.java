package ru.job4j.tracker;

public enum MenuItems {
     ADD(0),
    SHOW(1),
    EDIT(2),
    DELETE(3),
    FIND_ID(4),
    FIND_NAME(5),
    EXIT(6);

     private int id;

    MenuItems(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
