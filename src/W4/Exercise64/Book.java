package W4.Exercise64;

public class Book {
    private String name=null;
    private String author=null;
    private double price=0; //hom bua lam Store e bi tran so phan nay, nen e doi no qua Double de khoang chua rong hon.
    private int totalSold=0;

    public Book(String name, String author, double price, int totalSold) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.totalSold = totalSold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(int totalSold) {
        this.totalSold = totalSold;
    }

    public boolean isBestSeller(){
        return totalSold > 1000;
    }

    @Override
    public String toString() {
        String result;
        result = "Book name: " + name +"\n";
        result += "Author: " + author +"\n";
        result += "Price: " + price +" VND\n";
        result += "Total Sold: " + totalSold + "\n";
        result += "Best seller: ";
        result += isBestSeller() ? "Yes \n\n" : "No \n\n";
        return result;
    }
}
