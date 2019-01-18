package ru.job4j.calculate;

/**
 * Calculate
 * @author Oleg Chudnovskij (oleg.chudnovskiy@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Calculate {

    /**
     * Method echoClassCalculate.
     * @param name Your name.
     * @return Echo plus your name.
     */
    public String echoClassCalculate(String name) {
        return "Echo, echo, echo : " + name;
    }

    /**
     * Method echo
     * @param value - input string for string format
     * @return string with format
     */
    public String echo(String value) {
        return String.format("%s %s %s", value, value, value);
    }

    /**
     * Main.
     * @param args - input args for calculate
     */
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        System.out.println(calculate.echo("Hi"));
    }
}