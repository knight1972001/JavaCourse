package W4.Activity71;

public class FulltimeEmployee extends Employee {
    private double baseSalary = 0;
    private double OTSalary = 0;
    private boolean isManager = false; //e doi level sang isManager vi chi co 2 loai nhan vien. dung True False tien cho viec xu ly hon.
    private double overTimeDay = 0;

    public FulltimeEmployee(int id, String name, int age, boolean isManager, double overTimeDay) {
        super(id, name, age);
        this.isManager = isManager;
        if (this.isManager) {
            this.baseSalary = 20000;
        } else {
            this.baseSalary = 10000;
        }
        this.overTimeDay = overTimeDay;
        this.OTSalary = this.overTimeDay * 800;
    }

    public void setManager(boolean manager) {
        if (this.isManager != manager) {
            isManager = manager;
            if (this.isManager) {
                this.baseSalary = 20000;
            } else {
                this.baseSalary = 10000;
            }
            System.out.println("Successful Changed!\n");
        } else {
            System.out.println("Unsuccessful Changed!\n");
        }
    }

    public void setOverTimeDay(double overTimeDay) {
        if (this.overTimeDay != overTimeDay) {
            this.overTimeDay = overTimeDay;
            this.OTSalary = this.overTimeDay * 800;
            System.out.println("Successful Changed!\n");
        } else {
            System.out.println("Unsuccessful Changed!\n");
        }
    }

    public double getTotalSalary() {
        return baseSalary + OTSalary;
    }

    @Override
    public String toString() {
        String result;
        result = super.toString();
        result += "Type: Full-time Employee\n";
        result += "Level: ";
        if (this.isManager) {
            result += "Manager \n";
        } else {
            result += "Employee \n";
        }
        result += "Base Salary: ";
        if (this.baseSalary > 1000) { //format tien --> de doc hon xiu
            result += this.baseSalary / 1000 + "M\n";
        } else {
            result += this.baseSalary + "K\n";
        }
        result += "Over Time Salary: ";
        if (this.OTSalary > 1000) {
            result += this.OTSalary / 1000 + "M\n";
        } else {
            result += this.OTSalary + "K\n";
        }
        result += "Total Salary: ";
        if (this.getTotalSalary() > 1000) {
            result += this.getTotalSalary() / 1000 + "M\n\n";
        } else {
            result += this.getTotalSalary() + "K\n\n";
        }
        return result;
    }
}
