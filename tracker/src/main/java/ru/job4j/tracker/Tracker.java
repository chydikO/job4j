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

import java.util.ArrayList;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private Item[] items = new Item[100];

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
     * Метод public Item findById(String id) проверяет в цикле все элементы массива this.items,
     * сравнивая id с аргументом String id и возвращает найденный Item.
     * Если Item не найден - возвращает null.
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
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                this.items[i] = item;
                result = true;
            }
        }
        return result;//надо написать
    }

    /**
     * Метод public boolean delete(String id) должен удалить ячейку в массиве this.items.
     * Для этого необходимо найти ячейку в массиве по id.  Далее сместить все значения справа от
     * удаляемого элемента - на одну ячейку влево с помощью System.arrayCopy().
     * Метод должен вернуть boolean результат - удалось ли провести операцию.
     * @param id
     * @return
     */
    public boolean delete(String id) {
        boolean result = false;

        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && id.equals(this.items[i].getId())) {
                //если нашли запись по id для удалениея - удалили запись, сдвинули массив
                this.items[i] = null;
                swapElementsAfterDel(i);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * сдвиг массива влево,смещает все значения справа от
     * удаляемого элемента - на одну ячейку влево
     * @param positionOfDel - позиция удаления элемента
     */
    private void swapElementsAfterDel(int positionOfDel) {
        Item tmpItems;

            for (int i = positionOfDel; i < this.position; i++) {
                tmpItems = this.items[i];
                this.items[i] = this.items[i+1];
                this.items[i+1] = tmpItems;
            }
            position--;
            System.arraycopy(items, 0, items, 0, position);
    }

    /**
     * Метод public Item[] findAll() возвращает копию массива this.items без null элементов;
     * @return
     */
    public Item[] findAll() {
        ArrayList<Item> arrayList = new ArrayList<>();
        for(Item item: this.items) {
            if (item != null && item.getName() != null) {
                arrayList.add(item);
            }
        }
        return arrayList.toArray(new Item[0]);
    }

    /**
     * Метод public Item[] findByName(String key) проверяет в цикле все элементы массива this.items,
     * сравнивая name (используя метод getName класса Item) с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его;
     * @param key
     * @return
     */
    public Item[] findByName(String key) {
        ArrayList<Item> arrayList = new ArrayList<>();
        for (Item item : this.items) {
            if (item != null && key.equals(item.getName())) {
                arrayList.add(item);
            }
        }
        return arrayList.toArray(new Item[0]);
    }

    /**
     * вывод в консоль всех объектов списка задач
     */
    public void printTrackerItems() {
        for (Item item: items) {
            System.out.println(item);
        }
    }

    /**
     * Getter списка задач
     * @return
     */
    public Item[] getAllItems() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }
}
