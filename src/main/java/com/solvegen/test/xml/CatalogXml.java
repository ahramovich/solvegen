package com.solvegen.test.xml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

import com.solvegen.test.dao.Book;
import org.apache.commons.lang3.StringEscapeUtils;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

/**
 * @author Maksim Ahramovich
 */
@Root(name = "catalog")
public class CatalogXml {
    @ElementList(entry = "book", type = BookXml.class, inline = true)
    private List<BookXml> books;

    public CatalogXml(){
    }

    public CatalogXml(List<Book> books) {
        this.books = books.stream().map(BookXml::new).collect(Collectors.toList());
    }

    public String serialize() {
        try (OutputStream os = new ByteArrayOutputStream()) {
            new Persister().write(this, os);
            return StringEscapeUtils.unescapeXml("<?xml version=\"1.0\"?>\n" + os.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static CatalogXml deserialize(String s) {
        try {
            return new Persister().read(CatalogXml.class, s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CatalogXml)) return false;

        CatalogXml that = (CatalogXml) o;

        if (books != null ? !books.equals(that.books) : that.books != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return books != null ? books.hashCode() : 0;
    }
}
