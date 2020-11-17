package java1.lesson5;

public abstract class Animal {
    protected String name;
    protected int age;
    protected double abilityToRun;
    protected double abilityToJump;
    protected double abilityToSwim;

    public Animal(String name, int age, double abilityToRun, double abilityToJump, double abilityToSwim) {
        this.name = name;
        this.age = age;
        this.abilityToRun = abilityToRun;
        this.abilityToJump = abilityToJump;
        this.abilityToSwim = abilityToSwim;
    }

    public abstract void run(double taskToRun);

    public abstract void jump(double taskToJump);

    public abstract void swim(double taskToSwim);

}
