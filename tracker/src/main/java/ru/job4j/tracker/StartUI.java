package ru.job4j.tracker;

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

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

    public StartUI(ConsoleInput consoleInput, Tracker tracker) {
        this.input = consoleInput;
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
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
//            } else if (...) {
//             Добавить остальные действия системы по меню.
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

    private void showMenu() {
        System.out.println("Меню.");
        // добавить остальные пункты меню.
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

        // new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
