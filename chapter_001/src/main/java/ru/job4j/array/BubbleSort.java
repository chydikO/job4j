package ru.job4j.array;

/**
 * Bubble sort class
 */
public class BubbleSort {

    /**
     * Bubble sort the array
     * @param array
     * @return sorted Array
     */
    public int[] sort(int[] array) {

        int arrayLength = array.length;
        int tmp;

        for(int i=0; i < arrayLength; i++){
            for(int j=1; j < (arrayLength-i); j++){
                if(array[j-1] > array[j]){
                    tmp = array[j-1];
                    array[j-1]= array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }
}
