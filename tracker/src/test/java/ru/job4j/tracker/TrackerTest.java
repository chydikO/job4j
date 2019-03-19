package ru.job4j.tracker;


import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1","testDescription",created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        Item itemRecord1 = new Item("itemRecord1","testItemRecord#1#Description",456L);
        Item itemRecord2 = new Item("itemRecord2","testItemRecord#2#Description",789L);
        Item itemRecord3 = new Item("itemRecord3","testItemRecord#3#Description",1789L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        tracker.add(itemRecord1);
        tracker.add(itemRecord2);
        tracker.add(itemRecord3);
        // Создаем новую заявку.
        Item next = new Item("test2","testDescription2",1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * тест на удаление записи из списка задач
     */
    @Test
    public void whenDeleteRecordById() {
        Tracker tracker = new Tracker();
        Item itemRecord0 = new Item("itemRecord0","testItemRecord#0#Description",123L);
        Item itemRecord1 = new Item("itemRecord1","testItemRecord#1#Description",456L);
        Item itemRecord2 = new Item("itemRecord2","testItemRecord#2#Description",789L);
        Item itemRecord3 = new Item("itemRecord3","testItemRecord#3#Description",1789L);
        Item itemRecord4 = new Item("itemRecord4","testItemRecord#4#Description",13789L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(itemRecord0);
        tracker.add(itemRecord1);
        tracker.add(itemRecord2);
        tracker.add(itemRecord3);
        tracker.add(itemRecord4);

        //удаляем запись с индексом 2
        tracker.delete(itemRecord2.getId());
        Item[] items = tracker.getAllItems();

        assertThat(items[2].getName(), is("itemRecord3"));
    }

    /**
     * тест на полученную копию массива this.items без null элементов
     */
    @Test
    public void whenFindAllRecordThenArrayOfItems() {
        Tracker tracker = new Tracker();
        Item itemRecordNull = new Item();
        Item itemRecord0 = new Item("test1","testDescription",123L);
        Item itemRecord1 = new Item("itemRecord1","testItemRecord#1#Description",456L);
        Item itemRecord2 = new Item("itemRecord2","testItemRecord#2#Description",789L);
        Item itemRecord3 = new Item("itemRecord3","testItemRecord#3#Description",1789L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(itemRecord0);
        tracker.add(itemRecord1);
        tracker.add(itemRecord2);
        tracker.add(itemRecord3);
        Item[] result = tracker.findAll();

        Item[] matcher = {
                            new Item("test1","testDescription",123L),
                            new Item("itemRecord1","testItemRecord#1#Description",456L),
                            new Item("itemRecord2","testItemRecord#2#Description",789L),
                            new Item("itemRecord3","testItemRecord#3#Description",1789L)
                            };
        matcher[0].setId(itemRecord0.getId());
        matcher[1].setId(itemRecord1.getId());
        matcher[2].setId(itemRecord2.getId());
        matcher[3].setId(itemRecord3.getId());

        assertThat(result, is(matcher));
    }

    /**
     * тест на получения массива с одинаковым Name
     */
    @Test
    public void whenFindByNameThenArrayOfItemsWithName() {
        Tracker tracker = new Tracker();
        Item itemRecordNull = new Item();
        Item itemRecord0 = new Item("test1","testDescription",123L);
        Item itemRecord1 = new Item("itemRecord1","testItemRecord#1#Description",456L);
        Item itemRecord2 = new Item("itemRecord1","testItemRecord#2#Description",789L);
        Item itemRecord3 = new Item("itemRecord3","testItemRecord#3#Description",1789L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(itemRecord0);
        tracker.add(itemRecordNull);
        tracker.add(itemRecord1);
        tracker.add(itemRecordNull);
        tracker.add(itemRecord2);
        tracker.add(itemRecordNull);
        tracker.add(itemRecord3);
        tracker.add(itemRecordNull);
        Item[] result = tracker.findByName("itemRecord1");

        Item[] matcher = {
                new Item("itemRecord1","testItemRecord#1#Description",456L),
                new Item("itemRecord1","testItemRecord#2#Description",789L),
        };
        matcher[0].setId(itemRecord1.getId());
        matcher[1].setId(itemRecord2.getId());
        assertThat(result, is(matcher));
    }
}