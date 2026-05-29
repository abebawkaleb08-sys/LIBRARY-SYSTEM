import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1. Abstract class showcasing clean Encapsulation and Naming Conventions
abstract class Item {
    private final String name;
    private final String type; // Changed from protected to private for strict encapsulation

    public Item(String name, String type) { 
        this.name = name; 
        this.type = type; 
    }

    public String getName() { 
        return name; 
    }

    public String getType() { 
        return type; 
    }

    public abstract void show();
}

// 2. Concrete Subclass implementing the abstract behavior
class Book extends Item {
    public Book(String name) { 
        super(name, "Book"); 
    }

    @Override
    public void show() { 
        System.out.println("Book: " + getName()); 
    }
}

// 3. Main Application with specific exception handling and meaningful variable names
public class Library {
    public static void main(String[] args) {
        // Programming to an interface (List) instead of implementation (ArrayList)
        List<Item> items = new ArrayList<>();
        items.add(new Book("Java Programming"));
        items.add(new Book("Python Basics"));

        Scanner scanner = new Scanner(System.in);
        
        // Prevent crashes if the list happens to be empty
        if (items.isEmpty()) {
            System.out.println("The library inventory is currently empty.");
            scanner.close();
            return;
        }

        System.out.print("Enter index (0 - " + (items.size() - 1) + "): ");

        try {
            int index = Integer.parseInt(scanner.nextLine());
            items.get(index).show();
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a valid integer numeric value.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds. Please choose a number within the provided range.");
        } finally {
            scanner.close(); // Ensuring resource closure
        }
    }
}
