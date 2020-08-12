package W2;
import java.util.Scanner;
public class Activity42 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=0;
        System.out.print("Input the triangle height: ");
        n=input.nextInt();
        for(int i=1;i<=n;i++) {
            for(int a=n-i;a>=1;a--) {
                System.out.print(" ");
            }
            int a=1;
            while(a<=(i*2)-1){
                System.out.print("*");
                a++;
            }
            System.out.print("\n");
        }
    }
}
