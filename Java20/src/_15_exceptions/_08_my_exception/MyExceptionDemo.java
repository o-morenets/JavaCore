package _15_exceptions._08_my_exception;

class MyException extends Exception {
    private int detail;

    public MyException(int detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "MyEcxeption [detail=" + detail + "]";
    }

}

public class MyExceptionDemo {

    static void compute(int a) throws MyException {
        System.out.println("Method compute(" + a + ")");
        if (a > 10)
            throw new MyException(a);
        System.out.println("Normal finish");
    }

    public static void main(String[] args) {
        try {
            compute(1);
            compute(20);
        } catch (MyException e) {
            System.out.println("Exception caught: " + e);
        }
    }

}