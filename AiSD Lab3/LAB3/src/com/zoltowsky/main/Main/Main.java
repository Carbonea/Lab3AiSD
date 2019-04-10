package com.zoltowsky.main.Main;


import com.zoltowsky.main.SortAlgorithms.CombSort;
import com.zoltowsky.main.SortAlgorithms.MergeSort;
import com.zoltowsky.main.SortAlgorithms.QuickSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;




public class Main {
    static Random random = new Random();

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);
        int algorithmChoice, sortType, sequenceLength;
        int[] array;

        System.out.println("1.Quick Sort    2.Merge Sort    3.Comb sort");
        algorithmChoice = in.nextInt();
        System.out.println("1.Fully random   2.Half sorted  3.Fully sorted   4.Sorted reversely ");
        sortType = in.nextInt();
        System.out.println("1.100 000   2.500 000   3.1 000 000 4.2 000 000 ");
        sequenceLength = in.nextInt();

        //change squence length to actual length
        if(sequenceLength == 1){sequenceLength = 100000;}
        else if(sequenceLength == 2) {sequenceLength = 500000;}
        else if(sequenceLength == 3) { sequenceLength = 1000000;}
        else sequenceLength = 2000000;





        //here we create a loop that will create 100 sequences of ints to be sorted
        System.out.println("For algorithm: " + algorithmChoice + " and sort Type: " + sortType + " and sequence length: " + sequenceLength );
        for(int i = 0; i < 101; i++){




            array = createIntArray(sequenceLength, sortType, i);


            long start = System.currentTimeMillis();



            sort(array,algorithmChoice);




            long end = System.currentTimeMillis();
           // System.out.println("Time in miliseconds for sequence " + i +": " + (end - start));
            System.out.println((end - start));

        }

    }



    public static int[] createIntArray(int sequenceLength, int sortType, int sequenceID){

        int[] array = new int[sequenceLength];


        if(sortType == 1){

            array = createRandom(array);
            //QuickSort.quickSort(array,0, array.length-1);


        }else if(sortType == 2){
            array = createHalfSorted(array);

        }else if(sortType == 3) {
            array = createFullySorted(array);

        }
        else if(sortType == 4){
            array = createReverselySorted(array);
        }



        return array;
    }



    public static int[] createRandom(int[] array){


        for(int i = 0; i <array.length; i++){
            array[i] = random.nextInt(1000000);
        }

        return array;
    }

    public static int[] createHalfSorted(int[] array){

        int halfRange = array.length/2;
        array[0] = random.nextInt(1000000);
        for(int i = 1; i < halfRange; i++){
            array[i] = array[i-1] + random.nextInt(1000000);
        }

        for(int i = halfRange; i < array.length; i++){
            array[i] = random.nextInt(1000000) ;

        }
        return array;
    }

    public static int[] createFullySorted(int[] array){

        array[0] = random.nextInt(1000000);

        for (int i = 1; i < array.length; i++) {
            array[i] = array[i-1] + (random.nextInt(1000000));
        }
        return array;
    }

    public static int[] createReverselySorted(int[] array){

        array[array.length-1] = random.nextInt(1000000);
        for(int i = array.length - 2; i>=0 ; i--){
            array[i] = array[i+1] - random.nextInt(1000000) ;
        }

        return array;

    }

    public static void sort(int[] array, int algorithmChoice){

        if(algorithmChoice == 1){
            QuickSort.quickSort(array,0,array.length-1);
        }
        else if (algorithmChoice == 2){
            MergeSort.mergeSort(array,array.length);
        }
        else{
            CombSort.combSort(array,array.length);
        }
    }

}
