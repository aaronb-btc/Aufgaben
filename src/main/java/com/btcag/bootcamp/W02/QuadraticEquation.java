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
        double d = b * b - 4 * a * c; // Random formula I pulled from the internet. It works, so im feeling good.
        System.out.print(d);
        // This mf tells you how many (in germany we say) Nullstellen there are
        if (a == 0 && b == 0 && c == 0) {
            System.out.println("Es gibt unendlich viele verschiedene Lösungen."); // There are all if it's on the x axis
        } else if (d > 0) {
            System.out.println("Es gibt zwei Lösungen.");
        } else if (d == 0) {
            System.out.println("Es gibt nur eine Lösung.");
        } else {
            System.out.println("Es gibt keine Lösungen.");
        }
    }
}
