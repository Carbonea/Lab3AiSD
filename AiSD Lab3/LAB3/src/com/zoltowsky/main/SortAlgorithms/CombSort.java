package com.zoltowsky.main.SortAlgorithms;

public class CombSort {


    public static  void  combSort(int[] array, int size){

        int gap = size; //distance between elements
        boolean swapped = true;
        int i; //index


        //if gap is < 1 it makes no sense at all

        while(gap > 1 || swapped){


            //gap cannot be smaller than 1 hence the if
            //1.3 is the shrink factor that seems to be the fastest
            if(gap > 1){
                gap = (int)(gap/1.3);
            }

            i = 0;
            swapped = false;

            //create a loop comparing Elements that are apart from eachother gap length
            //if the 1st no. is smaller than the 2nd swap
            while(i+gap < size){

                if(array[i] > (array[i+gap])){

                    int temp = array[i];
                    array[i] = array[i+gap];
                    array[i+gap] = temp;

                    swapped = true;

                }
                i++;

            }


        }





    }


}
