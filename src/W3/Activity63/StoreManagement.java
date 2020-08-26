package W3.Activity63;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static W3.Activity63.Menu.getInRanger;

public class StoreManagement {
    private int count = 0;
    private final List<Store> stores = new ArrayList<>();
    private String owner;
    Menu mainMenu;
    Menu subMenu1;
    Scanner input = new Scanner(System.in);

    public StoreManagement(String owner) {
        this.owner = owner;
        mainMenu = new Menu("Store Management App, Select an action:");
        mainMenu.add("List of Stores.");
        mainMenu.add("Access to Store detail.");
        mainMenu.add("Add Store.");
        mainMenu.add("Remove Store.");
        mainMenu.add("The store sells the most/least of the phones.");
        mainMenu.add("The store has the highest/lowest sales.");
        mainMenu.add("The number of phones of all stores that have Bluetooth/5G/Wifi.");
        mainMenu.add("Exit");
        subMenu1 = new Menu("Input the Store code: ");
        subMenu1.add("Detail of Store.");
        subMenu1.add("Change the Store's name.");
        subMenu1.add("Change the Store's address.");
        subMenu1.add("List all Phones in Store.");
        subMenu1.add("Add Phone.");
        subMenu1.add("Remove Phone.");
        subMenu1.add("Return.");
    }

    public void run() {
        int check = 0;
        do {
            System.out.println("Owner: " + owner);
            int option = mainMenu.run();
            switch (option) {
                case 1:
                    System.out.println(toString());
                    break;
                case 2:
                    System.out.println("Enter the Store Code: ");
                    int code = getInRanger(stores.size(), 1);
                    code--;
                    int checkSubOption = 0;
                    do {
                        int optionSubOption = subMenu1.run();
                        switch (optionSubOption) {
                            case 1:
                                stores.get(code).displayInfo();
                                break;
                            case 2:
                                System.out.print("Enter the new name: ");
                                String name = input.nextLine();
                                stores.get(code).setName(name);
                                System.out.println("Successful Changed!\n");
                                stores.get(code).displayInfo();
                                break;
                            case 3:
                                System.out.println("Enter the new address: ");
                                String address = input.nextLine();
                                stores.get(code).setAddress(address);
                                System.out.println("Successful Changed!\n");
                                stores.get(code).displayInfo();
                                break;
                            case 4:
                                stores.get(code).displayAllPhone();
                                break;
                            case 5:
                                stores.get(code).addPhones();
                                break;
                            case 6:
                                stores.get(code).removePhone();
                                break;
                            case 7:
                                checkSubOption=1;
                                break;
                        }
                    } while (checkSubOption == 0);
                    break;
                case 3:
                    addStore();
                    break;
                case 4:
                    removeStore();
                    break;
                case 5:
                    mostLeastSell();
                    break;
                case 6:
                    highestLowestSales();
                    break;
                case 7:
                    System.out.println("The number of phones of all stores that have Bluetooth/5G/Wifi: " + numberOfPhoneHave3Functions() + " Phones");
                    break;
                case 8:
                    System.out.println("Exiting program!");
                    check = 1;
                    break;
            }
        } while (check == 0);
    }

    public void highestLowestSales() {
        Store greatestStore = null;
        double tempSold = 0;
        for (int i = 0; i < stores.size(); i++) {
            if (tempSold < stores.get(i).totalRevenue()) {
                tempSold = stores.get(i).totalRevenue();
                greatestStore = stores.get(i);
            }
        }
        System.out.println("The highest revenue phone store: ");
        if (greatestStore != null) {
            greatestStore.displayInfo();
        }

        Store leastStore = stores.get(0);
        tempSold = stores.get(0).totalRevenue();
        for (int i = 1; i < stores.size(); i++) {
            if (tempSold > stores.get(i).totalRevenue()) {
                tempSold = stores.get(i).totalRevenue();
                leastStore = stores.get(i);
            }
        }
        System.out.println("The lowest revenue phone store: ");
        leastStore.displayInfo();
    }

    public void mostLeastSell() {
        Store greatestStore = null;
        int tempSold = 0;
        for (int i = 0; i < stores.size(); i++) {
            if (tempSold < stores.get(i).totalSoldPhone()) {
                tempSold = stores.get(i).totalSoldPhone();
                greatestStore = stores.get(i);
            }
        }
        System.out.println("The most sell phone store: ");
        if (greatestStore != null) {
            greatestStore.displayInfo();
        }

        Store leastStore = stores.get(0);
        tempSold = stores.get(0).totalSoldPhone();
        for (int i = 1; i < stores.size(); i++) {
            if (tempSold > stores.get(i).totalSoldPhone()) {
                tempSold = stores.get(i).totalSoldPhone();
                leastStore = stores.get(i);
            }
        }
        System.out.println("The least sell phone store: ");
        leastStore.displayInfo();
    }

    public void addStore() {
        count++;
        System.out.println("Adding Store num. " + count + ":");
        System.out.print("Store name: ");
        String name = input.nextLine();
        System.out.print("Store Address: ");
        String address = input.nextLine();
        Store temp = new Store(name, address);
        stores.add(temp);
        System.out.println("Successful Added!");
        System.out.println();
    }

    public void removeStore() {
        System.out.println(toString());
        System.out.print("Input the Store code you wanmt to remove: ");
        int selection = getInRanger(stores.size(), 1);
        selection--;
        stores.remove(selection);
        System.out.println("Successful Removed!");
        System.out.println();

    }

    public int numberOfPhoneHave3Functions() {
        int countPhone = 0;
        for (int i = 0; i < stores.size(); i++) {
            countPhone += stores.get(i).totalPhoneHave3Functions();
        }
        return countPhone;
    }
public String getOwnerName() {
        return owner;
}
    @Override
    public String toString() {
        String result;
        result = "Store Management by "+getOwnerName()+": \nStore Detail:\n";
        if(stores.size()!=0){
            for (int i = 0; i < stores.size(); i++) {
                result += "Store num. " + (i + 1) + " :\n";
                result += "Store name: " + stores.get(i).getName() + "\n";
                result += "Store address: " + stores.get(i).getAddress() + "\n";
                result += "The number of Phone in Store: " + stores.get(i).getNumberOfPhones() + "\n";
                result += "The number of Phone have 3 Functions: " + stores.get(i).totalPhoneHave3Functions() + "\n";
                result += "Total Sold Phone: " + stores.get(i).totalSoldPhone() + "\n";
                result += "Total Revenue: " + stores.get(i).totalRevenue() + "VND\n\n";
            }
        }else{
            result += "No Store! You poor! Wake up\n\n";
        }
        return result;
    }
}
