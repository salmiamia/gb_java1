package java1.lesson1;

public class Main {

    public static void main(String[] args) {
        Task1(1, 3, 5, 10);
        Task2(4, 8);
        System.out.println(Task3(-5));
        System.out.println(Task4("Вася"));
        System.out.println(yearPrint(300));
    }

    public static double Task1 (int a, int b, int c, int d) {
        return a * (b + ((c * 1.0)/ d));
    }

    public static boolean Task2 (int a, int b) {
        boolean result = false;
        int c = a + b;
        if ( c >= 10 && c <= 20) {
            result = true;
        }
        return result;
    }

    public static boolean Task3 (int a) {
        return a >= 0;
    }

    public static String Task4 (String name) {
        return "Привет, " + name + "!";
    }

    public static boolean year(int i) {
        if (i % 400 == 0) return true;
        else if (i % 100 == 0) return false;
        else return i % 4 == 0;
    }

    public static String yearPrint(int i) {
        return "Год " + i + (year(i) ?  "" :  " не") + " является високосным.";
    }
}
