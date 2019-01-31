package ru.job4j.calculate;

/**
 * Calculate
 * @author Oleg Chudnovskij (oleg.chudnovskiy@gmail.com)
 * @version $Id$
 * @since 0.1
 */

class Calculate {
    private double result;

    /**
     * Add
     * @param first number
     * @param second number
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Subtract
     * @param first number
     * @param second number
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Div
     * @param first number
     * @param second number
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Multiple
     * @param first number
     * @param second number
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Get Result
     * @return result calculate after operation
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Main
     * @param args input arguments
     */
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        calculate.add( 10d, 15d);
        System.out.println(calculate.result);
    }
}