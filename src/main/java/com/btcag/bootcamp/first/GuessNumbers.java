package com.btcag.bootcamp.first;

import java.util.Random;
import java.util.Scanner;

public class GuessNumbers {
    public static void main(String[] args) {
        long myNumber = new Random().nextLong();
        while (myNumber < 0) {
            myNumber *= -1;
        }
        System.out.println("Bitte gebe Zahlengröße in Bits an:");
        Scanner scanner = new Scanner(System.in);
        long max = (1L << scanner.nextLong()) - 1;
        myNumber %= max + 1;
        long tries = 0;
        long guess = -1;
        long guess2;
        while (guess != myNumber) {
            System.out.println(++tries + ". Versuch: Bitte eine Zahl im Bereich 0 und " + max + " angeben:");
            guess = scanner.nextLong();
            guess2 = guess;
            while (guess > myNumber) {
                guess = -1;
                System.out.println("Die gesuchte Zahl ist kleiner!");
            }
            while (guess2 < myNumber) {
                guess2 = myNumber + 1;
                System.out.println("Die gesuchte Zahl ist größer!");
            }
        }
        System.out.println("Super!");
    }
}