package ru.job4j.tracker.controller;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import static ru.job4j.tracker.controller.UtilsAction.showItems;

public class FindNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя заявки :");
        Item[] result = tracker.findByName(name);
        if (result.length > 0) {
            System.out.println("--- Application (s) with the name : " + name + "---");
            showItems(result);
        } else {
            System.out.println("--- Application (s) with the name : " + name + "  not found " + "---");
        }
        return true;
    }
}
