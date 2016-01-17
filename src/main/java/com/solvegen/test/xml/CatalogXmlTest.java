package com.solvegen.test.xml;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;

import com.solvegen.test.dao.Book;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Maksim Ahramovich
 */
public class CatalogXmlTest {
    @Test
    public void test() {
        Book book1 = new Book("bk101", "Gambardella, Matthew", "XML Developer's Guide", "Computer", 44.95,
                new GregorianCalendar(2000, 9, 01).getTime(), "An in-depth look at creating applications with XML.");
        Book book2 = new Book("bk102", "Ralls, Kim", "Midnight Rain", "Fantasy", 5.95,
                new GregorianCalendar(2000, 11, 16).getTime(),
                "A former architect battles corporate zombies, an evil sorceress, and her own childhood to become queen of the world.");
        CatalogXml catalog = new CatalogXml(Arrays.asList(new Book[]{book1, book2}));

        Assert.assertEquals(getCatalogXml(), catalog.serialize());
        Assert.assertEquals(catalog, CatalogXml.deserialize(getCatalogXml()));
    }

    private String getCatalogXml() {
        return "<?xml version=\"1.0\"?>\n" +
                "<catalog>\n" +
                "   <book id=\"bk101\">\n" +
                "      <author>Gambardella, Matthew</author>\n" +
                "      <title>XML Developer's Guide</title>\n" +
                "      <genre>Computer</genre>\n" +
                "      <price>44.95</price>\n" +
                "      <publish_date>2000-10-01</publish_date>\n" +
                "      <description>An in-depth look at creating applications with XML.</description>\n" +
                "   </book>\n" +
                "   <book id=\"bk102\">\n" +
                "      <author>Ralls, Kim</author>\n" +
                "      <title>Midnight Rain</title>\n" +
                "      <genre>Fantasy</genre>\n" +
                "      <price>5.95</price>\n" +
                "      <publish_date>2000-12-16</publish_date>\n" +
                "      <description>A former architect battles corporate zombies, an evil sorceress, and her own childhood to become queen of the world.</description>\n" +
                "   </book>\n" +
                "</catalog>";
    }
}
