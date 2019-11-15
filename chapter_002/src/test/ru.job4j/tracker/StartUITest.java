package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private static Input input;
    private static Tracker tracker;


    @Test
    public void whenAddItem() {
        String[] answers = {"0", "Fix PC","desc Fix PC"};
        input = new StubInput(answers);
        tracker = new Tracker();
        StartUI.init(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC", "desc Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }
}
