package hackerrank_30p;

import java.util.Scanner;

abstract class Book {
    String title;
    String author;
    
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    abstract void display();
}

class MyBook extends Book{
    int price;
    
    MyBook(String title, String author, int price) {
        super(title, author);
        this.price  = price;
    }
    
     void display(){
            System.out.printf("Title: %s\n", this.title);
            System.out.printf("Author: %s\n", this.author);
            System.out.printf("Price: %d\n", this.price);
     }
}


public class Solution_Day13_Abstract_Classes {
	   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.close();

        Book book = new MyBook(title, author, price);
        book.display();
    }
}
