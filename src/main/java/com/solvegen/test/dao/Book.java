package com.solvegen.test.dao;

import java.util.Date;

/**
 * @author Maksim Ahramovich
 */
public class Book {
    public final String id;
    public final String author;
    public final String title;
    public final String genre; // Enum?
    public final Double price;
    public final Date publishDate;
    public final String description;


    public Book(String id, String author, String title, String genre, Double price, Date publishDate, String description) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.publishDate = publishDate;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                ", description='" + description + '\'' +
                '}';
    }
}
