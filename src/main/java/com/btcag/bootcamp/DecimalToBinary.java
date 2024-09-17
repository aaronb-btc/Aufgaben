package com.btcag.bootcamp;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zahl zur konvertierng in Binär eingeben:");
        long decimal = scanner.nextLong();
        String result = "";

        while (decimal > 0) {
            result = decimal % 2 + result;
            decimal /= 2;
        }

        System.out.print("Das Ergebnis lautet: " + result);
    }
}
