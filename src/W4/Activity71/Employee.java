package W4.Activity71;

public abstract class Employee {
    private String name = null;
    private int age = 0;
    private int id = 0;
    private String identificationNumber;
    private boolean isFullTime = false;

    public Employee(int id, String name, int age, String identificationNumber) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.identificationNumber = identificationNumber;
    }

    public int getId() {
        return id;
    }

    abstract public double getMealAllowance();
    abstract public double getSalaryRate();
    abstract public int getWorkingCount();
    abstract public double calculateSalary();

    @Override
    public String toString() {
        String result;
        result = "- Employee ID: " + this.id + "\n";
        result += "Name: " + this.name + "\n";
        result += "Age: " + this.age + "\n";
        result += "Identification Number: " + this.identificationNumber + "\n";
        return result;
    }
}
