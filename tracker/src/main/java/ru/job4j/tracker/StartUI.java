package ru.job4j.tracker;

import com.sun.xml.internal.bind.v2.TODO;

public class StartUI {

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для показа всех заявок.
     */
    private static final String SHOW = "1";

    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для поиска заявки по id.
     */
    private static final String FIND_ID = "4";

    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final String FIND_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.show();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_ID.equals(answer)) {
                this.findID();
            } else if (FIND_NAME.equals(answer)) {
                this.findName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }


    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует показ всех заявок.
     */
    private void show() {
        System.out.println("------------ Актуальные заявки --------------");
        Item items[] = tracker.findAll();
        for(Item item: items) {
            System.out.println(item);
        }
    }

    /**
     * Метод реализует редактирование заявки в хранилище.
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует удаление заявки из хранилища.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ID заявки :");
        //TODO найти по id заявку , вывести ее на экран, спросить у пользователя - удалить?
        if (this.tracker.delete(id)) {
            System.out.println("------------ заявка с Id : " + id + " удалена -----------");
        } else {
            System.out.println("Нет заявки с ID - " + id + " удаление не возможно");
        }
    }

    /**
     * Метод реализует поиск заявки из хранилища по ID.
     */
    private void findID() {
        System.out.println("------------ Поиск заявки из хранилища по ID --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует поиск заявки из хранилища по Name.
     */
    private void findName() {
        System.out.println("------------ Поиск заявки из хранилища по Name. --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showMenu() {
        System.out.println("Меню.");
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

    public void init2() {
        ConsoleInput consoleInput = new ConsoleInput();
        String name = consoleInput.ask("Kak dela?");

        Tracker tracker = new Tracker();
        tracker.add(new Item(name, "description", 123));
        for (Item item: tracker.getAllItems()) {
            System.out.println(item);
        }
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {

         new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
