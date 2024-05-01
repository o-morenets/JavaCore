package stackOverflow.proxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Person person = new Person();

        IPerson personProxy = (IPerson) Proxy.newProxyInstance(
                Person.class.getClassLoader(),
                Person.class.getInterfaces(),
                new NeverSleepingEye(person)
        );

        personProxy.setName("Гриша");
        String personProxyName = personProxy.getName();
        System.out.println("personProxyName = " + personProxyName);

        personProxy.rename("Вася");
        personProxyName = personProxy.getName();
        System.out.println("personProxyName = " + personProxyName);

    }
}
