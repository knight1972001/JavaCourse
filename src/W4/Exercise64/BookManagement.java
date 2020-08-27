package W4.Exercise64;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static W3.Activity63.Menu.getInRanger;
import static W4.Exercise64.Ultis.getDouble;
import static W4.Exercise64.Ultis.getInt;
import static W4.Exercise64.Ultis.hasOrNot;

public class BookManagement {
    private String owner;
    private int count;
    private final List<Book> books = new ArrayList<>();
    Menu mainMenu;

    public BookManagement(String owner, int count) throws ParseException {
        this.owner = owner;
        for (int i = 0; i < count; i++) {
            addBook();
        }
        mainMenu = new Menu("*** Book Management App ***");
        mainMenu.add("Book List.");
        mainMenu.add("Add Book.");
        mainMenu.add("Remove Book.");
        mainMenu.add("Number of Best Seller Book.");
        mainMenu.add("The Best Seller Book in Store.");
        mainMenu.add("Exit.");
    }

    public void run() throws ParseException {
        System.out.println("*** Welcome " + owner + "! ***");
        int check = 0;
        do {
            int option = mainMenu.run();
            switch (option) {
                case 1:
                    listBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    System.out.println("The number of Best Seller Books: " + numberOfBestSellerBooks());
                    break;
                case 5:
                    bestBooks();
                    break;
                case 6:
                    System.out.print("Exiting the App. Please confirm (Y/N): ");
                    boolean exit = hasOrNot();
                    if (exit) {
                        check = 1;
                        System.out.println("Bye! "+ owner);
                    }
                    break;
            }
        } while (check == 0);
    }

    public void addBook() throws ParseException {
        Scanner input = new Scanner(System.in);
        count++;
        System.out.println("*** Adding the Book Code num.(" + count + ") ***");
        System.out.print("Enter Name of the Book: ");
        String name = input.nextLine();
        System.out.print("Enter Name of Author: ");
        String author = input.nextLine();
        System.out.print("Enter the price of Book: ");
        double price = getDouble();
        System.out.print("Enter the total Sold: ");
        int totalSold = getInt();
        Book temp = new Book(name, author, price, totalSold);
        books.add(temp);
        System.out.println("Successful Added!\n");
    }

    public void removeBook() {
        if (books.size() != 0) {
            listBooks();
            System.out.print("Input the Book code you want to remove: ");
            int selection = getInRanger(books.size(), 1);
            selection--;
            books.remove(selection);
            count--;
            System.out.println("Successful Removed!");
            System.out.println();
        } else {
            System.out.println("You do not have any Book. Please add!");
        }
    }

    public void listBooks() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println("- Book Code num.(" + (i + 1) + ") detail:");
            System.out.print(books.get(i).toString());
        }
    }

    public int numberOfBestSellerBooks() {
        int countbook = 0;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isBestSeller()) {
                countbook++;
            }
        }
        return countbook;
    }

    public void bestBooks() {
        int temp = 0;
        Book tempBook = null;
        for (int i = 0; i < books.size(); i++) {
            if (temp < books.get(i).getTotalSold()) {
                temp = books.get(i).getTotalSold();
                tempBook = books.get(i);
            }
        }
        System.out.println("The Best Seller Book in Store: ");
        System.out.println(tempBook.toString());
    }


}
