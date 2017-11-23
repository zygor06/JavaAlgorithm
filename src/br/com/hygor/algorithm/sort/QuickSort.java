package br.com.hygor.algorithm.sort;

import javax.management.relation.RoleUnresolved;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    static Random random = new Random();

    public static void sort(int[] a, int low, int high){
        if(low >= high) return;

        int separator = a[low + random.nextInt(high - low + 1)];
        int i = low;
        int j = high;

        while (i <= j){
            while (a[i] < separator) ++i;
            while (a[j] > separator) --j;

            if(i <= j){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                ++i;
                --j;
            }
        }

        sort(a, low, j);
        sort(a, i, high);

    }

    public static void main(String[] args){

        int n = 10_000_000;
        int[] a1 = random.ints(n).toArray();
        int[] a2 = a1.clone();
        long time = System.currentTimeMillis();
        Arrays.sort(a2);

        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        sort(a1, 0, a1.length - 1);


        System.out.println(System.currentTimeMillis() - time);

        if(!Arrays.equals(a1, a2))
            throw new RuntimeException();
    }


}
