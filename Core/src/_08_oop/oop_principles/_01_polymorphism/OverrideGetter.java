package _08_oop.oop_principles._01_polymorphism;

public class OverrideGetter {

    public static void main(String[] args) {
        Employee employee = new Employee("Emp", 2000, 1987, 4, 30);
        System.out.println(employee.getFavNumber());

        Manager manager = new Manager("Man", 3000, 1998, 10, 23);
        System.out.println(manager.getFavNumber());

        Employee emp_manager = new Manager("Emp_Man", 3500, 2000, 1, 12);
        System.out.println(emp_manager.getFavNumber());
    }
}
