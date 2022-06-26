package dshparko.by.belstat.task.reader.xml;

import dshparko.by.belstat.task.reader.Reader;
import dshparko.by.belstat.task.reader.xml.models.Template;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class XMLReader implements Reader {

    private Template temp;

    public Template getXMLTemplate() {
        return this.temp;
    }


    @Override
    public void fileRead(String filename) {
      //  temp = new Template();
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            SAXReader handler = new SAXReader();
            saxParser.parse(new File(filename), handler);
            temp = handler.getXMLTemplate();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }


}
