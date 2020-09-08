package W4.Activity71;

import static W4.Activity71.Ultis.convertMoney;

public class FulltimeEmployee extends Employee {
    private final double MEAL_ALLOWANCE = 2000;
    private double dailySalary = 0;
    private int totalWorkingHours = 0;
    private double totalSalary = 0;

    public FulltimeEmployee(int id, String name, int age, String identificationNumber, int totalWorkingHours, double dailySalary) {
        super(id, name, age, identificationNumber);
        this.totalWorkingHours = totalWorkingHours;
        this.dailySalary = dailySalary;
        this.totalSalary = this.totalWorkingHours * this.dailySalary + MEAL_ALLOWANCE;
    }

    public void setTotalWorkingHours(int totalWorkingHours) {
        if (this.totalWorkingHours != totalWorkingHours) {
            this.totalWorkingHours = totalWorkingHours;
            this.totalSalary = this.totalWorkingHours * this.dailySalary + MEAL_ALLOWANCE;
            System.out.println("Successful Changed!\n");
        } else {
            System.out.println("Unsuccessful Changed!\n");
        }
    }

    public void setDailySalary(double dailySalary) {
        if (this.dailySalary != dailySalary) {
            this.dailySalary = dailySalary;
            this.totalSalary = this.totalWorkingHours * this.dailySalary + MEAL_ALLOWANCE;
            System.out.println("Successful Changed!\n");
        } else {
            System.out.println("Unsuccessful Changed!\n");
        }
    }

    @Override
    public double getMealAllowance() {
        return MEAL_ALLOWANCE;
    }

    @Override
    public double getSalaryRate() {
        return dailySalary;
    }

    @Override
    public int getWorkingCount() {
        return totalWorkingHours;
    }

    @Override
    public double calculateSalary() {
        return totalSalary;
    }

    @Override
    public String toString() {
        String result;
        result = super.toString();
        result += "Type: Full-time Employee\n";
        result += "Meal Allowance: " + convertMoney(getMealAllowance());
        result += "Total Working Hours: " + getWorkingCount() + "\n";
        result += "Daily Salary: " + convertMoney(getSalaryRate());
        result += "Total Salary: " + convertMoney(calculateSalary()) + "\n";
        return result;
    }
}
