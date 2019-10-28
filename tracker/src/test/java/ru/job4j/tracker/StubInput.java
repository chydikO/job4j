package ru.job4j.tracker;

public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. Если пользователь
     * хочет выбрать добавление новой заявки ему нужно ввести:
     * 0 - выбор пункта меню "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * y - выйти из трекера.
     */
    private final String[] value;

    /**
     * Поле считает количество вызовов метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;

    /**
     * Конструктор.
     *
     * @param aValue массив ответов пользователя.
     */
    public StubInput(final String[] aValue) {
        this.value = aValue;
    }

    @Override
    public final String ask(final String question) {
        return this.value[this.position++];
    }
}
