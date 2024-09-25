package com.btcag.bootcamp.first;

import java.util.Scanner;

public class CalculatePi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viele Iterationen sollen gemacht werden um pi zu berechnen?");
        long iterations = scanner.nextLong();
        long i = 0;
        double pi = 1;
        while (iterations > i) {
            pi += (1D / ((i + 1) * 2 + 1)) * ((i % 2) * 2 - 1);
            i++;
        }
        pi *= 4;
        System.out.println("Nach " + iterations + " Iterationen wurde Pi auf den Wert " + pi + " berechnet");
    }
}