package java1.lesson5;

public class Main {

    public static void main(String[] args) {

        Cat cat0 = new Cat("Moorzeek", 3);
        Dog dog0 = new Dog("Bobeek", 4);
        Cat cat1 = new Cat("Pushok", 1, 250, 2.5, 0.5);
        Cat cat2 = new Cat("Barseek", 8, 15, 1, 1);
        Dog dog1 = new Dog("Barbos", 7, 100, 0.5, 100);
        Dog dog2 = new Dog("Shareek", 1, 700, 2, 50);

        double taskToRun = 150;
        double taskToJump = 0.5;
        double taskToSwim = 1;

        Animal[] pets = {cat0, cat1, cat2, dog0, dog1, dog2};
        for (int i = 0; i < pets.length; i++) {
            pets[i].run(taskToRun);
            pets[i].jump(taskToJump);
            pets[i].swim(taskToSwim);
            System.out.println("");
        }
    }
}
