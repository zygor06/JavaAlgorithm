package br.com.hygor.algorithm.sorts;

/**
 * @author Hygor Dias (github.com/zygor06)
 *
 */

public class SelectionSort {

    public static <T extends Comparable<T>> void sort(T[] arr, int n){

        for(int i = 0; i < n; i++){

            int min = i;

            for(int j = i + 1; j < n; j++){
                if(arr[j].compareTo(arr[min]) < 0){
                    min = j;
                }
            }

            if(min != i){
                T temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
