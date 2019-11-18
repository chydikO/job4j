package ru.job4j.tracker;

public class CreateAction implements UserAction{
    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        String desc = input.askStr("Enter application description :");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("------------ New request getId : " + item.getId() + "-----------");
        return true;
    }
}