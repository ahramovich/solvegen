package com.solvegen.test.dao;

import java.util.List;

/**
 * @author Maksim Ahramovich
 */
public interface BookDao {
    void insertOrUpdate(Book book);

    List<Book> getBooks();
}
