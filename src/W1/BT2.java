package W1;
import java.util.Scanner;
public class BT2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.print("Input number: ");
        n=input.nextInt();
        System.out.println(n + " + " + (n*10+n) + " + " + (n*100+n*10+n) + " = " + (n+(n*10+n)+(n*100+n*10+n)));
        System.out.println("End program");
    }
}