package com.solvegen.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.solvegen.test.dao.Book;
import com.solvegen.test.dao.BookDao;
import com.solvegen.test.xml.BookXml;
import com.solvegen.test.xml.CatalogXml;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Maksim Ahramovich
 */
@Controller
public class BookController {
    private static Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "changeBook", method = RequestMethod.POST)
    public void changeBook(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("Receive book request");
        if (request.getContentLength() > 0) {
            try (InputStream is = request.getInputStream()) {
                String bookString = IOUtils.toString(is);
                logger.debug("Request book: {}", bookString);

                if(!bookString.isEmpty()) {
                    Book book = BookXml.deserialize(bookString).getBook();
                    logger.debug("Update book: {}", book);
                    bookDao.insertOrUpdate(book);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try(PrintWriter writer = new PrintWriter(response.getOutputStream())){
            List<Book> books = bookDao.getBooks();
            logger.debug("Response books: {}", books);
            writer.write(new CatalogXml(books).serialize());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
