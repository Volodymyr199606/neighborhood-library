package com.pluralsight;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static final int MAX_BOOKS = 20;
    static int bookCount = 0;
    static final Book[] books = new Book[MAX_BOOKS];

    public static void displayMainMenu() {
        String[] menuOptions = {
                "1 - Show Available Books",
                "2 - Show Checked Out Books",
                "3 - Exit (Close Software)"
        };

        int maxLength = 0;
        for (String option : menuOptions) {
            maxLength = Math.max(maxLength, option.length());
        }
        int boxWidth = maxLength + 4;
        String horizontalLine = "+" + "-".repeat(boxWidth) + "+";

        System.out.println(horizontalLine);
        for (String option : menuOptions) {
            String paddedOption = "| " + option + " ".repeat(boxWidth - option.length() - 3) + "|";
            System.out.println(paddedOption);
        }
        System.out.println(horizontalLine);
    }

    public static void main(String[] args) {
        preloadBooks();

        int choice;
        do {
            System.out.println("\nWelcome to the local library in your neighborhood!");
            displayMainMenu();
            System.out.print("Enter your command here: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    showAvailableBooks();
                    break;
                case 2:
                    showCheckedOutBooks();
                    break;
                case 3:
                    System.out.println("\nTake care!");
                    break;
                default:
                    System.out.println("\nYour choice is not valid");
                    break;
            }
        } while (choice != 3);
    }

    public static void preloadBooks() {
        books[0] = new Book(1, "6789998212", "The Lightning Thief");
        books[1] = new Book(2, "6789998213", "The Sea Of Monsters");
        books[2] = new Book(3, "6789998214", "The Titan's Curse");
        books[3] = new Book(4, "6789998215", "The Battle of the Labyrinth");
        books[4] = new Book(5, "6789998216", "The Last Olympian");
        books[5] = new Book(6, "6789998217", "The Chalice of the Gods");
        books[6] = new Book(7, "6789998218", "Twilight");
        books[7] = new Book(8, "6789998219", "New Moon");
        books[8] = new Book(9, "6789998220", "Breaking Dawn");
        books[9] = new Book(10, "6789998221", "Eclipse");
        books[10] = new Book(11, "6789998222", "The Sorcerer's Stone");
        books[11] = new Book(12, "6789998223", "The Chamber of Secrets");
        books[12] = new Book(13, "6789998224", "The Prisoner of Azkaban");
        books[13] = new Book(14, "6789998225", "The Goblet of Fire");
        books[14] = new Book(15, "6789998226", "The Order of the Phoenix");
        books[15] = new Book(16, "6789998227", "The Half-Blood Prince");
        books[16] = new Book(17, "6789998228", "The Deathly Hallows");
        books[17] = new Book(18, "6789998229", "The Hunger Games");
        books[18] = new Book(19, "6789998230", "Catching Fire");
        books[19] = new Book(20, "6789998231", "Mockingjay");
        bookCount = 20;
    }

    public static void showAvailableBooks() {
        System.out.println("The available books are listed here:");
        for (int i = 0; i < bookCount; i++) {
            if (!books[i].isCheckedOut()) {
                System.out.println("Book " + (i + 1) + ":\n" + books[i] + "\n");
            }
        }
        System.out.print("Please input the number corresponding to the book you wish to borrow. (or 0 to go back): ");
        int userChoice = Integer.parseInt(scanner.nextLine());
        if (userChoice == 0) {
            System.out.println("You're being redirected to the homepage...");
            return;
        } else if (userChoice >= 1 && userChoice <= bookCount && !books[userChoice - 1].isCheckedOut()) {
            System.out.print("Enter your name: ");
            String userName = scanner.nextLine();
            Book selectedBook = books[userChoice - 1];
            selectedBook.checkOut(userName);
            System.out.println("\nThank you for checking out \"" + selectedBook.getTitle() + "\"!");
            System.out.println("Redirecting you back to the home page...");
        } else {
            System.out.println("The selection made is invalid. You'll be redirected back to the homepage...");
        }
    }

    public static void showCheckedOutBooks() {
        System.out.println("Here are the checked out books:");
        boolean hasCheckedOutBooks = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isCheckedOut()) {
                hasCheckedOutBooks = true;
                System.out.println("Book " + (i + 1) + ":\n" + books[i] + "\n");
            }
        }
        if (!hasCheckedOutBooks) {
            System.out.println("No books are currently checked out.");
        }
        System.out.print("Enter 'C' to check in a book, or 'X' to go back: ");
        String userChoice = scanner.nextLine().toUpperCase();
        switch (userChoice) {
            case "C":
                checkInBook();
                break;
            case "X":
                System.out.println("You're being directed back to the homepage...");
                break;
            default:
                System.out.println("Your selection is invalid. You'll be directed back to the homepage...");
                break;
        }
    }

    public static void checkInBook() {
        System.out.print("Please input the identification number of the book you wish to return: ");
        int bookId = Integer.parseInt(scanner.nextLine());
        if (bookId >= 1 && bookId <= bookCount && books[bookId - 1].isCheckedOut()) {
            books[bookId - 1].checkIn();
            System.out.println("Congratulations, the book was successfully checked in!");
        } else {
            System.out.println("The book ID provided is either incorrect or the book is not currently borrowed..");
        }
        System.out.println("You're being redirected to the homepage...");
    }
}