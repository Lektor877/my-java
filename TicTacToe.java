package Yrok_3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static char[][]  map;
    private static char SIZE = 4;
    private static final char DOT_EMPTY = '.';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while(true){
            humanTurn();
            if(isEndGame(DOT_X)){
                break;
            }

            skynetTurn();
            if(isEndGame(DOT_O)){
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    private static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap(){
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void humanTurn(){
    int x, y;
    do{
        System.out.println("Введите координаты ячейки (X Y");
        x = scanner.nextInt() - 1;
        y = scanner.nextInt() - 1;
    } while (isCellValid(x, y));

    map[x][y] = DOT_X;
    }

    private static void skynetTurn() {
        int x = -1;
        int y = -1;
        boolean skynetWin = false;
        boolean humanWin = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O)) {
                        x = i;
                        y = j;
                        skynetWin = true;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        if (!skynetWin) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (isCellValid(i, j)) {
                        map[i][j] = DOT_X;
                        if (checkWin(DOT_X)) {
                            x = i;
                            y = j;
                            humanWin = true;
                        }
                        map[i][j] = DOT_EMPTY;
                    }

                }
            }
        }
        if (!skynetWin && !humanWin) {

            int neighbours = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_EMPTY) {
                        int temp = checkNeighbours(i, j);
                        if (temp > neighbours) {
                            neighbours = temp;
                            x = 1;
                            y = 1;
                        }
                    }
                }
            }
            if (neighbours == 0) {
                do {
                    x = random.nextInt(SIZE);
                    y = random.nextInt(SIZE);
                } while (isCellValid(x, y));
            }
        }
        System.out.println("Скайнет выбрал ячейку " + (x + 1) + " " + (y + 1));
        map[x][y] = DOT_O;
    }

    public static int checkNeighbours(int x, int y){
        int quantity = 0;
        for (int i = 0; i <= x + 1; i++) {
            for (int j = 0; j <= y + 1 ; j++) {
                if(!isCellExist(i, j) && map[i][j] == DOT_O){
                    quantity++;
                }
            }
        }
        return quantity;
    }

    public static boolean isCellValid(int x, int y) {
        boolean result = true;
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            result = false;
        } else if (map[x][y] != DOT_EMPTY) {
            result = false;
        }
        return !result;
    }

    public static boolean isCellExist(int x, int y){
    boolean result = true;
    if(x < 0 || x >= SIZE || y < 0 || y >= SIZE){
        result = false;
    }
    return result;
    }

    private static boolean isEndGame(char playerSymbol){
        boolean result = false;
        printMap();
        if(checkWin(playerSymbol)){
            System.out.println("Победили " + playerSymbol);
            result = true;
        } else if(isMapFull()){
            System.out.println("Ничья");
            result = true;
        }
        return result;
    }

    private static boolean isMapFull(){
        boolean result = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(map[i][j] == DOT_EMPTY)
                    result = false;
            }
        }
        return result;
    }

    public static boolean checkStraight(int line, int column, int x, int y, char playerSymbol){
        for (int i = 0; i < SIZE; i++) {
            if(map[line + i * x][column + i * y] != playerSymbol)
                return false;
        }
        return true;
    }

    public static boolean checkWin(char playerSymbol){
        for (int i = 0; i < SIZE; i++) {
            if(checkStraight(i, 0, 0, 1, playerSymbol)){
                return  true;
            }
            if(checkStraight(0, i, 1, 0, playerSymbol)){
                return  true;
            }
        }
        if(checkStraight(0, 0, 1, 1, playerSymbol)){
            return  true;
        }
        if(checkStraight(0, SIZE -1, 1, -1, playerSymbol)){
            return  true;
        }
        return false;
    }
}
