package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.controller.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.theInstance;

public class ValidateInputTest {

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
    public void whenInvalidInput() {

        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.askInt("Enter", 1);
        assertThat(
                out.toString(),
                is(String.format("Please enter validate data again.%n"))
        );
    }
}
