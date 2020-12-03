package java2.lesson2;

public class Main {

    public static String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 2 0";
    public static String array1[] = str.split("\n");
    public static String arrayString[][] = new String[4][4];
    public static int arrayInt[][] = new int[4][4];

    private static void strToArrStr(String s) {
        for (int i = 0; i < array1.length; i++) {
            String arrayTemp[] = array1[i].split(" ");
            for (int j = 0; j < arrayTemp.length; j++) {
                    arrayString[i][j] = arrayTemp[j];
            }
        }
    }

    private static void arrStrToArrInt(String arrStr[][]) {
        for (int i = 0; i < arrStr.length; i++) {
            for (int j = 0; j < arrStr[i].length; j++) {
                arrayInt[i][j] = Integer.parseInt(arrayString[i][j]);
            }
        }
    }

    private static int calc(int arrInt[][]) {
        int sum = 0;
        for (int i = 0; i < arrInt.length; i++) {
            for (int j = 0; j < arrInt[i].length; j++) {
                sum = sum + arrInt[i][j];
            }
        }
        return sum / 2;
    }

    public static void main(String[] args) {
        try {
            strToArrStr(str);
            for (int i = 0; i < arrayString.length; i++) {
                for (int j = 0; j < arrayString[i].length; j++) {
                    if (arrayString[i][j].isEmpty()) ;
                }
            }
        } catch (Exception e) {
            System.out.println("Полученный массив строк не соответстует размеру 4х4.");
        }

        try {
            arrStrToArrInt(arrayString);
        } catch (Exception e) {
            System.out.println("В массив передано некорректное значение (символ или слово)");
        }

        System.out.println(calc(arrayInt));
    }
}