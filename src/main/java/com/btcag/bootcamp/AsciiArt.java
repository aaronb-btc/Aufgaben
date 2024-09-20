package com.btcag.bootcamp;

import java.util.Scanner;

public class AsciiArt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a)
        System.out.print("Größe des Vierecks: ");
        long size = scanner.nextLong();
        String message = "";
        long counter = 0;
        while (counter++ < size) {
            message += '*';
        }
        counter = 0;
        while (counter++ < size) {
            System.out.println(message);
        }

        // b)
        System.out.print("\nGröße des Dreiecks: ");
        size = scanner.nextLong();
        counter = 0;
        message = "";
        while (counter++ < size) {
            message += '*';
            System.out.println(message);
        }
    }
}
