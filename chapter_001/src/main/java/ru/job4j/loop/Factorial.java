package ru.job4j.loop;

/**
 * @author Oleg Chudnovskij (oleg.chudnovskiy@gmail.com)
 * @version $Id$
 * @since 0.1
 */

class Factorial {

    public int calc(int n) {
        int factorialResult = 1;

        for (int i = 1; i <= n; i++) {
            factorialResult = factorialResult * i;
        }
        return factorialResult;
    }
}
