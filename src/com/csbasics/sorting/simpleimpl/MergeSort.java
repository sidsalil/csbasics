package com.csbasics.sorting.simpleimpl;

import java.util.Arrays;

public class MergeSort {
    private MergeSort(){}

    private static int result[];
    private static int length;

    public static void sort(int data[]){
        length = data.length;
        if (length < 2)
            return;
        int mid = length / 2;
        int firstHalf[] = Arrays.copyOfRange(data, 0, mid);
        int secondHalf[] = Arrays.copyOfRange(data, mid, length);
        sort(firstHalf);
        sort(secondHalf);
        merge(firstHalf, secondHalf, data);
    }
    private static void merge(int firstHalf[], int secondHalf[], int data[]){
        int firstHalfIndex = 0, secondHalfIndex = 0;
        while (firstHalfIndex + secondHalfIndex < data.length) {
            if (secondHalfIndex == secondHalf.length || (firstHalfIndex < firstHalf.length && firstHalf[firstHalfIndex] <= secondHalf[secondHalfIndex])) {
                data[firstHalfIndex + secondHalfIndex] = firstHalf[firstHalfIndex];
                try {
                    firstHalfIndex = firstHalfIndex + 1;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                data[firstHalfIndex + secondHalfIndex] = secondHalf[secondHalfIndex];
                secondHalfIndex = secondHalfIndex + 1;
            }
        }

    }

    private static void printArray(int start, int end, int array[], String message){
        System.out.print(message + "\t[");
        for (int ctr = start; ctr <= end; ctr++){
            System.out.print(array[ctr]);
            if (ctr != end)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    private static void printMerge(int start, int mid, int end, int array[]){
        System.out.print("\t\t\tMerging\t[");
        for (int ctr = start; ctr <= mid; ctr++){
            System.out.print(array[ctr]);
            if (ctr != mid)
                System.out.print(", ");
        }
        System.out.print("]");
        System.out.print("\tAND\t[");
        for (int ctr = mid + 1; ctr <= end; ctr++){
            System.out.print(array[ctr]);
            if (ctr != end)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}

class RunMergeSort{
    public static void main(String[] args) {
        int data[] = {85, 24, 63, 45, 17, 31, 96, 50};
        System.out.println("Input Array = \t"+Arrays.toString(data));
        MergeSort.sort(data);
        System.out.println("Output Array = \t"+Arrays.toString(data));
    }
}