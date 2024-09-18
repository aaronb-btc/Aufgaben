package com.btcag.bootcamp;

import java.util.Scanner;

public class Quersumme {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Zahl eingeben (Long):");
        long myNumber = scanner.nextLong();
        long result = 0;
        long modResult;
        while (myNumber > 0) {
            modResult = myNumber % 10;
            result += modResult;
            myNumber = (myNumber - modResult) / 10;
        }
        System.out.println("Die Quersumme ist: " + result);
        System.out.println("Bitte Zahl eingebem (String):");
        String myString = scanner.next();
        result = 0;
        int counter = 0;
        while (counter < myString.length()) {
            result += myString.charAt(counter) - 48;
            counter++;
        }
        System.out.println("Die Quersumme ist: " + result);
    }
}
