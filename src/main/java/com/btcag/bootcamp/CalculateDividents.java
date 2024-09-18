package com.btcag.bootcamp;

import jdk.jshell.execution.JdiDefaultExecutionControl;

import java.util.Scanner;

public class CalculateDividents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcher Divisor soll geprüft werden?");
        long divisor = scanner.nextLong();
        System.out.println("Dis zu welcher Zahl?");
        long maxNumber = scanner.nextLong();
        long divident = 0;
        while (divident < maxNumber) {
            while (divident % divisor == 0) {
                System.out.println(divident);
                divident++;
            }
            divident++;
        }
    }
}
