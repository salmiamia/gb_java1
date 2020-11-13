package java1.lesson4;

public class Main {
    public static void main(String[] args) {

        Employee e1 = new Employee("Kazakov Victor", "waiter", 1352467, 35000, 20);
        System.out.println(e1.getName() + ", " + e1.getPosition());
        System.out.println("");

        Employee arrEmployees[] = new Employee[5];

        arrEmployees[0] = new Employee("Ivanov Petr", "manager", 1234567, 75000, 25);
        arrEmployees[1] = new Employee("Smirnov Nikolay", "plumper", 1456782, 55000, 57);
        arrEmployees[2] = new Employee("Kuznetsov Oleg", "driver", 4237831, 75000, 61);
        arrEmployees[3] = new Employee("Popov Denis", "bartender", 2876543, 52000, 22);
        arrEmployees[4] = new Employee("Samoilov Eugene", "analyst", 1352467, 66000, 43);

        System.out.println("Сотрудники старше 40 лет:");
        for (int i = 0; i < arrEmployees.length; i++) {
            if (arrEmployees[i].getAge() > 40) {
                System.out.println(arrEmployees[i].getName() + ", " + arrEmployees[i].getPosition() + ", " + arrEmployees[i].getPhoneNumber() + ", " + arrEmployees[i].getSalary() + ", " + arrEmployees[i].getAge());
            }
        }
        System.out.println("");

        salaryRaise(arrEmployees, 45, 5000);

        averageSalariesAges(arrEmployees);

        System.out.println("");
        for (int i = 0; i < arrEmployees.length; i++) {
            System.out.println("#" + arrEmployees[i].getId() + " " + arrEmployees[i].getName());
        }
    }

    private static void salaryRaise(Employee arr[], int age, float delta) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getAge() > age) {
                arr[i].setSalary(arr[i].getSalary() + 5000);
            }
        }
    }

    private static void averageSalariesAges(Employee arr[]) {
        double sumSalaries = 0;
        int sumAges = 0;
        for (int i = 0; i < arr.length; i++) {
            sumSalaries = sumSalaries + arr[i].getSalary();
            sumAges = sumAges + arr[i].getAge();
        }
        double avSalary = sumSalaries / arr.length;
        float avAge = sumAges / arr.length;
        System.out.println("Средняя зарплата: " + avSalary + ", средний возраст: " + avAge);
    }

}
