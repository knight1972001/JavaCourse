package W2;
import java.util.Scanner;
public class Activity43 {
    public static void divisor(int a){
        int count=2, total=0;
        System.out.print("Divisor of "+a+": "+a);
        while(total<100){
            total=a*count;
            if(total<100) System.out.print(", "+total);
            count++;
        }
        System.out.println("");
    }

    public static void divisor(int a, int b) {
        int count = 2, num = 1, max=0;
        boolean check = false;
        System.out.print("Divisor of " + a + "&" + b + ": ");
        max = Math.max(a, b);
        for(int i=1;i<max;i++) {
            if(i%a==0 && i%b==0){
                System.out.print(i);
                max=i;
                check = true;
                break;
            }
        }
        if(!check){
            max=a*b;
            System.out.print(max);
        }
        int total=0;
        while(total<100){
            total=max*count;
            if(total<100) {
                System.out.print(", "+total);
            }
            count++;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int s1=0,s2=0;
        System.out.print("Divided by ");
        s1=input.nextInt();
        divisor(s1);
        System.out.print("Divided by ");
        s2=input.nextInt();
        divisor(s2);
        divisor(s1,s2);
    }
}
