package com.solvegen.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Maksim Ahramovich
 */
@Transactional
public class BookJdbcDao implements BookDao {
    @Autowired
    private JdbcTemplate bookJdbcTemplate;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 10)
    public void insertOrUpdate(Book book) {
        int sameBooksCount =
                bookJdbcTemplate.queryForObject("SELECT COUNT(*) FROM books WHERE book_id=?", Integer.class, book.id);
        if (sameBooksCount == 0) {
            bookJdbcTemplate.update(
                    "INSERT INTO books (book_id, author, title, genre, price, publish_date, description) VALUES (?, ?, ?, ?, ?, ?, ?)",
                    book.id, book.author, book.title, book.genre, book.price, book.publishDate, book.description);
        } else {
            bookJdbcTemplate.update(
                    "UPDATE books SET author=?, title=?, genre=?, price=?, publish_date=?, description=? WHERE book_id=?",
                    book.author, book.title, book.genre, book.price, book.publishDate, book.description, book.id);
        }
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 10)
    public List<Book> getBooks() {
        return bookJdbcTemplate.query("SELECT * FROM books", new BookMapper());
    }


    private static class BookMapper implements RowMapper<Book> {
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Book(rs.getString("id"), rs.getString("author"), rs.getString("title"), rs.getString("genre"),
                    rs.getDouble("price"), rs.getString("publish_date"), rs.getString("description"));
        }
    }
}
