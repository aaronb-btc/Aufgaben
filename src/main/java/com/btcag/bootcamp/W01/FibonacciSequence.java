package com.btcag.bootcamp.W01;

import java.util.Scanner;

public class FibonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Gib eine Zahl ein: ");
        long limit = scanner.nextLong();
        long lastFib = 0;
        long currFib = 1;
        long temp;
        System.out.println("Fibonacci-Zahlen bis " + limit);
        while (currFib <= limit) {
            temp = currFib;
            currFib += lastFib;
            lastFib = temp;
            System.out.print(lastFib + " ");
        }
    }
}
