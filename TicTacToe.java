package Yrok_3;



import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static char[][] map; //поле
    private static int SIZE = 3; //размер поле
    private static final char DOT_EMPTY = '.'; // Пустой симвл. свободное поле
    private static final char DOT_X = 'X'; // игрок
    private static final char DOT_O = 'O'; // PC
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();


    public static void main(String[] args) {
     initMap();
     printMap();

     while(true){
         humanTurn(); // Ход человека
         if(isEndGame(DOT_X)){
             break;
         }

         skaynet(); // ХОД AI
         if(isEndGame(DOT_O)){
             break;
         }
     }

        System.out.println("Игра закончена");
    }

    private static void initMap(){ //Метод игрового поле
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
               map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap(){ // Метод вывода игрового поле на экран
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] +  " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    private static void humanTurn() {
        int x, y;

        do {
            System.out.println("Введите координаты ячейки через пробел");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));

        map[x][y] = DOT_X;
    }

    private static void skaynet() {
        int x = -1;
        int y = -1;


            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));

        System.out.println("Скайнет выбрал ячейку " + (y + 1) + " " + (x + 1));
        map[x][y] = DOT_O;
    }

    private static boolean isCellValid(int x, int y){
        boolean result = true;

        if(x < 0 || x >= SIZE || y < 0 || y >= SIZE){
            result = false;
        }

        if(map[x][y] != DOT_EMPTY){
            result = false;
        }
        return result;
    }

    private static boolean isEndGame(char PlayerSymbol){
        boolean result = false;

        printMap();

        if(checkWin(PlayerSymbol)){
            System.out.println("Победили " + PlayerSymbol);
            result = true;
        }

        if(isMapFull()){
            System.out.println("Ничья");
            result = true;
        }
        return result;
    }

    private static boolean isMapFull(){
        boolean result = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(map[i][j] == DOT_EMPTY);
                result = false;
            }
        }
        return result;
    }

    private static boolean checkWin(char PlayerSymbol){
        boolean result = false;

        if(
        (map[0][0] == PlayerSymbol && map[0][1] ==  PlayerSymbol && map[0][2] == PlayerSymbol)||
        (map[1][0] == PlayerSymbol && map[1][1] ==  PlayerSymbol && map[1][2] == PlayerSymbol)||
        (map[2][0] == PlayerSymbol && map[2][1] ==  PlayerSymbol && map[2][2] == PlayerSymbol)||
        (map[0][0] == PlayerSymbol && map[1][1] ==  PlayerSymbol && map[2][0] == PlayerSymbol)||
        (map[0][1] == PlayerSymbol && map[1][1] ==  PlayerSymbol && map[2][1] == PlayerSymbol)||
        (map[0][2] == PlayerSymbol && map[1][2] ==  PlayerSymbol && map[2][2] == PlayerSymbol)||
        (map[0][0] == PlayerSymbol && map[1][1] ==  PlayerSymbol && map[2][2] == PlayerSymbol)||
        (map[2][0] == PlayerSymbol && map[1][1] ==  PlayerSymbol && map[0][2] == PlayerSymbol)){
            result = true;
        }
        return result;
    }

        private static boolean checkCirclewin(char PlayerSymbol){

        boolean isCheckedDiagB, isCheckedDiagS;
        isCheckedDiagB = isCheckedDiagS = true;

            for (int diag = 0; diag < SIZE; diag++) {

                boolean isRow, isCol;
                isRow = isCol = true;

                for (int i = 0; i < SIZE; i++) {
                    isRow = (map[diag][i] == PlayerSymbol) && isRow;
                    isCol = (map[i][diag] == PlayerSymbol) && isCol;
                    if(i == diag){
                        isCheckedDiagB = (map[diag][diag] == PlayerSymbol) && isCheckedDiagB;
                        isCheckedDiagS = (map[diag][SIZE - 1 - diag] == PlayerSymbol) && isCheckedDiagS;
                    }
                }
                if(isRow || isCol) return true;
            }
        if(isCheckedDiagB || isCheckedDiagS) return true;
        return false;
    }

    private static boolean checkCircleWin(char PlayerSymbol, int size, int whenWon){

        int sumDiagB, sumDiagS;
        sumDiagB = sumDiagS = 0;

        for (int diag = 0; diag < SIZE; diag++) {

            int sumRow, sumCol;
            sumRow = sumCol = 0;

            for (int i = 0; i < SIZE; i++) {
                sumRow += (map[diag][i] == PlayerSymbol) ? 1 : -1;
                sumCol += (map[i][diag] == PlayerSymbol) ? 1 : -1;
                if(i == diag){
                    sumDiagB += (map[diag][diag] == PlayerSymbol) ? 1 : -1;
                    sumDiagS += (map[diag][SIZE - 1 - diag] == PlayerSymbol) ? 1 : -1;
                }
                if(sumRow >= whenWon || sumCol >= whenWon) return true;
                if(sumRow < 0) sumRow = 0;
                if(sumCol <0) sumCol = 0;
            }
            if(sumDiagB >= whenWon || sumDiagS >= whenWon) return true;
            if(sumDiagB < 0) sumDiagB = 0;
            if(sumDiagS <0) sumDiagS = 0;
        }

        return false;
    }

    private void skynetImp(){
        int turn[];
        do{
            turn = searchAiPlace();
            if(turn[0] == -1){
                turn = new int[]{random.nextInt(SIZE), random.nextInt(SIZE)};
            }
        } while(!isCellValid(turn[1], turn[0]));
        map[turn[0]][turn[1]] = DOT_O;
    }

    int[] searchAiPlace() {

        int[] place = new int[]{-1, -1};
       int sumR, sumC;

        for (int i = 0; i < SIZE; i++) {
            sumR = sumC = 0;
            for (int j = 0; j < SIZE; j++) {
                sumR +=(map[i][j] == DOT_X) ? 1 : (map[i][j] == DOT_EMPTY) ? 0 : 1;
                sumC +=(map[i][j] == DOT_X) ? 1 : (map[i][j] == DOT_EMPTY) ? 0 : 1;
            }
            if(SIZE - 1 == Math.abs(sumR)){
                for (int j = 0; j < SIZE; j++) {
                    if(map[i][j] == DOT_EMPTY) place = new int[]{i, j};
                }
                if(1 - SIZE == sumR) return place;
            }
            if(SIZE - 1 == Math.abs(sumC)){
                for (int j = 0; j < SIZE; j++) {
                    if(map[j][i] == DOT_EMPTY) place = new int[]{j, i};
                }
                if(1 - SIZE == sumC) return place;
            }
        }

        int sumDiagB, sumDiagS;
        sumDiagB = sumDiagS = 0;
        for (int i = 0; i < SIZE; i++) {
            sumDiagB += (map[i][i] == DOT_X) ? 1 : (map[i][i] == DOT_EMPTY) ? 0 : 1;
            sumDiagS += (map[i][SIZE - 1 - i] == DOT_X) ? 1 : (map[i][SIZE - 1 - i] == DOT_EMPTY) ? 0 : 1;
        }
        if(1 - SIZE == sumDiagB){
            for (int i = 0; i < SIZE; i++) {
                if(map[i][i] == DOT_EMPTY) return new int[]{i, i};
            }
        }
        if(1 - SIZE == sumDiagS){
            for (int i = 0; i < SIZE; i++) {
                if(map[i][SIZE - 1 -i] == DOT_EMPTY) return new int[]{i, SIZE - 1 - i};
            }
        }
        if(1 - SIZE == sumDiagB){
            for (int i = 0; i < SIZE; i++) {
                if(map[i][i] == DOT_EMPTY) return new int[]{i, i};
            }
        }
        if(1 - SIZE == sumDiagS){
            for (int i = 0; i < SIZE; i++) {
                if(map[i][SIZE - 1 -i] == DOT_EMPTY) return new int[]{i, SIZE - 1 - i};
            }
        }
        return place;
    }
}
