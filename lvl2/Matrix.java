package lvl2;

import java.util.Scanner;

public class Matrix {
       private static int tmp;
       private static final int MATRIX_SIZE = 4;
       private static int matrixHeight;
       private static int matrixWidth;
       static String inputString;
       private static double summArray;
       private static String[][] matrixString;
       private static int[][] matrixInt;
       private static Scanner scanInput = new Scanner(System.in);

       static String readString(){
           return scanInput.nextLine();
       }

       static void inputLineToArray() throws MatrixException4х4{
           String firstDelimiter = "\\\\n";
           String secondDelimiter = " ";
           String[] rows = inputString.split(firstDelimiter);

           matrixHeight = rows.length;
           String[] cols = rows[0].split(secondDelimiter);
           matrixWidth = cols.length;

           if(matrixHeight != MATRIX_SIZE || matrixWidth != MATRIX_SIZE){
               throw new MatrixException4х4("матрицы, полученной из строки, не равен 4x4;" + " Height " + matrixHeight + " Width " + matrixWidth + "." );

           }

           matrixString = new String[matrixHeight][matrixWidth];
           for (int y = 0; y< matrixHeight; y++) {
               String[] col = rows[y].split(secondDelimiter);
               for (int x = 0; x < matrixWidth; x++) {
                   matrixString[y][x] = col[x];
               }
           }
       }

       static void arrayStringToInt() throws MatrixExceptionStringOrInt{
           matrixInt = new int[matrixHeight][matrixWidth];

           for (int y = 0; y < matrixHeight; y++) {
               for (int x = 0; x < matrixWidth; x++) {

                   try{
                       tmp = Integer.parseInt(matrixString[y][x]);
                       matrixInt[y][x] = tmp;
                   } catch (NumberFormatException e){
                       throw new MatrixExceptionStringOrInt("Одно из значений матрицы не является int." + " Value " + matrixString + " Row " + y + " Column " + x + "." );
                   }
               }
           }
       }

       static  void arraySumm(){
           for (int y = 0; y < matrixHeight; y++) {
               for (int x = 0; x < matrixWidth; x++) {
                   summArray += matrixInt[y][x];
               }
           }
       }

       static double arrayDivideSumm(){
           return summArray / 2;
       }
}