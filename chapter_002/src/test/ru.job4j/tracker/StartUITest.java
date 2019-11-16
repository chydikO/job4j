package ru.job4j.tracker;

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
}
