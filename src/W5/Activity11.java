package W5;

import java.util.ArrayList;
import java.util.LinkedList;

public class Activity11 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 100000; i++){
            arrayList.add(i);
            linkedList.add(i);
        }
        long start_time = System.currentTimeMillis();


        for(int i = 0; i < 10000;i++){
            arrayList.get(arrayList.size()/2);
        }
        for(int i = 0; i < 10000;i++){
            arrayList.remove(arrayList.size()/2);
        }

        long end_time = System.currentTimeMillis();

        System.out.println("Thoi gian chay xong vong lap ArrayList: "+(end_time - start_time)+" UNIX time");

        start_time = System.currentTimeMillis();

        for(int i = 0; i < 10000;i++){
            linkedList.get(linkedList.size()/2);
        }
        for(int i = 0; i < 10000;i++){
            linkedList.remove(linkedList.size()/2);
        }

        end_time = System.currentTimeMillis();

        System.out.println("Thoi gian chay xong vong lap LinkedList: "+(end_time - start_time)+" UNIX time");

    }
}
