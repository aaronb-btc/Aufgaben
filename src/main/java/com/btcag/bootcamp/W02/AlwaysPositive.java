package com.btcag.bootcamp.W02;

import java.util.Scanner;

public class AlwaysPositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long schLong = scanner.nextLong(); // Imagine the 'sch' equals to 'my'
        while (schLong < 0) { // Just to fuck you up I used while instead of if, even though its 'legal' now
            schLong *= -1;
        }
        System.out.println(schLong);
    }
}
