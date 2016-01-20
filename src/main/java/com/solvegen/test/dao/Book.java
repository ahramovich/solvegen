package com.solvegen.test.dao;

/**
 * @author Maksim Ahramovich
 */
public class Book {
    public final String id;
    public final String author;
    public final String title;
    public final String genre; // Enum?
    public final Double price;
    public final String publishDate;
    public final String description;


    public Book(String id, String author, String title, String genre, Double price, String publishDate, String description) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (description != null ? !description.equals(book.description) : book.description != null) return false;
        if (genre != null ? !genre.equals(book.genre) : book.genre != null) return false;
        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (price != null ? !price.equals(book.price) : book.price != null) return false;
        if (publishDate != null ? !publishDate.equals(book.publishDate) : book.publishDate != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
