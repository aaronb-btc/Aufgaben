package com.btcag.bootcamp;

import java.io.DataInput;
import java.util.Scanner;

public class SupermarketRegister {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte alle Produkte in Cent eingeben und mit 0 die Liste beenden:");
        long euro = 0;
        long result = scanner.nextLong();
        while (result != 0) {
            euro += result;
            result = scanner.nextLong();
        }
        long cent = euro % 100;
        System.out.println("Die Summe aller Produkte ist " + euro / 100 + " € und " + cent + " Cent\n\nWie viel hat der Kunde gegeben (in Cent) ?");
        euro = scanner.nextLong() - euro;
        cent = euro % 100;
        euro /= 100;
        System.out.println("Bitte folgendes Geld zurückgeben ( " + euro + "€ " + cent + " Cent)");
        long currValue = 200;
        while (currValue > 0) {
            result = euro / currValue;
            euro -= result * currValue;
            System.out.println(result + " x " + currValue + "€");
            currValue /= 2;
            while (currValue == 25) {
                currValue = 20;
            }
        }
        currValue = 50;
        while (currValue > 0) {
            result = cent / currValue;
            cent -= result * currValue;
            System.out.println(result + " x " + currValue + "€");
            currValue /= 2;
            while (currValue == 25) {
                currValue = 20;
            }
        }
    }
}
