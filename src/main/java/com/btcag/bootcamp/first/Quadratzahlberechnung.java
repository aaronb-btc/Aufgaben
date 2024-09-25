package com.btcag.bootcamp.first;

import java.util.Scanner;

public class Quadratzahlberechnung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));

        System.out.println("Bitte Zahl eingeben zur Quadretzahöberechnung");
        long thenumber = scanner.nextLong();
        thenumber *= thenumber;
        System.out.println("Ergebnis: " + thenumber);
    }
}
