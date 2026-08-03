package ui;

import service.Library;
import model.Book;
import model.StudentMember;
import model.FacultyMember;
import java.util.Scanner;

public class MenuHandler {
    private final Library library = new Library();
    private final Scanner scanner = new Scanner(System.in);

    public void startMenu() {
        while (true) {
            System.out.println("\n--- LIBRARY MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    String bId = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    library.addBook(new Book(bId, title));
                }
                case 2 -> {
                    System.out.print("Enter Member ID: ");
                    String mId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Type (1 for Student, 2 for Faculty): ");
                    int type = scanner.nextInt();
                    if (type == 1) library.addMember(new StudentMember(mId, name));
                    else library.addMember(new FacultyMember(mId, name));
                }
                case 3 -> {
                    System.out.print("Enter Book ID: ");
                    String ibId = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String imId = scanner.nextLine();
                    library.issueBook(ibId, imId);
                }
                case 4 -> {
                    System.out.print("Enter Book ID: ");
                    String rbId = scanner.nextLine();
                    library.returnBook(rbId);
                }
                case 5 -> {
                    System.out.println("Exiting System...");
                    return;
                }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }
}