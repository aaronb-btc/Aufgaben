package com.btcag.bootcamp.W02;

import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib eine Zahl für die Lange des Arrays ein: ");
        long[] array = new long[scanner.nextInt()]; // Creates an array of any given size
        long currVal;

        for (int i = 0; i < array.length; i++) {
            System.out.println("Gib das " + (i + 1) + ". Element das Arrays an (Long):");
            array[i] = scanner.nextLong(); // Fills the array with the given values
        }
        for (int i = 0; i < array.length - 1; i++) { // for every value if the array
            for (int j = i; j >= 0; j--) { // Repeat for every value with and below the current one (from an index perspective)
                if (array[j] > array[j + 1]) {
                    currVal = array[j];
                    array[j] = array[j + 1]; // swap this and the value above if this one is greater
                    array[j + 1] = currVal;
                }
            }
        }
        for (long i: array) {
            System.out.print(i); // prints out every value in the array below each other
        }
        scanner.close();
    }
}
