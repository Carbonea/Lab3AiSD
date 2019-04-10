package com.zoltowsky.main.SortAlgorithms;

public class MergeSort {


    public static void mergeSort(int[] array, int arrayLength) {

        if(arrayLength < 2){
            return;
        }

        int middlePivot = arrayLength / 2;
        int[] leftArray = new int[middlePivot];
        int[] rightArray = new int[arrayLength - middlePivot];


        //assign left side of the array to sort to leftArray and right side of the array that is to be sorted to rightArray

        for (int i = 0; i < middlePivot; i++) {
            leftArray[i] = array[i];

        }
        for (int i = middlePivot; i < arrayLength; i++) {
            rightArray[i - middlePivot] = array[i];

        }

        mergeSort(leftArray, middlePivot);
        mergeSort(rightArray, arrayLength - middlePivot);
        //merges two arrays into one taking their length as parameters
        merge(array, leftArray, rightArray, middlePivot, arrayLength - middlePivot);


    }

    private static void merge(int[] array, int[] leftArray, int[] rightArray, int leftLen, int rightLen) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftLen && j < rightLen) {

            //if left array's value under the index of i is lesser than right array's function will assign
            //it's value to the original unsorted array if it's the other way around than it will assign
            //right array's value to the main array

            if (leftArray[i] <= (rightArray[j]) ) {

                array[k++] = leftArray[i++];

            } else {

                array[k++] = rightArray[j++];

            }

        }
        //in case of uneven lengths this will make sure that whats left over is sorted properly
        while(i< leftLen){
            array[k++] = leftArray[i++];
        }


        while(j< rightLen){
            array[k++] = rightArray[j++];
        }

    }


}
