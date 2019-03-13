package ru.job4j.tracker;

public class Tracker {

    public Item[] items = new Item[10];//массив заявок

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.items[0] = new Item("name", "desc", 01);
        tracker.items[1] = new Task("name", "desc");
        tracker.items[2] = new Bug();

        for (Item item: tracker.items) {
            if (item instanceof Task) {
                System.out.println(((Task) item).calculatePrice());
            }
            System.out.println(item.getName() + " " + item.getDescription() + " " + item.getCreate());
        }
    }
}
