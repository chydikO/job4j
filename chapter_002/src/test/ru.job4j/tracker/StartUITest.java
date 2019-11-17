package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private Input input;
    private Tracker tracker;


    @Test
    public void whenAddItem() {
        String[] answers = {"0", "Fix PC","desc Fix PC", "6"};
        input = new StubInput(answers);
        tracker = new Tracker();
        new StartUI(input, tracker).init();
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC", "desc Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item", "new item desc");
        tracker.add(item);
        String[] answers = {
                item.getId(), // id сохраненной заявки в объект tracker.
                "replaced item"
        };
        StartUI.replaceItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item for delete", "new item desc");
        Item itemRecord0 = new Item("itemRecord0","testItemRecord#0#Description",123L);
        Item itemRecord1 = new Item("itemRecord1","testItemRecord#1#Description",456L);
        Item itemRecord2 = new Item("itemRecord2","testItemRecord#2#Description",789L);

        tracker.add(item);
        tracker.add(itemRecord0);
        tracker.add(itemRecord1);
        tracker.add(itemRecord2);

        Item[] items = tracker.findAll();
        assertThat(items[0].getName(), Matchers.is(item.getName()));

        String[] answers = { "3", item.getId(), "6"};
        new StartUI(new StubInput(answers), tracker).init();

        items = tracker.findAll();
        assertThat(items[0].getName(), Matchers.is(itemRecord0.getName()));

    }
}
