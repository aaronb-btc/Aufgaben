package com.btcag.bootcamp;

import java.util.Scanner;

public class Subnetting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte gebe das erste Oktett der ip adresse an:");
        long okt1 = scanner.nextLong();

        System.out.println("Bitte gebe das zweite Oktett der ip adresse an:");
        long okt2 = scanner.nextLong();

        System.out.println("Bitte gebe das dritte Oktett der ip adresse an:");
        long okt3 = scanner.nextLong();

        System.out.println("Bitte gebe das vierte Oktett der ip adresse an:");
        long okt4 = scanner.nextLong();

        long ip = okt1 * 1000000000 + okt2 * 1000000 + okt3 * 1000 + okt4;

        System.out.println(ip + "\nBitte gebe die Subnetzmaske an");
        long mask = scanner.nextLong();

        long broadcast = ip | ~(-1L << (32 - mask));
        long netAddress = ip - (ip & ~(-1L << (32 - mask)));

        System.out.print("Die Netzadresse ist: ");
        String currAdress = "";
        while (netAddress > 1000) {
            currAdress = "." + (netAddress - ((netAddress - netAddress % 1000))) + currAdress;
            netAddress = (netAddress - netAddress % 1000) / 1000;
        }
        currAdress = (netAddress - ((netAddress - netAddress % 1000))) + currAdress;

        System.out.print(currAdress + "\nDie Broadcastadresse ist: ");
        currAdress = "";
        while (broadcast > 1000) {
            currAdress = "." + (broadcast - ((broadcast - broadcast % 1000))) + currAdress;
            broadcast = (broadcast - broadcast % 1000) / 1000;
        }
        currAdress = (broadcast - ((broadcast - broadcast % 1000))) + currAdress;
        System.out.print(currAdress);
    }
}