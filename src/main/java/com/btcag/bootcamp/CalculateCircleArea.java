package com.btcag.bootcamp;

import java.util.Scanner;

public class CalculateCircleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a)
        System.out.println("Bitte Radius für die Flächenberechnung eingeben (Long):");
        long radius = scanner.nextLong();
        System.out.println("Ergebnis: " + radius * radius * 3.14159);

        // b)
        System.out.println("\nBitte Höhe für die Flächenberechnung eingeben (Long):");
        long height = scanner.nextLong();
        System.out.println("\nBitte Breite für die Flächenberechnung eingeben (Long):");
        long width = scanner.nextLong();
        System.out.println("Ergebnis: " + width * height);
    }
}
