package com.zoltowsky.main.SortAlgorithms;

import java.util.Random;

public class QuickSort {

    static Random random = new Random();

    public static void quickSort(int[] array, int  begin, int end){

        if(begin < end){

            int partitionIndex = partition(array, begin, end);

            quickSort(array,begin,partitionIndex - 1 );
            quickSort(array,partitionIndex + 1, end);

        }

    }

    private static  int partition(int[] array, int begin, int end){

        int pivot = array[begin + random.nextInt(end-begin)];
        int i = begin -1;

        for(int j = begin; j< end; j++){

            if(array[j] <= (pivot) ){
                i++;

                int temp =  array[i];
                array[i] = array[j];
                array[j] = temp;


            }

        }

        int temp = array[i+1];
        array[i+1] = array[end];
        array[end] = temp;

        return i+1;



    }



}
