package dshparko.by.belstat.task.reader;

import dshparko.by.belstat.task.reader.models.Layout;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

public class SAXReader {
    private static ArrayList<Layout> layout = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
    }

    private static class XMLHandler extends DefaultHandler {

        @Override
        //change tags
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("TEMPLATE_ROOT/TEMPLATE_GSN/DESCRIPTION")) {
                String layoutDescription = attributes.getValue("TEMPLATE_ROOT/TEMPLATE_GSN/PARTS/TABLES");
                String tablesDescription = attributes.getValue("///");
                String graphsDescription = attributes.getValue("//");
                String rowsDescription = attributes.getValue("//");
                String cellsDescription = attributes.getValue("///");
                String referencesDescription = attributes.getValue("//");
                String uomReferences = attributes.getValue("REFERENCE_POSITIONS");
                String positionsReferences = attributes.getValue("REFERENCE_UOM");
                String unitDescription = attributes.getValue("TEMPLATE_ROOT/TEMPLATE_GSN/UNIT_OF_MEASURE");
                layout.add(new Layout(layoutDescription, tablesDescription, graphsDescription, rowsDescription, cellsDescription, referencesDescription, uomReferences, positionsReferences, unitDescription));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Тут будет логика реакции на конец элемента
        }

    }
}
