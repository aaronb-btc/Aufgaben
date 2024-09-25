package com.btcag.bootcamp.W02;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.Scanner;

public class Leapyear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib einw Jahreszahl ein:");
        long year = scanner.nextLong();
        if (year % 4 == 0 && !(year % 400 != 0 && year % 100 == 0)) {
            System.out.println(year + " is a leapyear.");
        } else {
            System.out.println(year + " is not a leapyear.");
        }


    }
}
