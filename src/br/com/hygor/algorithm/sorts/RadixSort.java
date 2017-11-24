package br.com.hygor.algorithm.sorts;

/**
 * @author Hygor Dias (github.com/zygor06)
 *
 */

public class RadixSort {

    public static <T extends Comparable<T>> T getMax(T array[], int n){

        T max = array[0];

        for(int i = 1; i < n; i++){
            if(array[i].compareTo(max) > 0)
                max = array[i];
        }

        return max;
    }

}
