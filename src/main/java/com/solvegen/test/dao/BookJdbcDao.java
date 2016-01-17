package com.solvegen.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Maksim Ahramovich
 */
@Transactional
public class BookJdbcDao implements BookDao {
    @Autowired
    private JdbcTemplate bookJdbcTemplate;

    @Override
    public void insertOrUpdate(Book book) {
        bookJdbcTemplate
                .update("insert into books (id, author, title, genre, price, publish_date, description)",
                        book.id, book.author, book.title, book.genre, book.price, book.publishDate, book.description);
    }

    @Override
    public List<Book> getBooks() {
        return bookJdbcTemplate.query("select * from books", new BookMapper());
    }


    private static class BookMapper implements RowMapper<Book> {
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Book(rs.getString("id"), rs.getString("author"), rs.getString("title"), rs.getString("genre"),
                    rs.getDouble("price"), rs.getDate("publish_date"), rs.getString("description"));
        }
    }
}
