package com.btcag.bootcamp.first;

import java.util.Scanner;

public class CalculateDividents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcher Divisor soll geprüft werden?");
        long divisor = scanner.nextLong();
        System.out.println("Dis zu welcher Zahl?");
        long maxNumber = scanner.nextLong();
        long temp = 0;
        while (divisor * temp < maxNumber) {
            System.out.println(divisor * temp++);
        }
    }
}
