package java1.lesson5;

public abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal(String name, int age, double abilityToRun, double abilityToJump, double abilityToSwim) {
        this.name = name;
        this.age = age;
    }

    public abstract void run(double taskToRun);

    public abstract void jump(double taskToJump);

    public abstract void swim(double taskToSwim);

}
