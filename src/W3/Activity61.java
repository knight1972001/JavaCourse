package W3;

import java.util.Scanner;

public class Activity61 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double w=0,h=0;
        System.out.print("Enter width: ");
        w=input.nextDouble();
        System.out.print("Enter height: ");
        h=input.nextDouble();
        Rectangle newRectangle=new Rectangle(w,h);
        boolean check=true;
        int option=0;
        do{
            System.out.println();
            System.out.println("1. Show detail of Rectangle.");
            System.out.println("2. Set the new height.");
            System.out.println("3. Set the new width.");
            System.out.println("4. Calculate the perimeter.");
            System.out.println("5. Calculate the are.");
            System.out.println("6. Is it square?");
            System.out.println("0. Exit");
            System.out.print("Selected: ");
            option=input.nextInt();
            switch(option){
                case 1:
                    System.out.println("Detail of Rectangle:");
                    System.out.println("Width: " +newRectangle.getWidth() + "\nHeight: "+newRectangle.getHeight());
                    break;
                case 2:
                    System.out.print("Change the height to: ");
                    h=input.nextDouble();
                    newRectangle.setHeight(h);
                    break;
                case 3:
                    System.out.print("Change the width to: ");
                    w=input.nextDouble();
                    newRectangle.setWidth(w);
                    break;
                case 4:
                    System.out.println("Perimeter of Rectangle: "+newRectangle.getPerimeter());
                    break;
                case 5:
                    System.out.println("The area of Rectangle: "+newRectangle.getArea());
                    break;
                case 6:
                    if(newRectangle.isSquare()){
                        System.out.println("This is a square!");
                    }else{
                        System.out.println("This is a rectangle.");
                    }
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

    public static class Rectangle{
        private double width, height;
        public Rectangle(){
            width =0;
            height =0;
        }
        public Rectangle(double w, double h) {
            width = w;
            height = h;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
            System.out.println("Width changed to: "+this.width);
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
            System.out.println("Height changed to: "+this.height);
        }

        public double getPerimeter(){
            return (width + height)*2;
        }

        public double getArea(){
            return height*width;
        }

        public boolean isSquare(){
            return height == width;
        }
    }
}

