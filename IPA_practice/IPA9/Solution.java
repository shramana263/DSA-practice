import java.util.Scanner;
class Book{
    private int id, pages;
    private String title, author;
    private double price;

    public Book(int id, int pages, String title, String author, double price){
        this.id=id;
        this.pages=pages;
        this.title=title;
        this.author=author;
        this.price=price;
    }
    public int getId(){
        return id;
    }
    public int getPages(){
        return pages;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public double getPrice(){
        return price;
    }
}

public class Solution {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Book[] bk= new Book[4];
        for(int i=0;i<4;i++){
            int a = sc.nextInt();sc.nextLine();
            int b= sc.nextInt();sc.nextLine();
            String c= sc.nextLine();
            String d= sc.nextLine();
            double e= sc.nextDouble();sc.nextLine();

            bk[i]= new Book(a,b,c,d,e);
        }
        String title= sc.nextLine();
        Book obj1= findBookWithMaximumPrice(bk);
        Book obj2= searchBookByTitle(bk, title);

        if(obj1==null){
            System.out.println("404 not found");
        }
        else{
            System.out.println(obj1.getId()+" "+obj1.getTitle());
        }

        if(obj2==null){
            System.out.println("404 not found");
        }
        else{
            System.out.println(obj2.getId()+" "+obj2.getTitle()+" "+obj2.getPrice());
        }

    }

    public static Book findBookWithMaximumPrice(Book[] book){
        if(book==null){
            return null;
        }
        if(book.length==1){
            return book[0];
        }
        double maxPrice= book[0].getPrice();
        int maxIndex=0;
        for(int i=1;i<book.length;i++){
            if(book[i].getPrice()>maxPrice){
                maxPrice=book[i].getPrice();
                maxIndex=i;
            }
        }
        return book[maxIndex];
    }

    public static Book searchBookByTitle(Book[] book, String title){
        if(book==null){
            return null;
        }
        for(int i=0;i<book.length;i++){
            if(book[i].getTitle().equals(title)){
                return book[i];
            }
        }
        return null;
    }
}
