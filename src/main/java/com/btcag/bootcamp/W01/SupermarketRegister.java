package com.btcag.bootcamp.W01;

import java.util.Scanner;

public class SupermarketRegister {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte alle Produkte in Cent eingeben und mit 0 die Liste beenden:");
        long cent = 0;
        long result = scanner.nextLong();
        while (result != 0) {
            cent += result;
            result = scanner.nextLong();
        }
        System.out.println("Die Summe aller Produkte ist " + cent / 100 + " € und " + cent % 100 + " Cent\n\nWie viel hat der Kunde gegeben (in Cent) ?");
        cent = scanner.nextLong() - cent;
        long euro = cent / 100;
        cent %= 100;
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
            System.out.println(result + " x " + currValue + " Cent");
            currValue /= 2;
            while (currValue == 25) {
                currValue = 20;
            }
        }
    }
}