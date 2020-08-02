package W1;
import java.util.Scanner;

public class BT1 {
    public static void main(String[] args) {
        int a,b;
        Scanner input = new Scanner(System.in);
        System.out.print("Input first number: ");
        a = input.nextInt();
        System.out.print("Input second number: ");
        b= input.nextInt();
        System.out.println(a+" + "+b+" = "+tong(a,b));
        System.out.println(a+" - "+b+" = "+tru(a,b));
        System.out.println(a+" x "+b+" = "+nhan(a,b));
        if(b!=0){
            System.out.println(a+" / "+b+" = "+chia(a,b));
            System.out.println(a+" mod "+b+" = "+mod(a,b));
        }else{
            System.out.println("Mau so am nen khong thuc hien duoc");
        }
        input.close();
    }

    static int mod(int a,int b){
        return a%b;
    }

    static double chia(int a, int b) {
        return a/b;
    }

    static double nhan(int a,int b) {
        return a*b;
    }

    static int tru(int a,int b) {
        return a-b;
    }

    static int tong(int a,int b) {
        return a+b;
    }
}