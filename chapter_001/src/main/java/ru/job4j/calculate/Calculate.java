package ru.job4j.calculate;

/**
 * Calculate
 * @author Oleg Chudnovskij (oleg.chudnovskiy@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Calculate {
    private double result;

    /**
     * Add
     * @param first
     * @param second
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Subtract
     * @param first
     * @param second
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Div
     * @param first
     * @param second
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Multiple
     * @param first
     * @param second
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Get Result
     * @return result
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {

    }
}