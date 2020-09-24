package W6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
    public static double getGrade() {
        double result = 0;
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                result = input.nextDouble();
                return result;
            } catch (InputMismatchException ex) {
                System.out.print("Wrong Number format. Re-Enter the Number: ");
            }
        }
    }

    public static int getInt() {
        int result = 0;
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                result = input.nextInt();
                return result;
            } catch (InputMismatchException e) {
                System.out.print("Wrong Number format. Re-Enter the Number: ");
            }
        }
    }

    public static String xeploai(double value) {
        if(value>=8){
            return "Gioi";
        }else if(value >= 7){
            return "Kha";
        }else if(value >= 5){
            return "TB";
        }else{
            return "Kem";
        }
    }
}
