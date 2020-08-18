package W3;

import java.util.Scanner;

public class Activity62 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many students: ");
        int num=input.nextInt();
        StudentManagement students=new StudentManagement(num);

        boolean check=true;
        int option=0;
        do{
            System.out.println();
            System.out.println("1. Show detail of Students.");
            System.out.println("2. The number of Passed students.");
            System.out.println("3. The number of Failed students.");
            System.out.println("4. Highest GPA student.");
            System.out.println("5. Lowest GPA student.");
            System.out.println("0. Exit");
            System.out.print("Selected: ");
            option=input.nextInt();
            switch(option){
                case 1:
                    System.out.println("Detail of Students.");
                    students.listInfo();
                    break;
                case 2:
                    System.out.println("The Number of Passed students: "+students.numOfPassed());
                    break;
                case 3:
                    System.out.println("The Number of Failed students: "+students.numOfFailed());
                    break;
                case 4:
                    students.highestGPA();
                    break;
                case 5:
                    students.lowestGPA();
                    break;
                case 0:
                    System.out.println("Bye!");
                    check=false;
                    break;
                default:
                    System.out.println("Wrong selection!");
            }
        }while(check);
    }

    public static class StudentManagement {
        Scanner input = new Scanner(System.in);

        private int numOfStudents;
        private Student[] students;

        public StudentManagement(int num) {
            numOfStudents = num;
            students = new Student[numOfStudents];
            for (int i = 0; i < students.length; i++) {
                System.out.print("Enter the name for student no." + (i + 1) + ": ");
                String name = input.next();
                System.out.print("Enter GPA: ");
                double gpa=getDouble();
                students[i] = new Student(name,gpa);
                System.out.println();
            }
        }

        public void listInfo(){
            for (int i = 0; i < students.length; i++){
                System.out.println((i+1)+". Name: "+students[i].getName());
                System.out.println("  GPA: "+students[i].getGpa());
            }
        }

        public int numOfPassed() {
            int count = 0;
            for (int i = 0; i < students.length; i++) {
                if (students[i].isPass()) {
                    count++;
                }
            }
            return count;
        }

        public int numOfFailed() {
            int count = 0;
            for (Student item : students) {
                if (!item.isPass()) {
                    count++;
                }
            }
            return count;
        }

        public void highestGPA() {
            Student temp=students[0];
            for (int i = 1; i < students.length; i++) {
               if (temp.getGpa() < students[i].getGpa()) {
                   temp = students[i];
               }
            }
            System.out.println("Highest GPA Student: "+temp.getName());
            System.out.println("GPA: "+temp.getGpa());
        }

        public void lowestGPA() {
            Student temp=students[0];
            for (int i = 1; i < students.length; i++) {
                if (temp.getGpa() > students[i].getGpa()) {
                    temp = students[i];
                }
            }
            System.out.println("Lowest GPA Student: "+temp.getName());
            System.out.println("GPA: "+temp.getGpa());
        }
    }

    public static class Student {
        private String name;
        private double gpa;

        public Student() {
            name = null;
            gpa = 0;
        }

        public Student(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getGpa() {
            return gpa;
        }

        public void setGpa(double gpa) {
            this.gpa = gpa;
        }

        public boolean isPass() {
            return gpa >= 1.5;
        }

        public void getInfo() {
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);
        }
    }

    public static double getDouble(){
        Scanner input = new Scanner(System.in);
        double d;
        do{
            d=input.nextDouble();
            if(d<0||d>4){
                System.out.print("GPA must be greater than 0 and less than 4. Re-Enter: ");
            }
        }while(d<0||d>4);
        return d;
    }
}
