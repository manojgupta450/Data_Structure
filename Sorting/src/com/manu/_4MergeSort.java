package com.manu;

public class _4MergeSort {
    
    private static int[] arr, tempArr;
    private static int length;
    
    public static void main(String a[]) {
        int[] inputArr = { 9, 5, 1, 4, 3 };
        arr = inputArr;
        length = inputArr.length;
        tempArr = new int[length];

        doMergeSort(0, length - 1);

        for(int i:inputArr) {
            System.out.print(i);
            System.out.print(" ");
        }

    }
    
    private static void doMergeSort(int left, int right) {

        if (right == left) {
            return;
        }

        int middle = (left + right) / 2;
        // Below step sorts the left side of the array
        doMergeSort(left, middle);
        // Below step sorts the right side of the array
        doMergeSort(middle + 1, right);
        // Now merge both sides
        mergeParts(left, middle, right);
    }     
    
    private static void mergeParts(int left, int middle, int right) {
 
        for (int i = left; i <= right; i++) {
            tempArr[i] = arr[i];
        }

        int i = left, j = middle + 1, r = left;

        while (i <= middle && j <= right) {
            if (tempArr[i] <= tempArr[j]) {
                arr[r] = tempArr[i];
                i++;
            } else {
                arr[r] = tempArr[j];
                j++;
            }
            r++;
        }

        while (i <= middle) {
            arr[r] = tempArr[i];
            r++;
            i++;
        }
 
    }
}