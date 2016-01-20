package com.solvegen.test.xml;

import org.junit.Test;

/**
 * @author Maksim Ahramovich
 */
public class BookXmlTest {
    @Test(expected = RuntimeException.class)
    public void testNull() {
        BookXml.deserialize(getBookWithNullTitle());
    }

    @Test(expected = RuntimeException.class)
    public void testWrongDate() {
        BookXml.deserialize(getBookWithWrongDate());
    }

    @Test(expected = RuntimeException.class)
    public void testWrongDate2() {
        BookXml.deserialize(getBookWithWrongDate2());
    }


    private String getBookWithNullTitle() {
        return "<book id=\"bk101\">\n" +
                "   <author>Gambardella, Matthew</author>\n" +
                "   <genre>Computer</genre>\n" +
                "   <price>44.95</price>\n" +
                "   <publish_date>2000-10-01</publish_date>\n" +
                "   <description>An in-depth look at creating applications with XML.</description>\n" +
                "</book>";
    }

    private String getBookWithWrongDate() {
        return "<book id=\"bk101\">\n" +
                "   <author>Gambardella, Matthew</author>\n" +
                "   <title>XML Developer's Guide</title>\n" +
                "   <genre>Computer</genre>\n" +
                "   <price>44.95</price>\n" +
                "   <publish_date>2000-01</publish_date>\n" +
                "   <description>An in-depth look at creating applications with XML.</description>\n" +
                "</book>";
    }

    private String getBookWithWrongDate2() {
        return "<book id=\"bk101\">\n" +
                "   <author>Gambardella, Matthew</author>\n" +
                "   <title>XML Developer's Guide</title>\n" +
                "   <genre>Computer</genre>\n" +
                "   <price>44.95</price>\n" +
                "   <publish_date>2100-10-01</publish_date>\n" +
                "   <description>An in-depth look at creating applications with XML.</description>\n" +
                "</book>";
    }
}
