package com.pluralsight;

// Book class represents a book object with properties and methods
class Book
{
    // Properties of the book
    private int id; // Unique identifier for the book
    private String isbn; // International Standard Book Number
    private String title; // Title of the book
    private boolean isCheckedOut; // Flag indicating if the book is checked out
    private String checkedOutTo; // Name of the person who checked out the book

    // Constructor to initialize the book properties
    public Book(int id, String isbn, String title)
    {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false; // Initially, the book is not checked out
        this.checkedOutTo = ""; // Initially, no one has checked out the book
    }

    // Getter and setter methods for the properties

    }
}