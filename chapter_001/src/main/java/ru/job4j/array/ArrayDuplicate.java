package ru.job4j.array;

import java.util.Arrays;

class ArrayDuplicate {

    /**
     * remove Duplicate from Array Of Strings
     * @param array - input array
     * @return new array without duplicate
     */
    public String[] remove(String[] array) {

        String tmp;
        int newSizeArray = array.length;

        for (int i = 0; i < newSizeArray; i++) {
            for (int j = i + 1; j < newSizeArray; j++) {
                if (array[i].equals(array[j])) {
                    tmp = array[j];
                    array[j] = array[newSizeArray - 1];
                    array[newSizeArray - 1] = tmp;
                    newSizeArray--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, newSizeArray);
    }
}
