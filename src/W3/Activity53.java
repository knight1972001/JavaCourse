package W3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Activity53 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = 0;
        System.out.print("Enter the size of the 1st array: n = ");
        size = getSize();

        System.out.println("Enter elements of the 1st array: ");
        char[] arr1 = new char[size];
        for (int i = 0; i < size; i++) {
            System.out.print("a[" + i + "] = ");
            char c = input.next().charAt(0);
            arr1[i] = c;
        }

        System.out.print("Enter the size of the 2st array: n = ");
        size = getSize();
        System.out.println("Enter elements of the 2st array: ");
        char[] arr2 = new char[size];
        for (int i = 0; i < size; i++) {
            System.out.print("a[" + i + "] = ");
            char c = input.next().charAt(0);
            arr2[i] = c;
        }

        System.out.println("Original array: ");
        System.out.print("Length = " + arr1.length + "; elements = ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }

        System.out.println();
        System.out.print("Length = " + arr1.length + "; elements = ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

        System.out.println();
        List<Character> newArray = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            newArray.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            newArray.add(arr2[i]);
        }

        System.out.println("Merged array: ");
        System.out.print("Length = " + newArray.size() + "; elements = ");
        for (int i = 0; i < newArray.size(); i++) {
            System.out.print(newArray.get(i) + " ");
        }
    }

    static int getSize() {
        Scanner input = new Scanner(System.in);
        int size = 0;
        do {
            size = input.nextInt();
            if (size < 0) {
                System.out.println("Size must be greater than 0. Re-enter: ");
            }
        } while (size < 0);
        return size;
    }
}
