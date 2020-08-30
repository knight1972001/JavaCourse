package W4.Activity71;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static W4.Activity71.Ultis.*;
import static W4.Exercise64.Ultis.hasOrNot;

public class EmployeeManagement {
    private String companyName = null;
    private int countEmployee = 0;
    private final List<Employee> employees = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    Menu mainMenu;
    Menu subMenu1;
    Menu subMenu2;

    public EmployeeManagement(String companyName, int num) throws ParseException {
        this.companyName = companyName;
        System.out.println("Welcome to " + companyName);
        for (int i = 0; i < num; i++) {
            System.out.println("- Employee num.(" + (i + 1) + "):");
            addEmployee();
        }
        mainMenu = new Menu("Employee Management App:");
        mainMenu.add("List all Employees.");
        mainMenu.add("Find Employee.");
        mainMenu.add("Edit Employee Information.");
        mainMenu.add("Add Employee.");
        mainMenu.add("Remove Employee.");
        mainMenu.add("Exit!");
        subMenu1 = new Menu("Edit Part-Time Employee Information.");
        subMenu1.add("Display Information.");
        subMenu1.add("Change the Number of Hours-Work.");
        subMenu1.add("Return!");
        subMenu2 = new Menu("Edit Full-Time Employee Information.");
        subMenu2.add("Display Information.");
        subMenu2.add("Change the Level of Employee.");
        subMenu2.add("Change the Over Time Day.");
        subMenu2.add("Return!");
    }

    public void run() throws ParseException {
        System.out.println("*** Welcome " + companyName + "! ***");
        int check = 0;
        do {
            int option = mainMenu.run();
            switch (option) {
                case 1:
                    displayAll();
                    break;
                case 2:
                    displayFoundEmployee();
                    break;
                case 3:
                    int locate = findEmployeeID();
                    if (locate > -1) {
                        int checkSubOption = 0;
                        if (employees.get(locate) instanceof FulltimeEmployee) {
                            do {
                                int subOption = subMenu2.run();
                                switch (subOption) {
                                    case 1:
                                        displayFoundEmployee(locate);
                                        break;
                                    case 2:
                                        System.out.print("Is Manager? (Y/N): ");
                                        boolean isManager = hasOrNot();
                                        ((FulltimeEmployee) employees.get(locate)).setManager(isManager);
                                        break;
                                    case 3:
                                        System.out.print("Number of Hours-Work: ");
                                        double workHourNumber = getDouble();
                                        ((FulltimeEmployee) employees.get(locate)).setOverTimeDay(workHourNumber);
                                        break;
                                    case 4:
                                        checkSubOption = 1;
                                        break;
                                }
                            } while (checkSubOption == 0);
                        } else {
                            do {
                                int subOption = subMenu1.run();
                                switch (subOption) {
                                    case 1:
                                        displayFoundEmployee(locate);
                                        break;
                                    case 2:
                                        System.out.print("Enter new Work Hours Number: ");
                                        double workHourNumber = getDouble();
                                        ((ParttimeEmployee) employees.get(locate)).setWorkHourNumber(workHourNumber);
                                        break;
                                    case 3:
                                        checkSubOption = 1;
                                        break;
                                }
                            } while (checkSubOption == 0);
                        }
                    }
                    break;
                case 4:
                    addEmployee();
                    break;
                case 5:
                    removeEmployee();
                    break;
                case 6:
                    System.out.print("Exiting the App. Please confirm (Y/N): ");
                    boolean exit = hasOrNot();
                    if (exit) {
                        check = 1;
                        System.out.println("Bye! ");
                    }
                    break;
            }
        } while (check == 0);
    }

    public void displayAll() {
        if (employees.size() != 0) {
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        } else {
            System.out.println("No Employees! Recruiting someone.\n");
        }
    }

    public void addEmployee() throws ParseException {
        countEmployee++;
        boolean check;
        int id;
        System.out.println(" + Employee Private Information:");
        System.out.print("   Enter Employee ID: ");
        do {
            id = getInt();
            check = findExistEmployee(id);
            if (check) {
                System.out.print("*** This ID Employee is Exists. please input other: ");
            }
        } while (check);
        System.out.print("   Enter Employee Name: ");
        String name = input.nextLine();
        System.out.print("   Enter Employee Age: ");
        int age = getInt();
        System.out.println(" + Employee Work-Information:");
        System.out.print("   Full-Time Employee(Y) or Part-time Employee(N)? Enter Y/N: ");
        boolean isFullTime = hasOrNot();
        if (isFullTime) {
            System.out.print("   Is Manager? (Y/N): ");
            boolean isManager = hasOrNot();
            System.out.print("   Over Time Day: ");
            double overTimeDay = getDouble();
            FulltimeEmployee temp = new FulltimeEmployee(id, name, age, isManager, overTimeDay);
            employees.add(temp);
        } else {
            System.out.print("   Number of Hours-Work: ");
            double workHourNumber = getDouble();
            ParttimeEmployee temp = new ParttimeEmployee(id, name, age, workHourNumber);
            employees.add(temp);
        }
        System.out.println("Successful Added!\n");
    }

    public boolean findExistEmployee(int id) {
        boolean exist = false;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                exist = true;
                break;
            }
        }
        return exist;
    }


    public int findEmployeeID() throws ParseException {
        System.out.print("   Enter Employee ID: ");
        int id = getInt();
        int locate = -1;
        boolean check = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                locate = i;
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("*** This ID Employee is not Exists. Please check!\n");
            locate = -1;
        }
        return locate;
    }

    public void displayFoundEmployee() throws ParseException {
        int locate = findEmployeeID();
        if (employees.get(locate) instanceof FulltimeEmployee) {
            System.out.println(employees.get(locate).toString());
        }
        if (employees.get(locate) instanceof ParttimeEmployee) {
            System.out.println(employees.get(locate).toString());
        }
    }

    public void displayFoundEmployee(int id) {
        if (employees.get(id) instanceof FulltimeEmployee) {
            System.out.println(employees.get(id).toString());
        }
        if (employees.get(id) instanceof ParttimeEmployee) {
            System.out.println(employees.get(id).toString());
        }
    }

    public void removeEmployee() throws ParseException {
        int idLocate = findEmployeeID();
        if (idLocate > -1) {
            employees.remove(idLocate);
            System.out.println("Successful Removed!");
            countEmployee--;
        } else {
            System.out.println("Unsuccessful Removed!");
        }
    }
}
