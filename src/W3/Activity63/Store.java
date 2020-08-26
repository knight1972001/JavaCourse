package W3.Activity63;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static W3.Activity63.Menu.getInRanger;

public class Store {
    private String name = null;
    private String address = null;
    private int count = 0;
    private final List<SmartPhone> smartPhones = new ArrayList<SmartPhone>();
    Scanner input = new Scanner(System.in);

    public Store(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void displayInfo() {
        System.out.println("Store name: " + name);
        System.out.println("Store Address: " + address);
        System.out.println("The number of Brand Phone: " + count);
        System.out.println("The number of Sold Phone: "+totalSoldPhone());
        System.out.println("Revenue: "+totalRevenue());
        System.out.println();
    }

    public void displayAllPhone() {
        if(smartPhones.size()!=0){
            for (int i = 0; i < smartPhones.size(); i++) {
                System.out.println((i + 1) + ". " + smartPhones.get(i).toString());
            }
        }else{
            System.out.println("Buy some phones to sell guy!\n");
        }
    }

    public void removePhone() {
        displayAllPhone();
        System.out.print("Input the phone code you want to remove: ");
        int selection = getInRanger(smartPhones.size(), 1);
        selection--;
        smartPhones.remove(selection);
        count--;
        System.out.println("Successful Removed!");

    }

    public int getNumberOfPhones() {
        return count;
    }

    public void addPhones() {
        if (name != null) {
            count++;
            System.out.println("Adding Phone num. " + count + ": ");
            System.out.print("Brand: ");
            String brand = input.nextLine();
            boolean hasBluetooth, has5G, hasWifi;
            System.out.print("Has Bluetooth (Y/N): ");
            hasBluetooth = hasOrNot();
            System.out.print("Has 5G (Y/N): ");
            has5G = hasOrNot();
            System.out.print("Has WiFi (Y/N): ");
            hasWifi = hasOrNot();
            System.out.print("OS: ");
            String os = input.nextLine();
            System.out.print("Memory: ");
            float memory = input.nextFloat();
            System.out.print("Color: ");
            String color = input.nextLine();
            input.nextLine();
            System.out.print("Price: ");
            long price = input.nextLong();
            input.nextLine();
            System.out.print("Total Sold: ");
            int totalSold = input.nextInt();
            input.nextLine();
            System.out.println();
            SmartPhone temp = new SmartPhone(brand, hasBluetooth, has5G, hasWifi, os, memory, color, price, totalSold);
            smartPhones.add(temp);
            System.out.println("Successful Added!");
            System.out.println();
        } else {
            System.out.println("The Store is not exist.");
        }
    }


    public boolean hasOrNot() {
        boolean has = false;
        boolean check = false;
        do {
            String function = input.nextLine();
            if (function.equals("Y") || function.equals("N")) {
                if (function.equals("Y")) {
                    has = true;
                } else {
                    has = false;
                }
                check = true;
            } else {
                System.out.print("The answer must be Y or N. Re-Enter: ");
                check = false;
            }
        } while (!check);
        return has;
    }

    public int totalSoldPhone() {
        int total = 0;
        for (int i = 0; i < smartPhones.size(); i++) {
            total += smartPhones.get(i).getTotalSold();
        }
        return total;
    }

    public double totalRevenue() {
        double total = 0;
        for (int i = 0; i < smartPhones.size(); i++) {
            total += (smartPhones.get(i).getPrice() * smartPhones.get(i).getTotalSold());
        }
        return total;
    }

    public int totalPhoneHave3Functions() {
        int countPhone = 0;
        for (int i = 0; i < smartPhones.size(); i++) {
            if (smartPhones.get(i).has3Functions()) {
                countPhone++;
            }
        }
        return countPhone;
    }
}
