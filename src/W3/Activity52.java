package W3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Activity52 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = 0;
        System.out.print("Enter the size of the array: n = ");
        do {
            size = input.nextInt();
            if (size < 0) {
                System.out.println("Size must be greater than 0. Re-enter: ");
            }
        } while (size < 0);
        char[] originString = new char[size];
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("a[" + i + "] = ");
            char c = input.next().charAt(0);
            originString[i] = c;
        }
        System.out.println("Original array: ");
        System.out.print("Length = " + size + "; a[] = ");
        for (int i = 0; i < size; i++) {
            System.out.print(originString[i] + " ");
        }
        System.out.println("\n");
        boolean check= false;
        List<Character> newArray = new ArrayList<>();
        newArray.add(originString[0]);
        for (int i = 1; i < size; i++) {
            for(int j = 0; j < newArray.size(); j++){
                if(originString[i] != newArray.get(j)){
                    check=true;
                }else{
                    check=false;
                    break;
                }
            }
            if(check){
                newArray.add(originString[i]);
            }
        }
        System.out.println("Array after remove all duplicate elements: ");
        System.out.print("Length = " + newArray.size() + "; a[] = ");
        for (int i = 0; i < newArray.size(); i++) {
            System.out.print(newArray.get(i) + " ");
        }
    }
}
