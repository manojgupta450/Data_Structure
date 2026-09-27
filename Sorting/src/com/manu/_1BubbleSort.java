package com.manu;

public class _1BubbleSort {
    static void bubbleSort(int[] a) {
        int n = a.length;
        for(int i=0; i < n; i++){
            for(int j=1; j < n-i; j++){

                if (a[j-1] > a[j]) {
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    static void optBubbleSort(int []a) {
        boolean isSorted = false;
        int temp;
        int count = 0;
        while (!isSorted) {
            isSorted = true;

            for (int i = 1; i < a.length-count; i++) {

                if (a[i-1] > a[i]) {
                    temp = a[i-1];
                    a[i-1] = a[i];
                    a[i] = temp;
                    isSorted = false;
                }
            }
            count++;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 9, 5, 1, 4, 3 };

        System.out.println("array before sorting\n");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        bubbleSort(arr);

        System.out.println("\n array after sorting\n");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        optBubbleSort(arr);
        System.out.println("\n array after sorting\n");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}