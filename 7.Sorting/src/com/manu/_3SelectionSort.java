package com.manu;

public class _3SelectionSort {

    static void selectionSort(int a[]) {

        for (int i = 0 ; i < a.length; i++) {
            int min = i;
            for(int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 9, 5, 1, 4, 3 };

        System.out.println("array before sorting\n");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        selectionSort(arr);

        System.out.println("\n array after sorting\n");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
}
