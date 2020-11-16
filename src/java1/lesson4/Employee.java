package java1.lesson4;

public class Employee {
    private String name;
    private String position;
    private long phoneNumber;
    private double salary;
    private int age;
    private static int counter = 0;
    private final int id;

    public Employee (String name, String position, long phoneNumber, double salary, int age) {
        this.name = name;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
        this.id = counter++;


    }

    public Employee(String name, String position, int id) {
        this.id = id;
        this.getName();
        this.getPosition();
    }


    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
