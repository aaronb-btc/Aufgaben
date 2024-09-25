package com.btcag.bootcamp.first;

import java.util.Scanner;

public class AsciiArtII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Größe einer Sanduhrhälfte: ");
        long size = scanner.nextLong();
        long counter = size;
        char star = '*';
        long counter2;
        while (counter > -1) {
            counter2 = 0;
            while (counter2++ < counter) {
                System.out.print(star);
            }
            counter--;
            System.out.println();
        }
        counter += 2;
        while (counter <= size) {
            counter2 = 0;
            while (counter2++ < counter) {
                System.out.print(star);
            }
            counter++;
            System.out.println();
        }
    }
}
