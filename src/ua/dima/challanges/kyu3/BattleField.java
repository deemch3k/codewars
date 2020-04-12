package ua.dima.challanges.kyu3;

/*
Write a method that takes a field for well-known board game "Battleship" as an argument and returns true if it has
 a valid disposition of ships, false otherwise. Argument is guaranteed to be 10*10 two-dimension array.
 Elements in the array are numbers, 0 if the cell is free and 1 if occupied by ship.

Battleship (also Battleships or Sea Battle) is a guessing game for two players.
Each player has a 10x10 grid containing several "ships" and objective is to
destroy enemy's forces by targetting individual cells on his field. The ship occupies one or more cells in the grid.
Size and number of ships may differ from version to version. In this kata we will use Soviet/Russian version of the game.


Before the game begins, players set up the board and place the ships accordingly to the following rules:
There must be single battleship (size of 4 cells), 2 cruisers (size 3), 3 destroyers (size 2) and 4 submarines (size 1).
Any additional ships are not allowed, as well as missing ships.
Each ship must be a straight line, except for submarines, which are just single cell.
 */

import java.util.Arrays;

public class BattleField {

    public static boolean fieldValidator(int[][] field) {

        final int WALL = -1;
        boolean runWhile;
        int counter = 0;
        int[] res = {0, 0, 0, 0, 0};
        boolean isVertical;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 1) {
                    runWhile = true;
                    isVertical = true;
                    while (runWhile) {
                        if (i + counter < field.length && field[i + counter][j] == 1 && isVertical) {
                            if (i + counter + 1 < field.length && j + 1 < field.length)
                                if (field[i + counter + 1][j + 1] == 1 || field[i + counter + 1][j + 1] == -1)
                                    return false;
                            field[i + counter][j] = WALL;
                            counter++;
                        } else if (j + counter < field.length && field[i][j + counter] == 1) {
                            if (j + counter + 1 < field.length && i + 1 < field.length)
                                if (field[i + 1][j + counter + 1] == 1 || field[i + 1][j + counter + 1] == -1)
                                    return false;
                            field[i][j + counter] = WALL;
                            counter++;
                            if (counter >= 2) isVertical = false;
                        } else if (j + counter >= field.length
                                || field[i][j + counter] == WALL
                                || field[i][j + counter] == 0
                                || field[i + counter][j] != 1
                        ) {
                            if (counter > 4) return false;
                            res[counter]++;
                            counter = 0;
                            runWhile = false;
                        } else if (i + counter >= field.length
                                || field[i + counter][j] == WALL
                                || field[i + counter][j] == 0
                                || field[i][j + counter] != 1
                        ) {
                            if (counter > 4) return false;
                            res[counter]++;
                            counter = 0;
                            runWhile = false;
                        }
                    }
                }
            }
        }

        int[] valid = {0, 4, 3, 2, 1};
        return Arrays.equals(res, valid);
    }

}
