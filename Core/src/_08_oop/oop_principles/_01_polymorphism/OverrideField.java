package _08_oop.oop_principles._01_polymorphism;

public class OverrideField {

    public static void main(String[] args) {
        Employee employee = new Employee("Emp", 2000, 1987, 4, 30);
        System.out.println(employee.empNumber);
        System.out.println(employee.favNumber);

        Manager manager = new Manager("Man", 3000, 1998, 10, 23);
        System.out.println(manager.empNumber);
        System.out.println(manager.favNumber);

        Employee emp_manager = new Manager("Emp_Man", 3500, 2000, 1, 12);
        System.out.println(emp_manager.empNumber);
        System.out.println(emp_manager.favNumber);
    }
}
