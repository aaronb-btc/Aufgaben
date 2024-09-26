package com.btcag.bootcamp.W02;

import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] players = new String[2];
        do {
            System.out.print("Spieler gelb, bitte gib deinen Namen ein (3 - 15 Zeichen): ");
            players[0] = scanner.next();
        } while (players[0].length() < 3 || players[0].length() > 15);
        do {
            System.out.print("Spieler rot, bitte gib deinen Namen ein (3 - 15 Zeichen): ");
            players[1] = scanner.next();
        } while (players[1].length() < 3 || players[1].length() > 15);
        int currPlayer = 0;
        int[] size = {7, 6};
        int[] playfield = new int[size[0] * size[1]];
        for (int i = 0; i < playfield.length; i++) {
            playfield[i] = -1;
        }
        int gameWon = -1;
        int selectedRow;
        while (gameWon == -1) {
            System.out.println(generateDisplay(size[0], playfield));
            do {
                System.out.println(players[currPlayer] + ", its your turn!\nEnter a number from 1 to " + size[0]);
                selectedRow = scanner.nextInt() - 1;
            } while (!placeInRow(selectedRow, currPlayer, size[0], playfield));

            if (currPlayer == 0) {
                currPlayer = 1;
            } else {
                currPlayer = 0;
            }
            gameWon = checkPlayerWon(size[0], playfield);
        }
        System.out.println(generateDisplay(size[0], playfield));
        System.out.println("Congratulations, " + players[gameWon] + "! You won the game");
    }

    public static String generateDisplay(int width, int[] gametable) {
        String playfield = "";
        for (int i = 0; i < gametable.length; i++) {
            switch (gametable[i]) {
                case -1:
                    playfield += "🟦";
                    break;
                case 0:
                    playfield += "🟨";
                    break;
                case 1:
                    playfield += "🟥";
                    break;
            }
            if ((i + 1) % width == 0) {
                playfield += '\n';
            }
        }
        return playfield;
    }

    public static int checkPlayerWon(int width, int[] gametable) {
        int counter;
        for (int i=0; i < gametable.length; i++) {
            if (gametable[i] != -1) {
                // Check horizontal line
                counter = 0;
                for (int j = i; j < gametable.length; j++) {
                    if (gametable[j] == gametable[i] && i / width == j / width) {
                        counter++;
                    } else {
                        j = gametable.length;
                    }
                }
                if (counter >= 4) {
                    return gametable[i];
                }

                // Check vertical line
                counter = 0;
                for (int j = i; j < gametable.length; j += width) {
                    if (gametable[j] == gametable[i]) {
                        counter++;
                    } else {
                        j = gametable.length;
                    }
                }
                if (counter >= 4) {
                    return gametable[i];
                }

                // Check downwarts to the right
                counter = 0;
                for (int j = i; j < gametable.length; j += width + 1) {
                    if (gametable[j] == gametable[i] && i % width == j % width + 1) {
                        counter++;
                    } else {
                        j = gametable.length;
                    }
                }
                if (counter >= 4) {
                    return gametable[i];
                }

                // Check downwarts to the left
                counter = 0;
                for (int j = i; j < gametable.length; j += width - 1) {
                    if (gametable[j] == gametable[i] && i % width == j % width - 1) {
                        counter++;
                    } else {
                        j = gametable.length;
                    }
                }
                if (counter >= 4) {
                    return gametable[i];
                }
            }
        }
        return -1;
    }

    public static boolean placeInRow(int row, int player, int width, int[] gametable) {
        if (row >= width || row < 0) {
            System.out.println("\nRow does not exist\n");
            return false;
        } else if (gametable[row] != -1) {
            System.out.println("\nRow is already full.\n");
            return false;
        }
        for (int i = row; i < gametable.length; i += width) {
            if (gametable[i] == -1) {
                row = i;
            } else {
                i = gametable.length;
            }
        }
        gametable[row] = player;
        return true;
    }
}
