package stackOverflow.humanSayHello;

public class Program {
	public static void main(String[] args){
		Human Human =new Human();

		Human.sayHello();
	}
	public static class Human{
		public String name;
		public int age;
		Human(){
			this.name="Василий";
			this.age=21;
		}

		public void sayHello(){
			System.out.println("Привет,меня зовут"+name+",мне"+age+"лет");
		}
	}
}