package ru.job4j.calculate;

/**
 * Calculate
 * @author Oleg Chudnovskij (oleg.chudnovskiy@gmail.com)
 *  
 */

public class Calculate {

    /**
     * Method Echo
     * @param value - input string for string format
     * @return string with format
     */
    public String Echo(String value) {
        return String.format("%s %s %s", value, value, value);
    }
    
    /**
     * Main.
     * @param args - input args for calculate
     */
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        System.out.println(calculate.Echo("Hi"));
    }
}