package com.btcag.bootcamp;

import java.util.Scanner;

public class Primfaktorzerlegung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Zahl für die Primfaktorzerlegung eingeben (Long): ");
        long inputNumber = scanner.nextLong();
        long result = inputNumber;
        long counter = 2;
        long counter2;
        boolean skip;
        boolean isPrime;
        System.out.print("Die Zahl " + inputNumber + " kann in folgende Faktoren zerlegt werden: ");
        while (counter < inputNumber) {
            isPrime = true;
            counter2 = 2;
            while (counter2 < counter) {
                while (counter % counter2++ == 0) {
                    isPrime = false;
                }
                counter2++;
            }
            while (isPrime) {
                skip = true;
                while (result % counter == 0) {
                    result /= counter;
                    System.out.print(counter + " ");
                    skip = false;
                }
                while (skip) {
                    isPrime = false;
                    skip = false;
                }
            }
            counter++;
        }
    }
}