package com.btcag.bootcamp;

import java.util.Scanner;

public class Subnetting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gebe das erste Oktett der ip adresse an:");
        String prefix = scanner.nextLong() + ".";
        System.out.println("Bitte gebe das zweite Oktett der ip adresse an:");
        prefix += scanner.nextLong() + ".";
        System.out.println("Bitte gebe das dritte Oktett der ip adresse an:");
        prefix += scanner.nextLong() + ".";
        System.out.println("Bitte gebe das vierte Oktett der ip adresse an:");
        long ip = scanner.nextLong();
        System.out.println("Bitte gebe die Subnetzmaske an");
        long mask = scanner.nextLong();
        long broadcast = ip | ~(-1L << (32 - mask));
        ip -= ip & ~(-1L << (32 - mask));
        System.out.println("Die Netzadresse ist: " + prefix + ip +
                "\nDie Broadcastadresse ist: " + prefix + broadcast);
    }
}