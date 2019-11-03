package ru.job4j.oop;

import java.nio.Buffer;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery battery1 = new Battery(100);
        Battery battery2 = new Battery(50);
    }
}
