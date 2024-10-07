package com.btcag.bootcamp.W02;

import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] players = new String[2]; // will store the names of the players
        String color;
        for (int i = 0; i < players.length; i++) {
            if (i == 0) {
                color = "gelb"; // Player 1 is yellow
            } else {
                color = "rot";  // Player 2 is red
            }
            do {
                System.out.print("Spieler " + color + ", bitte gib deinen Namen ein (3 - 15 Zeichen): ");
                players[i] = scanner.next(); // stores the username in the array
            } while (players[i].length() < 3 || players[i].length() > 15); // Checks if the entered name is 3 - 15 chars long
        }

        int gameWon = -1; // no one won the game
        int currPlayer = 0; // Player 1 starts the game
        int[] size = {7, 6};
        int[] playfield = new int[size[0] * size[1]]; // Create a value for every tile
        int selectedRow;

        for (int i = 0; i < playfield.length; i++) {
            playfield[i] = -1; // Nobody has claimed any of the tiles
        }


        while (gameWon == -1) { // Until someone has won the game
            // Generate the cli output and show it
            System.out.println(generateDisplay(size[0], playfield));

            // Let the player decide wich row they want to place in
            do {
                System.out.println(players[currPlayer] + ", its your turn!\nEnter a number from 1 to " + size[0]);
                selectedRow = scanner.nextInt() - 1;
            } while (!placeInRow(selectedRow, currPlayer, size[0], playfield)); // Runs the move if valid, loops if else

            // Set the player to the opposite
            currPlayer = (currPlayer + 1) % players.length;

            // Check who won it if any and store the player who won (-1 = nobody)
            gameWon = checkPlayerWon(size[0], playfield);
        }
        // Show the cli output and send congrats to the winner
        System.out.println(generateDisplay(size[0], playfield) +
                "\nCongratulations, " + players[gameWon] + "! You won the game");
    }

    // function to generate cli output
    public static String generateDisplay(int width, int[] gametable) {
        String playfield = "";
        // Loops over every tile and checks its owner
        for (int i = 0; i < gametable.length; i++) { // for every tile
            switch (gametable[i]) {
                case -1:
                    playfield += "🟦"; // Blue if nobody claimed it
                    break;
                case 0:
                    playfield += "🟨"; // Yellow for player 1
                    break;
                case 1:
                    playfield += "🟥"; // Red for player 2
                    break;
            }
            if ((i + 1) % width == 0) {
                playfield += '\n'; // If the full width is reached, make a new line
            }
        }
        return playfield;
    }

    public static int checkPlayerWon(int width, int[] gametable) {
        int counter;
        // Loops over every tile and checks if there are 3 more next to it with the same owner, if there is an owner
        for (int i=0; i < gametable.length; i++) {
            if (gametable[i] != -1) {
                // Check horizontal line
                counter = 0;
                for (int j = i; j < gametable.length; j++) { // goes to right tile every iteration
                    if (gametable[j] == gametable[i] && i / width == j / width) { // if same owner and same vertical line
                        counter++; // Add 1 to the counted tiles with the same owner in a row
                    } else {
                        j = gametable.length; // exit loop if else
                    }
                }
                if (counter >= 4) {
                    return gametable[i];
                }

                // Check vertical line
                counter = 0;
                for (int j = i; j < gametable.length; j += width) { // goes to tile below every iteration
                    if (gametable[j] == gametable[i]) { // if same owner
                        counter++; // Add 1 to the counted tiles with the same owner in a row
                    } else {
                        j = gametable.length; // exit loop if owner isn't the same
                    }
                }
                if (counter >= 4) {
                    return gametable[i];
                }

                // Check downwarts to the right
                counter = 0;
                for (int j = i; j < gametable.length; j += width + 1) { // goes to tile below and right every iteration
                    if (gametable[j] == gametable[i] && i % width <= j % (width + 1)) { // if same owner and right line
                        counter++; // Add 1 to the counted tiles with the same owner in a row
                    } else {
                        j = gametable.length; // exit loop if owner isn't the same
                    }
                }
                if (counter >= 4) {
                    return gametable[i];
                }

                // Check downwarts to the left
                counter = 0;
                for (int j = i; j < gametable.length; j += width - 1) {// goes to tile below and left every iteration
                    if (gametable[j] == gametable[i] && i % width >= j % (width - 1)) { // if same owner and left line
                        counter++; // Add 1 to the counted tiles with the same owner in a row
                    } else {
                        j = gametable.length; // exit loop if owner isn't the same
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
        // Checks if the move is invalid, returns false if it is.
        if (row >= width || row < 0) { // Check if selected row doesn't exist
            System.out.println("\nRow does not exist\n"); // Tells player what's the problem with his move
            return false; // Returns false for en illegal move
        } else if (gametable[row] != -1) { // Check if selected row is full
            System.out.println("\nRow is already full.\n"); // Tells player what's the problem with his move
            return false; // Returns false for en illegal move
        }

        // Gets the first free tile in the row
        for (int i = row; i < gametable.length; i += width) { // For every tile in the row
            if (gametable[i] == -1) {
                row = i; // Set row to the last unowned tile found
            } else {
                i = gametable.length; // Exits loop if there is an owned tile
            }
        }
        gametable[row] = player; // Gives the player ownership over the empty tile
        return true;
    }
}
