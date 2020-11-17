package java1.lesson5;

public class Cat extends Animal {
    protected static double abilityToRun = 200;
    protected static double abilityToJump = 2;
    protected static double abilityToSwim = 0;

    Cat(String name, int age) {
        super(name, age, abilityToRun, abilityToJump, abilityToSwim);
    }

    Cat(String name, int age, double abilityToRun, double abilityToJump, double abilityToSwim) {
        super(name, age, abilityToRun, abilityToJump, abilityToSwim);
        this.abilityToRun = abilityToRun;
        this.abilityToJump = abilityToJump;
        this.abilityToSwim = abilityToSwim;
    }

    @Override
    public void run(double i) {
        if (this.abilityToRun >= i) System.out.println("Котик " + name + " способен пробежать " + this.abilityToRun + " м., и поэтому сумел пробежать " + i + " м.");
        else System.out.println("Котик " + name + " способен пробежать " + this.abilityToRun + " м., и поэтому " + i + " м. пробежать не смог.");
    }

    @Override
    public void jump(double i) {
        if (this.abilityToJump >= i) System.out.println("Котик " + name + " способен прыгнуть на " + this.abilityToJump + " м., и поэтому сумел прыгнуть на " + i + " м.");
        else System.out.println("Котик " + name + " способен пробежать " + this.abilityToJump + " м., и поэтому " + i + " м. пробежать не смог.");
    }

    @Override
    public void swim(double i) {
        if (this.abilityToSwim >= i) System.out.println("Котик " + name + " способен проплыть " + this.abilityToSwim + " м., и поэтому сумел проплыть " + i + " м.");
        else System.out.println("Котик " + name + " способен проплыть " + this.abilityToSwim + " м., и поэтому " + i + " м. проплыть не смог.");
    }
}