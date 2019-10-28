package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    /*@Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] { action });
        assertThat(action.isCall(), is(true));
    }*/


    @Test
    public void whenAddNewItem() {
        Tracker tracker = new Tracker();
        Item item = new Item( "item_1", "description item_1", 12345L);
        String[] answers = {};
    }

    @Test
    public void whenShowAllItems() {

    }

    @Test
    public void whenEditItem() {

    }

    @Test
    public void whenDeleteItem() {

    }

    @Test
    public void whenFindItemById() {

    }

    @Test
    public void whenFindItemsByName() {

    }

    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"6"}
        );
        StubAction action = new StubAction();
        new StartUI(input, new Tracker()).init();
        action.execute(input, new Tracker());
        assertThat(action.isCall(), is(true));
    }
}
