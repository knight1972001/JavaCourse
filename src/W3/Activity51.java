package W3;
import java.util.Scanner;
public class Activity51 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = 0, b = 0;
        int result = 0;
        do{
        System.out.print("Input the beginning number: ");
        a = input.nextInt();
        System.out.print("Input the last number: ");
        b=input.nextInt();
        if(a>b){
            System.out.println("A must be less than B!");
        }
        }while(a>b);
        System.out.print("Armstrong number: ");
        for(int i=a;i<=b;i++){
            String str = Integer.toString(i);
            int num=0;
            result=0;
            for (int j = 0; j < str.length(); j++) {
                num = Character.getNumericValue(str.charAt(j));
                result += Math.pow(num,str.length());
            }
            if(result==i){
                System.out.print(result+", ");
            }
        }
    }
}
