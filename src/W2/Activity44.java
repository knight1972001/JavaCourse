package W2;
import java.util.Scanner;
public class Activity44 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=0, count=1, total=0;
        System.out.print("Input number: ");
        n=input.nextInt();
        //while
        while(count<=n){
            total+=count;
            count++;
        }
        System.out.println("The sum of 1 to "+n+" is "+total);
        System.out.println("The average is "+(double)total/n);
        //for
        total=0;
        for(int i=1;i<=n;i++){
            total+=i;
        }
        System.out.println("The sum of 1 to "+n+" is "+total);
        System.out.println("The average is "+(double)total/n);
        //do-while
        total=0;
        count=1;
        do{
            total+=count;
            count++;
        }while(count<=n);
        System.out.println("The sum of 1 to "+n+" is "+total);
        System.out.println("The average is "+(double)total/n);
    }
}
