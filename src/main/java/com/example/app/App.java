package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("===== BANK MANAGEMENT SYSTEM STARTED =====");

        System.out.println("\n====================================");
        System.out.println("      BANK MANAGEMENT SYSTEM");
        System.out.println("====================================");

        // Create Accounts
        BankAccount account1 = new BankAccount(1001, "Aryan", 5000);
        BankAccount account2 = new BankAccount(1002, "Rahul", 3000);

        System.out.println("\nAccounts Created Successfully");

        account1.displayAccountDetails();
        account2.displayAccountDetails();

        // Deposit
        BankService.deposit(account1, 2000);

        // Withdraw
        BankService.withdraw(account1, 1500);

        // Transfer
        BankService.transfer(account1, account2, 1000);

        // Interest
        double interest = InterestCalculator.calculateInterest(
                account1.getBalance(),
                5,
                2
        );

        System.out.println("\nInterest Calculated: ₹" + interest);

        // Transaction History
        TransactionService.showTransactions();

        // Final Balance
        System.out.println("\n====================================");
        System.out.println("FINAL ACCOUNT DETAILS");
        System.out.println("====================================");

        account1.displayAccountDetails();
        account2.displayAccountDetails();

        logger.info("===== APPLICATION EXECUTED SUCCESSFULLY =====");
    }
}package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static final Logger logger =
            LoggerFactory.getLogger(App.class);

    private static final ArrayList<Book> books =
            new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        logger.info("===== LIBRARY MANAGEMENT SYSTEM STARTED =====");

        while (true) {

            System.out.println("\n====================================");
            System.out.println("     LIBRARY MANAGEMENT SYSTEM");
            System.out.println("====================================");

            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");

            System.out.print("\nEnter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addBook(sc);
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    searchBook(sc);
                    break;

                case 4:
                    deleteBook(sc);
                    break;

                case 5:
                    logger.info("Application Closed");
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // Add Book
    public static void addBook(Scanner sc) {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        Book book = new Book(id, name, author);

        books.add(book);

        logger.info("Book Added Successfully");

        System.out.println("Book Added Successfully");
    }

    // View Books
    public static void viewBooks() {

        if (books.isEmpty()) {

            System.out.println("No Books Available");

            return;
        }

        System.out.println("\n===== BOOK LIST =====");

        for (Book book : books) {

            System.out.println(book);
        }
    }

    // Search Book
    public static void searchBook(Scanner sc) {

        System.out.print("Enter Book ID to Search: ");

        int id = sc.nextInt();

        for (Book book : books) {

            if (book.getId() == id) {

                System.out.println("Book Found:");
                System.out.println(book);

                return;
            }
        }

        System.out.println("Book Not Found");
    }

    // Delete Book
    public static void deleteBook(Scanner sc) {

        System.out.print("Enter Book ID to Delete: ");

        int id = sc.nextInt();

        for (Book book : books) {

            if (book.getId() == id) {

                books.remove(book);

                logger.info("Book Deleted Successfully");

                System.out.println("Book Deleted Successfully");

                return;
            }
        }

        System.out.println("Book Not Found");
    }
}

// Book Class
class Book {

    private int id;
    private String name;
    private String author;

    public Book(int id, String name, String author) {

        this.id = id;
        this.name = name;
        this.author = author;
    }

    public int getId() {

        return id;
    }

    @Override
    public String toString() {

        return "Book ID: " + id
                + " | Name: " + name
                + " | Author: " + author;
    }
}
