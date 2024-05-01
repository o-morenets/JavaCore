package stackOverflow.replaceAll;

public class Main {

    public static void main(String[] args) {
        String line = "<Users>" +
                " <User>" +
                "  <Name>Alex</Name>" +
                "  <Company>Gazprom</Company>" +
                " </User>" +
                " <User>" +
                "  <Name>Irina</Name>" +
                "  <Company>Lukoil</Company>" +
                " </User>" +
                "</Users";

        String s = line.replaceAll("<Company>.*?</Company>", "<Company>Rosneft</Company>");
        System.out.println("s = " + s);
    }
}
