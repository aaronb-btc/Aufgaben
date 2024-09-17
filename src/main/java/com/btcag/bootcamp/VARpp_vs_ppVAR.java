package com.btcag.bootcamp;

public class VARpp_vs_ppVAR {
    public static void main(String[] args) {
        long VAR = 0;
        System.out.println("VAR is " + VAR);
        System.out.println("Running VAR++...");
        System.out.println("Result: " + VAR++);
        System.out.println("VAR is now " + VAR);
        System.out.println();
        VAR = 0;
        System.out.println("VAR is " + VAR);
        System.out.println("Running ++VAR...");
        System.out.println("Result: " + ++VAR);
        System.out.println("VAR is now " + VAR);
    }
}
