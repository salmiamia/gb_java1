package java1.lesson3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe5x5 {

    // human
    private static final char DOT_HUMAN = 'X';
    // AI
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '_';
    // humanInput
    private static final Scanner SCANNER = new Scanner(System.in);
    // aiInput
    private static final Random RANDOM = new Random();
    // fieldSizeX
    private static int fieldSizeX;
    // fieldSizeY
    private static int fieldSizeY;
    // field
    private static char[][] field;
    // number of symbols to win
    private static int symToWin = 4;

    // initField
    private static void initField() {
        fieldSizeX = 5;
        fieldSizeY = 5;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }
    // printField
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++)
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        System.out.println();

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++)
                System.out.print(field[i][j] + "|");
            System.out.println();
        }

        for (int i = 0; i <= fieldSizeX * 2 + 1; i++)
            System.out.print("-");
        System.out.println();
    }
    // humanTurn
    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.print("Введите координаты (гор и вер) от 1 до " + fieldSizeX + " через пробел>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[y][x] = DOT_HUMAN;
    }
    // aiTurn
    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));
        field[y][x] = DOT_AI;
    }
    // isCellEmpty
    private static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }
    // isCellValid
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }
    // checkWin
    private static boolean checkWin(char c, int fieldSizeX, int fieldSizeY) {

        //hor
        for (int x = 0; x < fieldSizeX; x++) {
            int counter = 0;
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[x][y] == c) {
                    counter++;
                }
                else {
                    counter = 0;
                }
                if (counter >= symToWin) return true;
            }
        }

        //ver
        for (int y = 0; y < fieldSizeY; y++) {
            int counter = 0;
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[x][y] == c) counter++;
                else {
                    counter = 0;
                }
                if (counter >= symToWin) return true;
            }
        }


//        дальше возникли сложности
//        //dia1
//        int counter = 0;
//        for (int x = 0; x < fieldSizeY; x++) {
//            if (field[x][x] == c) counter++;
//        }
//        if (counter == symToWin) return true;
//


//        //dia2
//        int counter2 = 0;
//        for (int x = 0; x < fieldSizeX; x++) {
//            for (int y = fieldSizeY - 1; y >= 0; y--) {
//                if (field[x][y] == c) counter2++;
//
//            }
//            if (counter2 == symToWin) return true;
//        }

        return false;

    }
    // checkDraw
    private static boolean isDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initField();
        printField();

        while (true) {
            humanTurn();
            printField();
            if (checkWin(DOT_HUMAN, fieldSizeX, fieldSizeY)) {
                System.out.println("Human win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
            aiTurn();
            printField();
            if (checkWin(DOT_AI, fieldSizeX, fieldSizeY)) {
                System.out.println("Computer wins!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
        }
    }
}
