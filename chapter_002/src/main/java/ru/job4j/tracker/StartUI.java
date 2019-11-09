package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    private static final Scanner scanner = new Scanner(System.in);
    private static Tracker tracker;

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            if (MenuItems.ADD.getId() == select) {
                createItem();
            } else if (MenuItems.SHOW.getId() == select) {
                show();
            } else if (MenuItems.EDIT.getId() == select) {
                editItem();
            } else if (MenuItems.DELETE.getId() == select) {
                deleteItem();
            } else if (MenuItems.FIND_ID.getId() == select) {
                findID();
            } else if (MenuItems.FIND_NAME.getId() == select) {
                findName();
            } else if (MenuItems.EXIT.getId() == select) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        // добавить остальные пункты меню.
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select:");
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private static void createItem() {
        System.out.println("=== Create a new Item ====");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter application description :");
        String desc = scanner.nextLine();
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("------------ New request getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует показ всех заявок.
     */
    private void show() {
        System.out.println("------------ Actual applications --------------");
        Item items[] = tracker.findAll();
        showItems(items);
    }

    /**
     * Метод реализует редактирование заявки в хранилище.
     */
    private static void editItem() {
        //TODO необходимо найти заявку по имени или id, показать ее, если это она, редактировать - добавить новую,
        // текущюю удалить. А если заявок с именем много, какую редактировать?
        System.out.println("=== Application editing ===");
        System.out.println("Input ID request : ");
        String id = scanner.nextLine();
        System.out.println("Enter a new application description :");
        String desc = scanner.nextLine();
        Item item = new Item(id, desc);
        if(tracker.replace( id, item)) {
            System.out.println("------------ request with ID : " + item.getId() + " editing -----------");
        } else {
            System.out.println("------------ request with ID : " + item.getId() + " NOT editing -----------");
        }
    }

    /**
     * Метод реализует удаление заявки из хранилища.
     */
    private static void deleteItem() {
        System.out.println("=== Delete application ===");
        System.out.println("Введите ID заявки :");
        String id = scanner.nextLine();
        //TODO найти по id заявку , вывести ее на экран, спросить у пользователя - удалить?
        if (tracker.delete(id)) {
            System.out.println("--- application with Id : " + id + " deleted ---");
        } else {
            System.out.println("--- application with ID: " + id + "  does not exist ---");
        }
    }

    /**
     * Метод реализует поиск заявки из хранилища по ID.
     */
    private static void findID() {
        System.out.println("=== Search application by ID ===");
        System.out.println("Введите ID заявки :");
        String id = scanner.nextLine();
        Item result = tracker.findById(id);
        if (result != null) {
            System.out.println("---request with ID : " + result.getId() + " found " + "---");
        } else {
            System.out.println("---request with ID : " + id + " not found " + "---");
        }
    }

    /**
     * Метод реализует поиск заявки из хранилища по Name.
     */
    private static void findName() {
        System.out.println("------------ Поиск заявки из хранилища по Name. --------------");
        System.out.println("Введите имя заявки :");
        String name = scanner.nextLine();
        Item[] result = tracker.findByName(name);
        if (result.length > 0) {
            System.out.println("--- Application (s) with the name : " + name + "---");
            showItems(result);
        } else {
            System.out.println("--- Application (s) with the name : " + name + "  not found " + "---");
        }
    }

    /**
     * вывод массива items в консоль
     * @param items
     */
    private static void showItems(Item[] items) {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {

        tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
