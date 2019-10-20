package ru.job4j.tracker;

/**
 * Пользовательское действие, возможное при работе с программой Трекер.
 */
public interface UserAction {
    /**
     * Возвращаем ключ для запуска действия.
     * @return ключ
     */
    int key();

    /**
     * Основной метод.
     * @param input получение данных от пользователя
     * @param tracker хранилище заявок
     */
    boolean execute(Input input, Tracker tracker);

    /**
     * Возвращаем информацию о данном пользовательском действии.
     * @return строка меню
     */
    String info();
}
