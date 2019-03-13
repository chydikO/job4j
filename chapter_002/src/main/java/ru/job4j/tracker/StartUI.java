package ru.job4j.tracker;

public class StartUI {


    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Task("First task", "first desc"));

        for (Item item: tracker.getAll()) {
            System.out.println(item.getName() + " " + item.getId());
        }

        System.out.println();
    }
}
