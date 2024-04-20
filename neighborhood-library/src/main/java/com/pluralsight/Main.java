package com.pluralsight;

import java.util.Scanner;

public class Main
{
    static Scanner userInput = new Scanner(System.in); // Scanner object for user input
    static final int MAX_BOOKS = 20; // Maximum number of books that can be stored
    static int bookCount = 0; // Count of books currently stored
    static final Book[] books = new Book[MAX_BOOKS]; // Array to store Book objects

    // Method to display the main menu options
    public static void displayMainMenu()
    {
        String[] menuOptions =
                {
                        "1 - Show Available Books",
                        "2 - Show Checked Out Books",
                        "3 - Exit (Close App)"
                };

        // Calculate the maximum length of menu options for formatting
        int maxLength = 0;
        for (String option : menuOptions)
        {
            if (option.length() > maxLength)
            {
                maxLength = option.length();
            }
        }
        int boxWidth = maxLength + 4; // Adding 4 for padding and borders
        String horizontalLine = "+" + "-".repeat(boxWidth) + "+";

        // Print the formatted menu
        System.out.println(horizontalLine);
        for (String option : menuOptions)
        {
            String paddedOption = "| " + option + " ".repeat(boxWidth - option.length() - 3) + "|";
            System.out.println(paddedOption);
        }
        System.out.println(horizontalLine);
    }

    public static void main(String[] args)
    {
        // Preload books into the library
        preloadBooks();

        int choice = 0;
        while (choice != 3) // Continue displaying menu until user chooses to exit
        {
            // Display the main menu
            System.out.println();
            System.out.println("Welcome to your Neighborhood Library!");
            displayMainMenu();
            System.out.println("Enter your command command here: ");
            choice = Integer.parseInt(userInput.nextLine());

            // Handle user's choice
            switch (choice)
            {
                case 1:
                    showAvailableBooks(books); // Show available books
                    break;
                case 2:
                    showCheckedOutBooks(books); // Show checked out books
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Goodbye!"); // Exit the program
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid selection"); // Invalid menu choice
                    break;
            }
        }
    }

    // Method to preload books into the library
    public static void preloadBooks()
    {
        // Initialize books array with preloaded book objects
        // (ID, ISBN, Title)
        books[0] = new Book(1, "6789998212", "The Lightning Thief");
        // Add more books here...
        bookCount = 20; // Set the book count
    }
}