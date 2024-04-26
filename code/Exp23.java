import java.util.ArrayList;
import java.util.Scanner;

public class Exp23 {
    private ArrayList<String> stringList;

    public Exp23() {
        stringList = new ArrayList<>();
    }

    // Insert operation
    public void insert(String item) {
        stringList.add(item);
        System.out.println("Item '" + item + "' inserted successfully.");
    }

    // Delete operation
    public void delete(String item) {
        if (stringList.remove(item)) {
            System.out.println("Item '" + item + "' deleted successfully.");
        } else {
            System.out.println("Item '" + item + "' not found in the list.");
        }
    }

    // Display operation
    public void display() {
        if (stringList.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            System.out.println("Items in the list:");
            for (String item : stringList) {
                System.out.println(item);
            }
        }
    }

    // Search operation
    public void search(String item) {
        if (stringList.contains(item)) {
            System.out.println("Item '" + item + "' found in the list.");
        } else {
            System.out.println("Item '" + item + "' not found in the list.");
        }
    }

    public static void main(String[] args) {
        Exp23 listOperations = new Exp23();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Insert\n2. Delete\n3. Display\n4. Search\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter item to insert: ");
                    String insertItem = scanner.nextLine();
                    listOperations.insert(insertItem);
                    break;
                case 2:
                    System.out.print("Enter item to delete: ");
                    String deleteItem = scanner.nextLine();
                    listOperations.delete(deleteItem);
                    break;
                case 3:
                    listOperations.display();
                    break;
                case 4:
                    System.out.print("Enter item to search: ");
                    String searchItem = scanner.nextLine();
                    listOperations.search(searchItem);
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
