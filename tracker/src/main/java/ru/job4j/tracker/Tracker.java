package ru.job4j.tracker;
/**
 *
 * добавление заявок - public Item add(Item item);
 * редактирование заявок - public boolean replace(String id, Item item);
 * удаление заявок - public boolean delete(String id);
 * получение списка всех заявок - public Item[] findAll();
 * получение списка по имени - public Item[] findByName(String key);
 * получение заявки по id - public Item findById(String id);
 */

import java.util.Random;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * генерация обьекта Random, для формирования id записи
     */
    private final static Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    /**
     * получение заявки по id
     * @param id
     * @return
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item: items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * редактирование заявок, Метод public boolean replace(String id, Item item) должен заменить ячейку
     * в массиве this.items. Для этого необходимо найти ячейку в массиве по id.
     * Метод должен вернуть boolean результат - удалось ли провести операцию.
     * @param id
     * @param item
     * @return
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        Item tmpItem;
        if ((tmpItem = this.findById(id)) != null) {
            for (int i = 0; i < this.items.length; i++ ) {
                if (this.items[i].equals(tmpItem)) {
                    this.items[i] = item;
                    result = true;
                    break;
                }
            }
        }
        return result;//надо написать
    }
}
