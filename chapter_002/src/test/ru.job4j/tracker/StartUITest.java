package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;
import ru.job4j.tracker.controller.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
private static final UserAction[] userAction = {
        new CreateAction(),
        new ShowAllAction(),
        new EditAction(),
        new ReplaceAction(),
        new DeleteAction(),
        new FindIdAction(),
        new FindNameAction(),
        new ExitAction()
};
    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] { action});
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenCreateNewItem() {
        String[] answers = {"0", "Fix PC","desc Fix PC", "7"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();

        new StartUI().init(input, tracker, userAction);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC", "desc Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item", "new item desc");
        tracker.add(item);
        String[] answers = { "3",
                item.getId(), // id сохраненной заявки в объект tracker.
                "replaced item",
                "7"
        };
        new StartUI().init(new StubInput(answers), tracker, userAction);
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

        String[] answers = { "4", item.getId(), "7"};
        new StartUI().init(new StubInput(answers), tracker, userAction);

        items = tracker.findAll();
        assertThat(items[0].getName(), Matchers.is(itemRecord0.getName()));

    }

    @Test
    public void whenFindId() {
        Tracker tracker = new Tracker();

        Item item = new Item("new item for delete", "new item desc");
        Item itemRecord0 = new Item("itemRecord0","testItemRecord#0#Description",123L);
        Item itemRecord1 = new Item("itemRecord1","testItemRecord#1#Description",456L);
        Item itemRecord2 = new Item("itemRecord2","testItemRecord#2#Description",789L);

        tracker.add(item);
        tracker.add(itemRecord0);
        tracker.add(itemRecord1);
        tracker.add(itemRecord2);

        String[] answers = { "5",
                item.getId(), // id сохраненной заявки в объект tracker.
                "7"
        };
        new StartUI().init(new StubInput(answers), tracker, userAction);
        Item find = tracker.findById(item.getId());
        assertThat(find.getId(), is(item.getId()));
    }

    @Test
    public void whenFindName() {
        Tracker tracker = new Tracker();

        Item item = new Item("new item for delete", "new item desc");
        Item itemRecord0 = new Item("itemRecord0","testItemRecord#0#Description",123L);
        Item itemRecord1 = new Item("itemRecord1","testItemRecord#1#Description",456L);
        Item itemRecord2 = new Item("itemRecord2","testItemRecord#2#Description",789L);

        tracker.add(item);
        tracker.add(itemRecord0);
        tracker.add(itemRecord1);
        tracker.add(itemRecord2);

        String[] answers = { "6",
                item.getName(), // id сохраненной заявки в объект tracker.
                "7"
        };
        new StartUI().init(new StubInput(answers), tracker, userAction);
        Item find = tracker.findById(item.getId());
        assertThat(find.getName(), is(item.getName()));
    }

}
