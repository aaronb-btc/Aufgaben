package com.btcag.bootcamp.W02;

import java.util.Scanner;

public class RecursiveFib {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scanner.nextInt();
        System.out.println("Fibonacci number no. " + n + ": "+ fibonacci(n - 1));
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return 1; // returns 1 in the case of 0 or 1
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // Asks his identical twin if the has the answer to the previous two and adds them together
        }
    }
}
