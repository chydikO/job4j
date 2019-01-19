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
    /**
     * Test Add
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculate calc = new Calculate();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test Div
     */
    @Test
    public void whenDiv2On2Then1() {
        Calculate calc = new Calculate();
        calc.div(2D, 2D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test Multiple
     */
    @Test
    public void whenMultiple2To2Then4() {
        Calculate calc = new Calculate();
        calc.multiple( 2D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat( result, is(expected));
    }

    /**
     * Test Subtract
     */
    @Test
    public void when4subtract2Then2() {
        Calculate calc = new Calculate();
        calc.subtract( 4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat( result, is(expected));
    }
}