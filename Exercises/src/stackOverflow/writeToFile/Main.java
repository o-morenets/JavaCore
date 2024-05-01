package stackOverflow.writeToFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Employee> arrayEmployee = new ArrayList<>();

    static boolean save(Employee employee) {
        arrayEmployee.add(employee);
        writeToFile(employee);
        return false;
    }

    static boolean writeToFile(Employee employee) {
        Writer writer = null;
        try {
            writer = new FileWriter("Employee.txt", true);
            for (Employee list : arrayEmployee) {
                writer.write(String.valueOf(list) + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return false;
    }

    static boolean delete(Employee employee) {
        arrayEmployee.remove(employee);
        writeToFile(employee);
        return false;
    }

    static boolean getByName(String name) {
        for (Employee employee : arrayEmployee) {
            if (employee.getName().equals(name)) {
                System.out.println("You found an employee named " + name);
            } else {
                System.out.println("Not found");
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Jack", 30, 10000, "IBM");
        Employee employee2 = new Employee("John", 20, 7000, "Apple");
        save(employee1);
        save(employee2);
        delete(employee1);
        getByName("Jack");
    }
}
