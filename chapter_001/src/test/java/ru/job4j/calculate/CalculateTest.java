package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * CalculateTest
 * @author Oleg Chudnovskij (oleg.chudnovskiy@gmail.com)
 * @version $Id$
 * @since 0.1
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

    /**
    * Test echo.
    */
    @Test
    public void whenTakeNameThenThreeEchoPlusName() {
        String input = "Petr Arsentev";
        String expect = "Echo, echo, echo : Petr Arsentev"; 
        Calculate calc = new Calculate();
        String result = calc.echoClassCalculate(input);
        assertThat(result, is(expect));
    }
}