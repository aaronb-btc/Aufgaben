package com.btcag.bootcamp.W01;

import java.util.Scanner;

public class CapilizeSting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte String eingeben:");
        String message = scanner.next();
        char currChar;
        long counter = 0;
        while (counter < message.length()) {
            currChar = message.charAt((int) counter);
            while (currChar > 96) {
                currChar -= 32;
            }
            System.out.print(currChar);
            counter++;
        }
    }
}
