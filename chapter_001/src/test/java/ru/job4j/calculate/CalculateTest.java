package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * CalculateTest
 * @author Oleg Chudnovskij (oleg.chudnovskiy@gmail.com)
 *  
 */

public class CalculateTest {

    @Test
    public void whenSetStopInEchoThenReturnThreeStops() {
        Calculate calc = new Calculate();
        String result = calc.Echo("stop");
        assertThat(result, is("stop stop stop"));
    }

    @Test
    public void whenSetNullInEchoThenReturnTwoSpaces() {
        Calculate calc = new Calculate();
        String result = calc.Echo(null);
        assertThat(result, is("null null null"));
    }

}