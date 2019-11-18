package ru.job4j.tracker.controller;

import ru.job4j.tracker.Item;

public class UtilsAction {
    static void showItems(Item[] items) {
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
