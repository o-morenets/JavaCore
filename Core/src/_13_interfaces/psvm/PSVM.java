package _13_interfaces.psvm;

/**
 * We can run it (since java 11)
 * java _13_interfaces.psvm.PSVM.java arg1 arg2 "arg 3" etc...
 */
public interface PSVM {

    static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
