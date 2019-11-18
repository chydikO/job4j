package ru.job4j.tracker.controller;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите ID заявки :");
        //TODO найти по id заявку , вывести ее на экран, спросить у пользователя - удалить?
        if (tracker.delete(id)) {
            System.out.println("--- application with Id : " + id + " deleted ---");
        } else {
            System.out.println("--- application with ID: " + id + "  does not exist ---");
        }
        return true;
    }
}
