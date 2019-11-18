package ru.job4j.tracker.controller;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Update item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id:");
        String name = input.askStr("Enter a new name of item: ");
        Item itemReplace = tracker.findById(id);
        if (itemReplace != null) {
            Item item = new Item(name, itemReplace.getDecs());
            item.setId(id);
            tracker.replace(id, item);
            System.out.println("--- Application (s) with the name : " + name + " *replaced ---");
        } else {
            System.out.println("--- Application (s) with the name : " + name + "  not found " + "---");
        }
        return true;
    }
}
