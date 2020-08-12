package com.company;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {3, 7, 1, 5, 3, 21, 4, 22, -1, 2, 0, 0, -65, 73, 10};
        printArray(a);
        selectionSort(a);
        printArray(a);
    }

    private static void selectionSort(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            int minimInd = findIndexMin(a, i);
            int t = a[i];
            a[i] = a[minimInd];
            a[minimInd] = t;
        }
    }

    private static int findIndexMin(int[] arr, int num){
        int min = num;
        for (int j = num+1; j < arr.length; j++) {
            if (arr[min] > arr[j]) {
                min = j;
            }
        }
        return min;
    }

    private static void printArray ( int[] a){

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
