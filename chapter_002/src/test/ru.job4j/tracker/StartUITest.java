package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.controller.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

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

    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static final String LS = System.lineSeparator();
    private static StringJoiner menu;

    @Before
    public void loadOutput() {
        out.reset();
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));

        initMenuItem();
    }

    private void initMenuItem() {
        menu = new StringJoiner(LS);
        menu.add("Menu.");
        menu.add("0. === Add new Item ====");
        menu.add("1. === Show all items ===");
        menu.add("2. === Edit item ===");
        menu.add("3. === Update item ====");
        menu.add("4. === Delete item ===");
        menu.add("5. === Find item by Id ===");
        menu.add("6. === Find items by name ===");
        menu.add("7. === Exit Program ===");
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

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
        Item expected = new Item("Fix PC", "desc Fix PC");

        assertThat(
                    out.toString(),
                    is(
                        new StringBuilder()
                                .append(menu.toString() + LS)
                                .append("------------ New request with name : " + expected.getName() + " is open -----------" + LS)
                                .append(menu.toString() + LS)
                                .toString()
                    ));

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
        assertThat(
                out.toString(),
                is(
                        new StringBuilder()
                                .append(menu.toString() + LS)
                                .append("--- Application (s) with the name : " + replaced.getName() + " replaced ---" + LS)
                                .append(menu.toString() + LS)
                                .toString()
                ));
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
        assertThat(
                out.toString(),
                is(
                        new StringBuilder()
                                .append(menu.toString() + LS)
                                .append("--- application with Id : " + item.getId() + " deleted ---" + LS)
                                .append(menu.toString() + LS)
                                .toString()
                ));
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

        assertThat(
                out.toString(),
                is(
                        new StringBuilder()
                                .append(menu.toString() + LS)
                                .append("---request with ID : " + item.getId() + " found " + "---" + LS)
                                .append(menu.toString() + LS)
                                .toString()
                ));
    }

    @Test
    public void whenFindName() {
        Tracker tracker = new Tracker();

        Item item = new Item("new item for delete", "new item desc", 123L);
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
        Item[] items = tracker.getItems();
        item.setId(items[0].getId());


        Item find = tracker.findById(item.getId());
        assertThat(
                out.toString(),
                is(
                        new StringBuilder()
                                .append(menu.toString() + LS)
                                .append("--- Application (s) with the name : " + item.getName() + "---" + LS)
                                .append("Item id- " + item.getId() + " Name- " + item.getName() + " Desc- " + item.getDecs()
                                        + " time- " + item.getTime() + LS)
                                .append(menu.toString() + LS)
                                .toString()
                ));
    }

}
