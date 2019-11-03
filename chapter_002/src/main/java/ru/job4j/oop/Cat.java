package ru.job4j.oop;

public class Cat {

    private String name;
    private String food;

    public void show() {
        System.out.println("Cat name -> " + this.name + ", food -> " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public String sound() {
        String voice = "may-may";
        return voice;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }
    public static void main(String[] args) {
        Cat peppy = new Cat();
        String say = peppy.sound();
        System.out.println("Peppy says " + say);
    }
}
