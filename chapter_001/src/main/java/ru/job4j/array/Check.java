package ru.job4j.array;

public class Check {

    /**
     * mom array check
     * @param data - input array
     * @return true or false
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        boolean tmp = data[0];

        for (int i = 1; i < data.length; i++) {
            if (data[i] == tmp) {
                result = true;
            } else {
                result = false;
                break;
            }
        }

        return result;
    }
}
