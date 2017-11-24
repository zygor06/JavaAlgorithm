package br.com.hygor.algorithm.sorts;

/**
 * @author Hygor Dias (github.com/zygor06)
 *
 */

import java.util.Random;

/**
 * @deprecated this algorithm is extremely not recommended!
 * It was just written fot the purpose of learning
 *
 */
@Deprecated
@SuppressWarnings("this algorithm is extremely not recommended!")
public class BogoSort {

    private static <T> void swap(T array[], int first, int second){
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    private static <T extends Comparable<T>> boolean isSorted(T array[]){
        for(int i = 0; i < array.length - 1; i++)
            if(array[i].compareTo(array[i+1]) > 0) return false;
        return true;
    }

    private static <T> void shuffle(T array[]){
        int length = array.length;
        Random random = new Random();

        for(int i = 0; i < length; i++){
            int randomIndex = i + random.nextInt(length - 1);
            swap(array, randomIndex, i);
        }
    }

    public static <T extends Comparable<T>> void sort(T array[]){
        while (!isSorted(array)){
            shuffle(array);
        }
    }

}
