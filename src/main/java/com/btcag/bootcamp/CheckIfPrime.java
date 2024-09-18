package com.btcag.bootcamp;

import java.util.Scanner;

public class CheckIfPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Zahl für den Primtest eingeben (Long):");
        long inputNumber = scanner.nextLong();
        long counter = 2;
        boolean isPrime = true;
        while (counter < inputNumber) {
            while (inputNumber % counter++ == 0) {
                isPrime = false;
            }
            counter++;
        }
        System.out.println("Ergebnis: " + isPrime);
    }
}
