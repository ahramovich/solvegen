package com.solvegen.test.xml;

import com.solvegen.test.dao.Book;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.core.Persister;

/**
 * @author Maksim Ahramovich
 */
public class BookXml {
    @Attribute
    private String id;
    @Element
    private String author;
    @Element
    private String title;
    @Element
    private String genre;
    @Element
    private double price;
    @Element(name = "publish_date")
    private String publishDate;
    @Element
    private String description;

    public BookXml(){
    }

    public BookXml(Book book) {
        this.id = book.id;
        this.author = book.author;
        this.title = book.title;
        this.genre = book.genre;
        this.price = book.price;
        this.publishDate = book.publishDate;
        this.description = book.description;
    }

    public Book getBook() {
        return new Book(id, author, title, genre, price, publishDate, description);
    }

    public static BookXml deserialize(String s) {
        try {
            return new Persister().read(BookXml.class, s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookXml)) return false;

        BookXml bookXml = (BookXml) o;

        if (Double.compare(bookXml.price, price) != 0) return false;
        if (author != null ? !author.equals(bookXml.author) : bookXml.author != null) return false;
        if (description != null ? !description.equals(bookXml.description) : bookXml.description != null) return false;
        if (genre != null ? !genre.equals(bookXml.genre) : bookXml.genre != null) return false;
        if (id != null ? !id.equals(bookXml.id) : bookXml.id != null) return false;
        if (publishDate != null ? !publishDate.equals(bookXml.publishDate) : bookXml.publishDate != null) return false;
        if (title != null ? !title.equals(bookXml.title) : bookXml.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
