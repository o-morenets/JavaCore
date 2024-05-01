package jat.classExceptions;

public class ClassNotFoundExceptionExample {
    public static void givenNoDrivers_whenLoadDriverClass_thenClassNotFoundException() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        givenNoDrivers_whenLoadDriverClass_thenClassNotFoundException();
    }
}