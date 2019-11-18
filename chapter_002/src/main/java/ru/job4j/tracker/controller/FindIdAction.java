package ru.job4j.tracker.controller;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class FindIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите ID заявки :");
        Item result = tracker.findById(id);
        if (result != null) {
            System.out.println("---request with ID : " + result.getId() + " found " + "---");
        } else {
            System.out.println("---request with ID : " + id + " not found " + "---");
        }
        return true;
    }
}
