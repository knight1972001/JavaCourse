package W1;
import java.util.Scanner;
public class BT3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a=0;
        System.out.print("Input a number: ");
        a=input.nextInt();
        for (int i=1;i<=10;i++) {
            System.out.println(a + " x " + i + " = " + a*i);
        }
    }

}
