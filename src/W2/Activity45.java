package W2;
import java.util.Scanner;
public class Activity45 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=0, total=1;
        System.out.print("Input: ");
        n=input.nextInt();
        for(int i=1; i<=n; i++){
            total*=i;
        }
        System.out.println(n+"!: "+total);
    }
}
