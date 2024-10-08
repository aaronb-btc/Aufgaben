package com.btcag.bootcamp.W02;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.Scanner;

public class Leapyear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib eine Jahreszahl ein:");
        long year = scanner.nextLong();
        if (year % 4 == 0 && !(year % 400 != 0 && year % 100 == 0)) { // if year divisible by 4 or 400, but not 100
            System.out.println(year + " is a leapyear.");
        } else {
            System.out.println(year + " is not a leapyear.");
        }
    }
}
