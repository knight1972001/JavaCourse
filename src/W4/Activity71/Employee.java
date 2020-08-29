package W4.Activity71;

public class Employee {
    private String name=null;
    private int age=0;
    private int id=0;

    public Employee(int id, String name, int age) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String result;
        result = "- Employee ID: "+this.id+"\n";
        result += "Name: "+this.name+"\n";
        result += "Age: "+this.age+"\n";
        return result;
    }
}
