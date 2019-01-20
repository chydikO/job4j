package ru.job4j.max;

/**
 * @author Oleg Chudnovskij (oleg.chudnovskiy@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Max {

    /**
     * Function Max Number
     * @param i number 1
     * @param i1 number 2
     * @return Max Number
     */
    public int max(int i, int i1) {
        return i > i1 ? i : i1;
    }

    /**
     * Function Max Number
     * @param first
     * @param second
     * @param third
     * @return Max Number
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}
