package lvl2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите строку для анализа: ");
        do{
            Matrix.inputString = Matrix.readString();
        } while(Matrix.inputString.length() == 0);
        try {
            Matrix.inputLineToArray();
            Matrix.arrayStringToInt();
            Matrix.arraySumm();
            System.out.println("Результат: " + Matrix.arrayDivideSumm());
        } catch (MatrixException4х4 | MatrixExceptionStringOrInt e){
            System.out.println("MatrixException: " + e.getMessage());
        }
    }
}
