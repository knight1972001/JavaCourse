package W6;

import java.util.ArrayList;
import java.util.Scanner;

import static W6.Utils.*;

public class Activity101 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<SinhVien> listStudents = new ArrayList<>();
        System.out.print("Nhap so luong Hoc Sinh: ");
        int n = getInt();
        double grade =0;
        for (int i = 0; i < n; i++) {
            System.out.println("Student Number: "+(i + 1));
            System.out.print("Enter Student ID: ");
            int id = getInt();
            System.out.print("Enter Student Name: ");
            String studentName = input.nextLine();
            System.out.print("Enter Student's Grade: ");
            do{
                grade = getGrade();
                if(grade < 0 || grade > 10){
                    System.out.print("Out of Ranger of Grade. Re-Enter: ");
                }
            }while(grade < 0 || grade > 10);
            System.out.println();
            String xeploai = xeploai(grade);
            listStudents.add(new SinhVien(id, studentName, grade, xeploai));
        }

        System.out.println("*** LIST STUDENT ***");
        for (int i = 0; i < listStudents.size(); i++)
        {
            System.out.println(listStudents.get(i).toString()+"\n");
        }
    }
}
