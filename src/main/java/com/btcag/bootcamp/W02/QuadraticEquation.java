package com.btcag.bootcamp.W02;

import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the folloing values for f(x) = ax² + bx + c:\na = ");
        long a = scanner.nextLong();
        System.out.print("b = ");
        long b = scanner.nextLong();
        System.out.print("c = ");
        long c = scanner.nextLong();
        if (a == 0 && b == 0 && c == 0) {
            System.out.println("There is an infinite amount of solutions.");
        } else if ((a > 0) == (c > 0)) {
            System.out.println("There are no solutions.");
        } else if (a != 0 ^ b != 0) {
            System.out.println("There is only one solution.");
        } else {
            System.out.println("There are two solutions.");
        }
    }
}
