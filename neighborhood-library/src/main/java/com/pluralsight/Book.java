package com.pluralsight;

public class Book {
    // Properties
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // Constructor
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    // Getters
    public int getId() { return id; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public boolean isCheckedOut() { return isCheckedOut; }
    public String getCheckedOutTo() { return checkedOutTo; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setTitle(String title) { this.title = title; }
    public void setCheckedOut(boolean isCheckedOut) { this.isCheckedOut = isCheckedOut; }
    public void setCheckedOutTo(String checkedOutTo) { this.checkedOutTo = checkedOutTo; }

    // Checkout method
    public void checkOut(String name) {
        if (!isCheckedOut) {
            isCheckedOut = true;
            checkedOutTo = name;
            System.out.println("This book is now checked out to " + name + ".");
        } else {
            System.out.println("This book is already checked out.");
        }
    }

    // Check In method
    public void checkIn() {
        if (isCheckedOut) {
            isCheckedOut = false;
            checkedOutTo = "";
            System.out.println("The book has been successfully checked in!");
        } else {
            System.out.println("This book is not currently checked out.");
        }
    }

    // toString method for Book info
    public String toString() {
        String status = isCheckedOut ? ", Checked Out To: " + checkedOutTo : "";
        return "Book ID: " + id + ", Title: " + title + ", ISBN: " + isbn + ", Checked Out: " + isCheckedOut + status;
    }
}