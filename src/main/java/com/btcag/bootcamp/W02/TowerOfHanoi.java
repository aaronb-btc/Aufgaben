package com.btcag.bootcamp.W02;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Gib die gewünschte Höhe des Turms ein: ");
        int size = scanner.nextInt();
        int[] usableTowerIndexes = new int[2]; // will store the towers that need to be moved to / from (not where the first ring is)
        long[][] towers = {new long[size], new long[size], new long[size]}; // stores all towers
        int direction = (towers[0].length % 2) * -2 + 1; // Decides in which direction the first ring will move every 2nd move
        long movesMade = 0;

        // Creates the rings on the first tower
        for (int i = 0; i < towers[0].length; i++) {
            towers[0][i] = i + 1;
        }

        // Main loop moves one piece every iteration
        while ((arrSum(towers[0]) + arrSum(towers[1])) != 0) {
            System.out.println(generateDisplay(towers) + "\n");
            // Every 2nd iteration the smallest ring is moved clock / anticlockwise
            if (movesMade % 2 == 0) {
                for (int i = 0; i < towers.length; i++) { // For every tower
                    if (findFirst(towers[i]) != -1) { // if there is a ring on this tower
                        if (towers[i][findFirst(towers[i])] == 1) { // if the ring is the smallest one
                            moveDisk(towers[i], towers[posMod((i + direction), towers.length)]); // move it
                            usableTowerIndexes[0] = i;                                           // set this tower to usable
                            usableTowerIndexes[1] = posMod((i - direction), towers.length);      // set the other tower without the smallest ring to usable
                            i = 3; // Exit loop
                        }
                    }
                }
            } else {
                // One of both will always work
                if (!moveDisk(towers[usableTowerIndexes[0]], towers[usableTowerIndexes[1]])) { // Try to move the first usable tower to the 2nd
                    moveDisk(towers[usableTowerIndexes[1]], towers[usableTowerIndexes[0]]); // If the above was an illegal move, try it the other way
                }
            }
            movesMade++; // Add one to the total moves made.
        }
        // Show the end result
        System.out.println(generateDisplay(towers));
        System.out.println("Game solved in "+  movesMade + " moves.");
    }

    // generates cli output
    public static String generateDisplay(long[][] towerArray) {
        String display = "";
        String temp;
        char ringChar;
        for (int ringIndex = 0; ringIndex < towerArray[0].length; ringIndex ++) { // for every ringsize
            for (int towerIndex = 0; towerIndex < towerArray.length; towerIndex++) { // and for every tower
                temp = ("" + towerArray[towerIndex][ringIndex]);
                ringChar = temp.charAt(temp.length() - 1); // take the last digit of the ringsize as the char to represent it
                temp = repeatString(" ", (towerArray[0].length + 1) - towerArray[towerIndex][ringIndex]) + repeatString("" + ringChar, towerArray[towerIndex][ringIndex]); // create half the ring
                display += temp + "@" + reverseString(temp); // add both halfs of the ring with a pole in the middle
                if (towerArray.length - 1 != towerIndex) {
                    display += " | "; // add a seperating line if this isn't the last tower
                }
            }
            display += "\n";
        }
        temp = repeatString("@", (towerArray[0].length + 1) * 2 + 1); // create the base of every tower
        for (int i = 0; i < towerArray.length; i++) {
            display += temp; // add the bases
            if (towerArray.length - 1 != i) {
                display += " | "; // add the seperating line if this isn't the last tower
            }
        }
        return display;
    }

    // reverses any given string
    public static String reverseString(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) { // for every index counting from high to 0
            result += str.charAt(i); // add the indexe's char to the result
        }
        return result;
    }

    // repeats any given sting any given amount of times
    public static String repeatString(String str, long n) {
        String result = "";
        for (long i = 0; i < n; i++) { // repeat n times
            result += str; // add the given string to the result
        }
        return result;
    }

    // returns a positive mod operation result for any given to values
    public static int posMod(int a, int b) {
        int result = a % b; // calculate the mod result of a and b
        if (result < 0) {
            result += b; // turn it into a positive number if it was negative
        }
        return result;
    }

    // finds the index of the first non-0 number in any given array with the type of long
    public static int findFirst(long[] arr) {
        for (int i = 0; i < arr.length; i++) { // iterates through the array using indexes
            if (arr[i] != 0) {
                return i; // returns the index if the value at the indexes position is not 0
            }
        }
        return -1; // returns -1 if nothing was found
    }

    // moves the first ring from a given tower to another given tower and returns if ti was successful
    public static boolean moveDisk(long[] fromArr, long[] toArr) {
        int fromFirst = findFirst(fromArr);
        // returns false if the from-array is empty
        if (fromFirst == -1) {
            return false; // reports thar it was unsuccessful (due to the from-array not having a ring)
        }
        int toFirst = findFirst(toArr);
        boolean valid = false;
        // Checks if the move is valid
        if (toFirst == -1) {
            toFirst = toArr.length; // chooses the last position in the receiving array
            valid = true; // set the validity to true because there is no ring on the receiving side
        } else {
            valid = fromArr[fromFirst] < toArr[toFirst]; // sets the validity based on the greatness between both rings
        }
        toFirst -= 1; // Reduces the target position by 1, so nothing gets overwritten
        if (valid) {
            toArr[toFirst] = fromArr[fromFirst]; // Creates a ring with the size of the first ring on the from-array
            fromArr[fromFirst] = 0; // deletes the first ring from the from-array because it got transferred to the other ring
            return true; // reports thar it was successful
        }
        return false; // reports thar it was unsuccessful
    }

    // return the sum of all values in a given array with the type long
    public static long arrSum(long[] arr) {
        long sum = 0; // creates a value to add to
        for (long i: arr) { // iterates over all values and stores the current value in i
            sum += i; // adds the current value to the result
        }
        return sum;
    }
}
