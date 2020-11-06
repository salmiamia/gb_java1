package java1.lesson2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arrayA = new int[] {1,0,0,0,0,1,1,1,0,1,0};
        int[] arrayB = new int[8];
        int[] arrayC = new int[] {1,5,3,2,11,4,5,2,4,8,9,1};
        int[] arrayD = new int[] {12,5,46,26,44,-34,96,164,78,3,45,-3};
        int[][] arrayE = new int[9][9];
        int[] arrayF = new int[] {2,5,1,3,4,5,2,3,5,10};
        int[] arrayG = new int[] {1,2,3,4,5,6,7,8};
        int n = -18;

        System.out.println("Решение задачи 1: " + Arrays.toString(Task1(arrayA)));
        System.out.println("Решение задачи 2: " + Arrays.toString(Task2(arrayB)));
        System.out.println("Решение задачи 3: " + Arrays.toString(Task3(arrayC)));
        System.out.println("Решение задачи 4: " + Task4(arrayD));
        System.out.println("Решение задачи 5:"); Task5Print(Task5(arrayE));
        System.out.println("Решение задачи 6: " + Task6(arrayF));
        System.out.println("Решение задачи 7: " + Arrays.toString(Task7(arrayG, n)));
    }

//1.
//Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;

    public static int[] Task1(int[] arrayA) {
        for (int i = 0; i < arrayA.length; i++) {
            if(arrayA[i] == 1){
                arrayA[i] = 0;
            }
            else arrayA[i] = 1;
        }
        return arrayA;
    }

//2.
//Задать пустой целочисленный массив размером 8.
//Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;

    public static int[] Task2(int[] arrayB) {
        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = i * 3 + 1;
        }
        return arrayB;

    }

//3.
//Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
//написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;

    public static int[] Task3(int[] arrayC) {
        for (int i = 0; i < arrayC.length; i++) {
            if (arrayC[i] < 6) {
                arrayC[i] = arrayC[i] * 2;
            }
        }
        return arrayC;
    }

//4.
//Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;

        public static String Task4(int[] arrayD) {
        int min = arrayD[0];
        int max = arrayD[0];

            for (int i = 1; i < arrayD.length; i++) {
               if (arrayD[i] < min) min = arrayD[i];
               if (arrayD[i] > max) max = arrayD[i];
                }

        return "Минимальное значение " + min + ", максимальное значение " + max;
        }

//5.
//Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
//заполнить его диагональные элементы единицами, используя цикл(ы);

    public static int[][] Task5(int[][] arrayE) {
        for (int i = 0; i < arrayE.length; i++) {
                arrayE[i][i] = 1;
                arrayE[i][arrayE.length - 1 - i] = 1;
            }
        return arrayE;
    }

    public static void Task5Print(int[][] squareArray) {
        for (int i = 0; i < squareArray.length; i++) {
            for (int j = 0; j < squareArray.length; j++) {
                System.out.printf("%3d", squareArray[i][j]);
            }
            System.out.println("");
        }
    }

//6.
//Написать метод, в который передается не пустой одномерный целочисленный массив,
//метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
//Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
//checkBalance ([10, || 1, 2, 3, 4]) → true.
//Абстрактная граница показана символами ||, эти символы в массив не входят.

    public static boolean Task6 (int [] arrayF) {
        int sum = 0;
        int check = 0;
        for (int i = 0; i < arrayF.length; i++) {
            sum = sum + arrayF[i];
        }
        int halfsum = sum / 2;

        if (sum % 2 != 0) return false;
        else for (int i = 0; i < arrayF.length; i++) {
            check = check + arrayF[i];
            if (check == halfsum) return true;
        }
        return false;
    }

//7.
//Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным или отрицательным),
//при этом метод должен циклически сместить все элементы массива на n позиций.

    public static int [] Task7(int [] arrayG, int n) {
        int mN = Math.abs(n);
        int move = 0;
        if (mN >= arrayG.length) {
            move = mN - arrayG.length * (mN / arrayG.length);
        }
        else move = mN;

        int[] array2 = new int[arrayG.length];

        if (n > 0) {
            for (int i = 0; i < arrayG.length - move; i++) {
                array2[i + move] = arrayG[i];
            }
            for (int i = arrayG.length - move; i < arrayG.length; i++) {
                array2[i + move - arrayG.length] = arrayG[i];
            }
        }
        else if (n < 0) {
            for (int i = move; i < arrayG.length; i++) {
                array2[i - move] = arrayG[i];
            }
            for (int i = 0; i < move; i++) {
                array2[i + arrayG.length - move] = arrayG[i];
            }
        }
        else array2 = arrayG;
        return array2;
    }
}