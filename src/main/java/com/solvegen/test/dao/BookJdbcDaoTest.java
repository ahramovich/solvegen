package com.solvegen.test.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Maksim Ahramovich
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DaoContextConfiguration.class})
@Transactional
public class BookJdbcDaoTest {
    @Autowired
    private BookDao bookDao;

    @Test
       public void test() {
           Book book1 = new Book("1", "author1", "title1", "genre1", 1d, "2000-01-01", "description1");
           Book book2 = new Book("1", "author2", "title2", "genre2", 2d, "2000-02-02", "description2");
           Book book3 = new Book("3", "author3", "title3", "genre3", 3d, "2000-03-03", "description3");

           bookDao.insertOrUpdate(book1);
           Assert.assertEquals(1, bookDao.getBooks().size());
           Assert.assertEquals(book1, bookDao.getBooks().get(0));

           bookDao.insertOrUpdate(book2);
           Assert.assertEquals(1, bookDao.getBooks().size());
           Assert.assertEquals(book2, bookDao.getBooks().get(0));

           bookDao.insertOrUpdate(book3);
           Assert.assertEquals(2, bookDao.getBooks().size());
       }
}
