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
        
        for(int i=0; i < arrayLength; i++){
            for(int j=1; j < (arrayLength-i); j++){
                if(array[j-1] > array[j]){
                    this.swapElementsInArray(array, j);
                }
            }
        }
        return array;
    }

    /**
     * swapElementsInArray
     * @param inputArray
     * @param index - number element of array for swap between index and index-1
     */
    private void swapElementsInArray( int[] inputArray, int index ) {

        inputArray[index-1] = inputArray[index-1] ^ inputArray[index];
        inputArray[index] = inputArray[index-1] ^ inputArray[index];
        inputArray[index-1] = inputArray[index-1] ^ inputArray[index];
    }
}
