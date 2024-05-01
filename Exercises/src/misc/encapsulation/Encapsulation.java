package misc.encapsulation;

public class Encapsulation {
    private /* int */ double age;

    public int getAge() {
        return (int) age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAge(double age) {
        this.age = age;
    }
}
