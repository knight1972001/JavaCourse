package W4.Activity71;

public class ParttimeEmployee extends Employee {
    private double workHourNumber = 0;
    private double salary = 0;

    public ParttimeEmployee(int id, String name, int age, double workHourNumber) {
        super(id, name, age);
        this.workHourNumber = workHourNumber;
        salary = this.workHourNumber * 100;
    }

    public void setWorkHourNumber(double workHourNumber) {
        if (this.workHourNumber != workHourNumber) {
            this.workHourNumber = workHourNumber;
            salary = workHourNumber * 100;
            System.out.println("Successful Changed\n");
        } else {
            System.out.println("Unsuccessful Changed\n");
        }
    }

    public int getID() {
        return super.getId();
    }

    @Override
    public String toString() {
        String result;
        result = super.toString();
        result += "Type: Part-time Employee\n";
        result += "Number of Hours-work: " + this.workHourNumber + "\n";
        result += "Salary: ";
        if (this.salary > 1000) { //format tien --> de doc hon xiu
            result += salary / 1000 + "M\n\n";
        } else {
            result += salary + "K\n\n";
        }
        return result;
    }
}
