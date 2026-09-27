package com.manu;

public class _2InsertionSort {

    static void insertionSort(int []a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i-1;
            while (j >= 0 && a[j] > key) {
                a[j+1] = a[j];
                j = j-1;
            }
            /*for (j = i-1; j >= 0 && a[j] > key; j--) {
                 a[j+1] = a[j];
            }*/
            a[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 9, 5, 1, 4, 3 };

        System.out.println("array before sorting\n");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        insertionSort(arr);

        System.out.println("\n array after sorting\n");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
}
