package ru.job4j.tracker.strategy;
import org.junit.Test;
import ru.job4j.stragery.Square;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("++++\n")
                                .append("+     +\n")
                                .append("+     +\n")
                                .append("++++\n")
                                .toString()
                )
        );
    }
}
