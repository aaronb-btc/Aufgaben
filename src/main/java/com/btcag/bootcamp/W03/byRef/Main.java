package com.btcag.bootcamp.W03.byRef;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Gib eine Zahl ein: ");
        ReferenceInt referenceInt = new ReferenceInt(scanner.nextInt());
        doubleValue(referenceInt);
        System.out.println("The same value is now " + referenceInt.getInt());
    }

    public static void doubleValue(ReferenceInt obj) {
        obj.addToInt(obj.getInt());
    }
}
