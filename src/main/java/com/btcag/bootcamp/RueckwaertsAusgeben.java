package com.btcag.bootcamp;

import java.util.Scanner;

public class RueckwaertsAusgeben {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte Zahl eingeben (String):");
        String myString = scanner.nextLine();
        String result = "";
        while (result.length() < myString.length()) {
            result += myString.charAt(myString.length() - result.length() - 1);
        }
        System.out.println(result);

        System.out.println("Bitte Zahl eingeben (Long):");
        long myNumber = scanner.nextLong();
        while (myNumber > 0) {
            long modResult = myNumber % 10;
            System.out.print(modResult);
            myNumber = myNumber / 10;
        }
    }
}
