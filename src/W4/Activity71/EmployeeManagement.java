package W4.Activity71;

import W4.Exercise64.Menu;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static W4.Activity71.Ultis.*;
import static W4.Exercise64.Ultis.hasOrNot;
import static java.lang.StrictMath.abs;

public class EmployeeManagement {
    private String companyName = null;
    private int countEmployee = 0;
    private final List<FulltimeEmployee> fulltimeEmployees = new ArrayList<>();
    private final List<ParttimeEmployee> parttimeEmployees = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    Menu mainMenu;
    Menu subMenu1;
    Menu subMenu2;

    public EmployeeManagement(String companyName, int num) throws ParseException {
        this.companyName = companyName;
        System.out.println("Welcome to "+companyName);
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
                    int locate = findEmployeeLocate();
                    if(locate!=0){
                        if(locate<0){
                            int checkSubOption=0;
                            do{
                                int subOption=subMenu1.run();
                                switch(subOption){
                                    case 1:
                                        displayFoundEmployee(locate);
                                        break;
                                    case 2:
                                        System.out.print("Enter new Work Hours Number: ");
                                        double workHourNumber= getDouble();
                                        parttimeEmployees.get(abs(locate)-1).setWorkHourNumber(workHourNumber);
                                        break;
                                    case 3:
                                        checkSubOption=1;
                                        break;
                                }
                            }while(checkSubOption==0);
                        }else{
                            int checkSubOption=0;
                            do{
                                int subOption=subMenu2.run();
                                switch(subOption){
                                    case 1:
                                        displayFoundEmployee(locate);
                                        break;
                                    case 2:
                                        System.out.print("Is Manager? (Y/N): ");
                                        boolean isManager = hasOrNot();
                                        fulltimeEmployees.get(locate-1).setManager(isManager);
                                        break;
                                    case 3:
                                        System.out.print("Number of Hours-Work: ");
                                        double workHourNumber = getDouble();
                                        fulltimeEmployees.get(locate-1).setOverTimeDay(workHourNumber);
                                        break;
                                    case 4:
                                        checkSubOption=1;
                                        break;
                                }
                            }while(checkSubOption==0);
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
            }while (check == 0);
    }

    public void displayAll(){
        if(countEmployee!=0){
            for (int i = 0; i < fulltimeEmployees.size(); i++) {
                System.out.println(fulltimeEmployees.get(i).toString());
            }
            for (int i = 0; i < parttimeEmployees.size(); i++){
                System.out.println(parttimeEmployees.get(i).toString());
            }
        }else{
            System.out.println("No Employees! Recruiting someone.\n");
        }
    }

    public void addEmployee() throws ParseException {
        countEmployee++;
        boolean check = false;
        int id = 0;
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
            fulltimeEmployees.add(temp);
        } else {
            System.out.print("   Number of Hours-Work: ");
            double workHourNumber = getDouble();
            ParttimeEmployee temp = new ParttimeEmployee(id, name, age, workHourNumber);
            parttimeEmployees.add(temp);
        }
        System.out.println("Successful Added!\n");
    }

    public boolean findExistEmployee(double id) throws ParseException {
        boolean exist = false;
        for (int i = 0; i < parttimeEmployees.size(); i++) {
            if (parttimeEmployees.get(i).getId() == id) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            for (int i = 0; i < fulltimeEmployees.size(); i++) {
                if (fulltimeEmployees.get(i).getId() == id) {
                    exist = true;
                    break;
                }
            }
        }
        return exist;
    }

    public int findEmployeeLocate() throws ParseException {
        boolean check = false;
        int locate = 0;//locate Employee thuoc ve Full or Part-Time. locate < 0 --> partime. locate > 0 fulltime.
        System.out.print("   Enter Employee ID: ");
        int id = getInt();
        check = findExistEmployee(id);
        if (!check) {
            System.out.println("*** This ID Employee is not Exists. Please check!\n");
            locate=0;
        } else {
            for (int i = 0; i < parttimeEmployees.size(); i++) {
                if (parttimeEmployees.get(i).getId() == id) {
                    locate = (i+1)*(-1);
                    break;
                }
            }
            if (locate == 0) {
                for (int i = 0; i < fulltimeEmployees.size(); i++) {
                    if (fulltimeEmployees.get(i).getId() == id) {
                        locate = i+1;
                        break;
                    }
                }
            }
        }
        return locate;
    }

    public void displayFoundEmployee() throws ParseException {
        int idLocate = findEmployeeLocate();
        if (idLocate < 0) {
            System.out.println(parttimeEmployees.get(abs(idLocate)-1).toString());
        }
        if (idLocate > 0) {
            System.out.println(fulltimeEmployees.get(idLocate-1).toString());
        }
    }

    public void displayFoundEmployee(int idLocate){
        if (idLocate < 0) {
            System.out.println(parttimeEmployees.get(abs(idLocate)-1).toString());
        }
        if (idLocate > 0) {
            System.out.println(fulltimeEmployees.get(idLocate-1).toString());
        }
    }


    public void removeEmployee() throws ParseException {
        int idLocate = findEmployeeLocate();
        if (idLocate < 0) {
            parttimeEmployees.remove(abs(idLocate)-1);
            System.out.println("Successful Removed!");
        }
        if (idLocate > 0) {
            fulltimeEmployees.remove(idLocate-1);
            System.out.println("Successful Removed!");
        }
        if(idLocate==0){
            System.out.println("Unsuccessful Removed!");
        }

        countEmployee--;
    }
}
