package com.btcag.bootcamp.W02;

import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib eine Zahl für die Lange des Arrays ein: ");
        long[] array = new long[scanner.nextInt()];
        long currVal;
        for (int i = 0; i < array.length; i++) {
            System.out.println("Gib das " + (i + 1) + ". Element das Arrays an (Long):");
            array[i] = scanner.nextLong();
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (array[j] > array[j + 1]) {
                    currVal = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = currVal;
                }
            }

        }
        for (long i: array) {
            System.out.print(i);
        }
        scanner.close();
    }
}
