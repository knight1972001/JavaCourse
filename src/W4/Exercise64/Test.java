package W4.Exercise64;

import java.text.ParseException;
import java.util.Scanner;

import static W4.Exercise64.Ultis.getInt;

public class Test {
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        System.out.print("Owner Name: ");
        String ownerName = input.nextLine();
        System.out.print("Number of Book: ");
        int bookNumber = getInt();
        BookManagement bookManagement=new BookManagement(ownerName, bookNumber);
        bookManagement.run();
    }
}
