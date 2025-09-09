package model.constructorsProject;

public class Parent {

    static {
        System.out.println("Parent static initializer: class being constructed");
    }
    private final String name, dob;
    protected final int siblings;

    {//instance initializer block
//        name = "John Doe";
//        dob = "01/01/1900";
        System.out.println("In Parent Initializer");
    }

//    public Parent() {
//        System.out.println("Parent no args constructor");
//    }

    public Parent(String name, String dob, int siblings) {
        this.name = name;
        this.dob = dob;
        this.siblings = siblings;
        System.out.println("In Parent Constructor");
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "name = '" + name + '\'' + ", dob='" + dob + '\'';
    }
}
