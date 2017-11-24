package br.com.hygor.algorithm.sorts;

/**
 * @author Hygor Dias (github.com/zygor06)
 *
 */

public class QuickSort {

    public static <T extends Comparable<T>> void sort(T array[], int start, int end){
        if(start < end){
            int index = partition(array, start, end);
            sort(array, start, index - 1);
            sort(array, index + 1, end);
        }
    }

    public static <T extends Comparable<T>> int partition(T array[], int start, int end){
        T pivot = array[end];
        int index = start;
        for(int i = start; i < end; i++){
            if(array[i].compareTo(pivot) <= 0){
                swap(array, i, index);
                index++;
            }
        }

        swap(array, index, end);
        return index;
    }

    public static <T extends Comparable<T>> void swap(T[] array, int initial, int fin){
        T temp = array[initial];
        array[initial] = array[fin];
        array[fin] = temp;
    }
}
