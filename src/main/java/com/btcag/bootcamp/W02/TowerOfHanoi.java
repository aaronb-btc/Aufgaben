package com.btcag.bootcamp.W02;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Gib die gewünschte Höhe des Turms ein: ");
        long[] towerA = new long[scanner.nextInt()];
        long[] towerB = new long[towerA.length];
        long[] towerC = new long[towerA.length];
        int[] usableTowerIndexes = new int[2];
        long[][] towers = {towerA, towerB, towerC};
        int direction = (towerA.length % 2) * -2 + 1;
        long movesMade = 0;

        for (int i = 0; i < towerA.length; i++) {
            towerA[i] = i + 1;
        }

        while ((arrSum(towerA) + arrSum(towerB)) != 0) {
            if (movesMade % 2 == 0) {
                for (int i = 0; i < towers.length; i++) {
                    if (findFirst(towers[i]) != -1) {
                        if (towers[i][findFirst(towers[i])] == 1) {
                            moveDisk(towers[i], towers[posMod((i + direction), towers.length)]);
                            usableTowerIndexes[0] = i;
                            usableTowerIndexes[1] = posMod((i - direction), towers.length);
                            i = 3;
                        }
                    }
                }
            } else {
                if (!moveDisk(towers[usableTowerIndexes[0]], towers[usableTowerIndexes[1]])) {
                    moveDisk(towers[usableTowerIndexes[1]], towers[usableTowerIndexes[0]]);
                }

            }

            System.out.println("\nMove " + ++movesMade + ":");
            for (long[] tower: towers) {
                System.out.println();
                for (long ring: tower) {
                    System.out.println(ring);
                }
            }
            System.out.println("---------");
        }
        System.out.println("Game solved in "+  movesMade + " moves.");
    }

    public static int posMod(int a, int b) {
        int result = a % b;
        if (result < 0) {
            result += b;
        }
        return result;
    }

    public static int findFirst(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    public static boolean moveDisk(long[] fromArr, long[] toArr) {
        int fromFirst = findFirst(fromArr);
        if (fromFirst == -1) {
            return false;
        }
        int toFirst = findFirst(toArr);
        boolean valid = false;

        if (toFirst == -1) {
            toFirst = toArr.length;
            valid = true;
        } else {
            valid = fromArr[fromFirst] < toArr[toFirst];
        }
        toFirst -= 1;
        if (valid) {
            toArr[toFirst] = fromArr[fromFirst];
            fromArr[fromFirst] = 0;

            return true;
        }
        return false;
    }

    public static long arrSum(long[] arr) {
        long sum = 0;
        for (long i: arr) {
            sum += i;
        }
        return sum;
    }
}
