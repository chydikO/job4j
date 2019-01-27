package ru.job4j.array;

class Turn {


    public int[] back(int[] array) {

        int tmp;
        for (int i = 0, j = array.length - 1; j > i ; i++, j--) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
        }
        return array;

    }
}
