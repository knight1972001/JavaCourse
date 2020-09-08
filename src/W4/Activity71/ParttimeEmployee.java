package W4.Activity71;

import static W4.Activity71.Ultis.convertMoney;

public class ParttimeEmployee extends Employee {
    private int totalWorkingShift = 0;
    final double MEAL_ALLOWANCE = 0;
    private double totalSalary = 0;
    private double baseSalary = 0;

    public ParttimeEmployee(int id, String name, int age, String identificationNumber, int totalWorkingShift, double baseSalary) {
        super(id, name, age, identificationNumber);
        this.totalWorkingShift = totalWorkingShift;
        this.baseSalary = baseSalary;
        this.totalSalary = this.baseSalary * this.totalWorkingShift;
    }

    public void setTotalWorkingShift(int totalWorkingShift) {
        if (this.totalWorkingShift != totalWorkingShift) {
            this.totalWorkingShift = totalWorkingShift;
            totalSalary = this.baseSalary * this.totalWorkingShift;
            System.out.println("Successful Changed\n");
        } else {
            System.out.println("Unsuccessful Changed\n");
        }
    }

    public void setBaseSalary(double baseSalary) {
        if (this.baseSalary != baseSalary) {
            this.baseSalary = baseSalary;
            totalSalary = this.baseSalary * this.totalWorkingShift;
            System.out.println("Successful Changed\n");
        } else {
            System.out.println("Unsuccessful Changed\n");
        }
    }

    public int getID() {
        return super.getId();
    }

    @Override
    public double getMealAllowance() {
        return MEAL_ALLOWANCE;
    }

    @Override
    public double getSalaryRate() {
        return this.baseSalary;
    }

    @Override
    public int getWorkingCount() {
        return totalWorkingShift;
    }

    @Override
    public double calculateSalary() {
        return totalSalary;
    }

    @Override
    public String toString() {
        String result;
        result = super.toString();
        result += "Type: Part-time Employee\n";
        result += "Total Working Shift: " + getWorkingCount() + "\n";
        result += "Meal Allowance: " + convertMoney(getMealAllowance());
        result += "Salary Rate: " + convertMoney(getSalaryRate());
        result += "Total Salary: " + convertMoney(calculateSalary()) + "\n";
        return result;
    }
}
