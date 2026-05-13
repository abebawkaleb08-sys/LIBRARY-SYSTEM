import java.util.ArrayList;
import java.util.Scanner;

abstract class Item {
    private String name;
    protected String type;
    
    public Item(String n, String t) { name=n; type=t; }
    public String getName() { return name; }
    public abstract void show();
}

class Book extends Item {
    public Book(String n) { super(n, "Book"); }
    
    @Override
    public void show() { System.out.println("Book: "+getName()); }
}

public class Library {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Book("Java"));
        items.add(new Book("Python"));
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index (0-"+(items.size()-1)+"): ");
        
        try {
            int i = Integer.parseInt(sc.nextLine());
            items.get(i).show();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        
        sc.close();
    }
}