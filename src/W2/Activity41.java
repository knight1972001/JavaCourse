package W2;
import java.util.Scanner;
public class Activity41 {
    public static void main(String[] args) {
        int temp1=0,temp2=1,n=0;
        Scanner input = new Scanner(System.in);
        System.out.print("Length of Fibonacci Series: ");
        n=input.nextInt();
        System.out.print("Fibonacci Series: "+temp1+", "+temp2);
        if(n>2){
            int fib=temp1+temp2,i=0;
            while(i<n-2){
                System.out.print(", "+fib);
                temp1=temp2;
                temp2=fib;
                fib=temp1+temp2;
                i++;
            }
        }
    }
}
