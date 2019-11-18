package ru.job4j.tracker.controller;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "=== Application editing ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Input ID request : ");
        String desc = input.askStr("Enter a new application description :");
        Item item = new Item(id, desc);
        if (tracker.replace(id, item)) {
            System.out.println("------------ request with ID : " + item.getId() + " editing -----------");
        } else {
            System.out.println("------------ request with ID : " + item.getId() + " NOT editing -----------");
        }
        return true;
    }
}
