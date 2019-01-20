package ru.job4j.loop;

public class Factorial {

    public int calc(int n) {
        int factorial = 1;
        if ( !(n == 0) || !(n == 1)) {
            for (int i = 2; i <= n; i++) {
                factorial *= i;
            }
        }
        return factorial;
    };
}
