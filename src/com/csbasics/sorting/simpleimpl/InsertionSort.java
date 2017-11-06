package com.csbasics.sorting.simpleimpl;

import java.util.Arrays;

public class InsertionSort {
    private InsertionSort() {}

    public static void sort(int data[]) {
        int arrayLength = data.length;
        logState("Original Array = " + Arrays.toString(data) + "\nto be sorted in ascending order" );
        for (int i = 1 ; i < arrayLength; i++) {
            int currPos = i;
            int currElement = data[currPos];
            logState("\n\nfor i = " + i + "; Beginning State = \t" + Arrays.toString(data) );
            logState("currPos = " + currPos + ";\tcurrElement = " + currElement);
            while(currPos > 0 && data[currPos - 1] > currElement){
                data[currPos] = data[currPos - 1];
                logState("\tfor currPos = " + currPos + "\t\t" + Arrays.toString(data) );
                currPos = currPos - 1;
            }
            data[currPos] = currElement;
            logState("for i = " + i + "; Ending State = \t" + Arrays.toString(data) );
        }
    }
    private static void logState(String message) {
        System.out.println(message);
    }
}
class RunInsertionSort {
    public static void main(String[] args) {
        int data[] = {3,5, 1,5,99,66,2};
        InsertionSort.sort(data);
        System.out.print(Arrays.toString(data));
        //new RunInsertionSort().printMessage("Did you get this message");
    }
}