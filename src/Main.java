package com.company;

import java.util.Arrays;
import java.util.Scanner;

interface Logic {
    boolean isEqual(int a, int b);
}

class LogicSort {
    static boolean sortAscend (int a, int b) {
        return a < b;
    }
    static boolean sortDescend (int a, int b) {
        return a > b;
    }
}

public class Main {


    public static void selectionSort(int[] sortArr, Logic sort) {
        for (int i = 0; i < sortArr.length; i++) {
            int min_id = i;
            int min = sortArr[i];
            for (int j = i + 1; j < sortArr.length; j++) {
                if (sort.isEqual(sortArr[j], min)) {
                    min_id = j;
                    min = sortArr[j];
                }
            }
            sortArr[min_id] = sortArr[i];
            sortArr[i] = min;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int[] array = new int[in.nextInt()];
        System.out.println("Enter array elements");
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }
        System.out.println("Array sort:\n" +
                "1. Ascending\n" +
                "2. Descending");
        if (in.nextInt() == 1) {
            selectionSort(array, LogicSort::sortAscend);
            System.out.println(Arrays.toString(array));
        }
        else if (in.nextInt() == 2) {
            selectionSort(array, LogicSort::sortDescend);
            System.out.println(Arrays.toString(array));
        }
        else {
            System.out.println("Error: wrong sort type selected");
        }
    }
}
