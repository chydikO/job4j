package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Класс ConsoleInput используется для ввода пользовательских данных из консоли;
 */

public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String s) {
        System.out.println(s); //печатаем вопрос у пользователя
        return scanner.nextLine();
    }
}
