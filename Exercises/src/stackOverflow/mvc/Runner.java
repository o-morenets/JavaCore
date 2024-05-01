package stackOverflow.mvc;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        IModel model = new Model();
        IView view = new View();
        Controller controller = new Controller(model, view);
        controller.process();

        model = new ErrModel();
        view = new ErrView();
        controller = new Controller(model, view);
        controller.process();
    }
}

interface IModel {
    String getName();
    int getAge();
    void setName(String name);
    void setAge(int age);
}

interface IView {
    void showStudent(String name, int age);
}

class Controller {
    private IModel model;
    private IView view;

    Controller(IModel model, IView view) {
        this.model = model;
        this.view = view;
    }

    public void process() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name:");
        String name = sc.next();
        System.out.println("Enter age:");
        int age = sc.nextInt();

        model.setName(name);
        model.setAge(age);

        view.showStudent(model.getName(), model.getAge());
    }
}


class Model implements IModel {
    private int age;
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }
}


class View implements IView {

    @Override
    public void showStudent(String name, int age) {
        System.out.println("name  " + name + "age  " + age);
    }
}

class ErrModel implements IModel {
    private String name;
    private int age;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }
}

class ErrView implements IView {

    @Override
    public void showStudent(String name, int age) {
        System.err.println("name  " + name + "age  " + age);
    }
}