package com.btcag.bootcamp.first;

import java.util.Scanner;

public class CrypticNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte die Zahl eingeben:");
        long number = scanner.nextLong();
        System.out.println("Bitte Passwort (Zahl) eingeben:");
        long passkey = scanner.nextLong();
        System.out.println("Result: " + (number ^ passkey));
    }
}
