package _08_oop.oop_principles._01_polymorphism;

public class PolymorphismExample {

	public static void main(String[] args) {
		Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		boss.setBonus(5000);

		Employee[] staff = new Employee[3];

		staff[0] = boss;
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);

		for (Employee e : staff)
			System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());

		// set bonus for all managers
		for (Employee e : staff) {
			if (e instanceof Manager) {
				((Manager) e).setBonus(1000); // type cast is necessary
				System.out.print("Manager: ");
			}
			System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());
		}

	}
}
