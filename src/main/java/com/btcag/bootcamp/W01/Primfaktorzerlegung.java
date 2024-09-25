package com.btcag.bootcamp.W01;

import java.util.Scanner;

public class Primfaktorzerlegung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Zahl für die Primfaktorzerlegung eingeben (Long): ");
        long inputNumber = scanner.nextLong();
        long result = inputNumber;
        long counter = 2;
        System.out.print("Die Zahl " + inputNumber + " kann in folgende Faktoren zerlegt werden: ");
        while (counter <= inputNumber) {
            while (result % counter == 0) {
                result /= counter;
                System.out.print(counter + " ");
            }
            counter++;
        }
    }
}