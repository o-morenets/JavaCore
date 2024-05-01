package stackOverflow.phone;

public class Phone
{
    int number;
    String model;
    int weight;

    Phone()
    {
    }

    Phone(int number, String model, int weight)
    {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return "Phone{" + "number=" + number + ", model='" + model + '\'' + ", weight=" + weight + '}';
    }
}