package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public ConsoleInput() {

    }

    @Override
    public String ask(String s) {
        System.out.println(s); //печатаем вопрос у пользователя
        return scanner.nextLine();
    }
}
