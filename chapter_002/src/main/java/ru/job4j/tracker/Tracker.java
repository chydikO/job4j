package ru.job4j.tracker;

import java.util.Random;

public class Tracker {

    private Item[] items = new Item[10];//массив заявок
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item){
        item.setId(this.generateID());
        this.items[this.position++] = item;
        return item;
    }

    protected Item findByID(String id) {
        Item result = null;
        for (Item item: items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    String generateID() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position ; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

}
