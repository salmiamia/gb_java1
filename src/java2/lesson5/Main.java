package java2.lesson5;

public class Main extends Thread {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void arCreatedA() {

        float[] arr = new float[size]; // Объявление и выделение памяти для массива

        // Заполняем массив единицами
        for (int i = 0; i < size; i++) {
            arr[i] = (float) 1.0;
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        float deltaTime = (System.currentTimeMillis() - startTime); // Сколько выполнялся

        System.out.println(deltaTime + " millisec");
    }

    public static void arCreatedB() {

        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        // Заполняем массив единицами
        for (int i = 0; i < size; i++) {
            arr[i] = (float) 1.0;
        }

        long startTime = System.currentTimeMillis(); // Начало выполнения

        // Разбиваем массив
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        // Применение формулы, используя потоки
        Action a = new Action();
        a.array = a1;
        a.h = 0;
        Action b = new Action();
        b.array = a2;
        b.h = h;
        a.start();
        b.start();

        while (a.isAlive()) {
            if (a.getArrayModify() != null) a1 = a.getArrayModify();
        }
        while (b.isAlive()) {
            if (b.getArrayModify() != null) a2 = b.getArrayModify();
        }

        // Склеиваем массив
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        float deltaTime = (System.currentTimeMillis() - startTime); // Сколько выполнялся
        System.out.println(deltaTime + " millisec");
    }

    public static void main(String[] args) {


        // Многопоточность
        arCreatedA();
        arCreatedB();
    }
}