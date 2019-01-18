package ticTacToe;


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean gameOver = false;
        String result;
        char[][] fieldValues = init();
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            draw(fieldValues);
            result = checkState(fieldValues);
            if ("Game not finished.".equals(result)) {
                System.out.print("Enter the coordinates: ");
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                fieldValues = humanMove(x, y, fieldValues);
            } else {
                System.out.println();
                System.out.println(result);
                gameOver = true;
            }
        }
    }

    private static char[][] init() {
        Random random = new Random();
        char[][] fieldValues = new char[3][3];
        String values = "XO ";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int index = random.nextInt(3);
                fieldValues[i][j] = values.charAt(index);
            }
        }
        return  fieldValues;
    }

    private static char[][] humanMove(int x, int y, char[][] fieldValues) {
        if (fieldValues[x][y] == ' ') {
            fieldValues[x][y] = 'X';
        } else {
            System.out.println("Incorrect input. Try again.");
        }
        return fieldValues;
    }

    private static String checkState(char[][] fieldValues) {


        for (int i = 0; i < 3; i++) {
            int col = 0;
            int row = 0;

            //row check{
            if (fieldValues[i][0] == fieldValues[i][1] && fieldValues[i][0] == fieldValues[i][2] && fieldValues[i][0] != ' ') {
                row++;
            }

            if (row == 1) {
                if (fieldValues[i][0] == 'X') {
                    return "X wins.";
                } else {
                    return "O wins.";
                }
            }

            //col check
            if (fieldValues[0][i] == fieldValues[1][i] && fieldValues[0][i] == fieldValues[2][i] && fieldValues[0][i] != ' ') {
                col++;
            }

            if (col == 1) {
                if (fieldValues[0][i] == 'X') {
                    return "X wins.";
                } else {
                    return "O wins.";
                }
            }
        }

        //diagonal check
        if (fieldValues[0][0] == fieldValues[1][1] && fieldValues[1][1] == fieldValues[2][2] && fieldValues[0][0] != ' ') {
            if (fieldValues[0][0] == 'X') {
                return "X wins.";
            } else {
                return "O wins.";
            }
        }
        if (fieldValues[0][2] == fieldValues[1][1] && fieldValues[1][1] == fieldValues[2][0] && fieldValues[0][2] != ' ') {
            if (fieldValues[0][2] == 'X') {
                return "X wins.";
            } else {
                return "O wins.";
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (fieldValues[i][j] == ' ') {
                    return "Game not finished.";
                }
            }
        }

        return "Draw.";
    }

    private static void draw(char[][] fieldValues) {
        System.out.println("\t---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("\t| ");
            for (int j = 0; j < 3; j++) {
                if (j < 2) {
                    System.out.print(fieldValues[i][j] + " ");
                } else {
                    System.out.print(fieldValues[i][j]);
                }
            }
            System.out.print(" |");
            System.out.println();
        }
        System.out.println("\t---------");
    }
}