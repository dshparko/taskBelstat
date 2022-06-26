package dshparko.by.belstat.task.writer;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class XMLWriter {
    public static Random random = new Random();

    public static void main(String[] args) {

        try {

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            writeXml(out);


            String xml = out.toString(StandardCharsets.UTF_8);


            String prettyPrintXML = formatXML(xml);

            System.out.println(prettyPrintXML);

            Files.writeString(Paths.get("C:\\Users\\Lenovo\\OneDrive - bsuir.by\\Рабочий стол\\task\\src\\main\\java\\dshparko\\by\\belstat\\task\\writer\\test.xml"),
                    prettyPrintXML, StandardCharsets.UTF_8);

        } catch (TransformerException | XMLStreamException | IOException e) {
            e.printStackTrace();
        }

    }


    private static void writeXml(OutputStream out) throws XMLStreamException {

        XMLOutputFactory output = XMLOutputFactory.newInstance();

        XMLStreamWriter writer = output.createXMLStreamWriter(out);

        writer.writeStartDocument("utf-8", "1.0");


        writer.writeStartElement("REPORT_ROOT");
        writer.writeStartElement("REPORT");

        writer.writeStartElement("DESCRIPTION");

        writer.writeAttribute("APP_VER", "22.1.4.14.ARM");
        writer.writeAttribute("DB_VER", "5");

        writer.writeAttribute("COMMENT", String.valueOf(random.nextInt(50000)));
        writer.writeAttribute("ID_REF", "CHANGE");//CHANGE!
        writer.writeAttribute("ID_FT", "20214");//CHANGE!
        writer.writeAttribute("ID_P", "12639");//CHANGE!
        writer.writeAttribute("NAME_ESN", "");

        writer.writeStartElement("USERS");
        writer.writeAttribute("NAME", "Брокар А.Л.");//CHANGE!
        writer.writeAttribute("DEPARTMENT", "бухгалтерия");//CHANGE!
        writer.writeAttribute("PHONE", "8 029 113-17-89; 8 017 511-99-55 (вн.1163)");//CHANGE!
        writer.writeAttribute("EMAIL", "zaitseva@yurkas.by");//CHANGE!
        writer.writeEndElement();





        //   writer.writeComment("");

        writer.writeEndElement();


        writer.writeStartElement("ROW_REPORT");
        writer.writeAttribute("NAME", "Брокар А.Л.");//CHANGE!
        writer.writeAttribute("DEPARTMENT", "бухгалтерия");//CHANGE!
        writer.writeAttribute("PHONE", "8 029 113-17-89; 8 017 511-99-55 (вн.1163)");//CHANGE!
        writer.writeAttribute("EMAIL", "zaitseva@yurkas.by");//CHANGE!
        writer.writeEndElement();

        writer.writeStartElement("GRAPH_CELL");
        writer.writeAttribute("NAME", "Брокар А.Л.");//CHANGE!
        writer.writeAttribute("DEPARTMENT", "бухгалтерия");//CHANGE!
        writer.writeAttribute("PHONE", "8 029 113-17-89; 8 017 511-99-55 (вн.1163)");//CHANGE!
        writer.writeAttribute("EMAIL", "zaitseva@yurkas.by");//CHANGE!
        writer.writeEndElement();

        writer.writeEndElement();
        writer.writeEndDocument();


        writer.flush();

        writer.close();
      /*  writer.writeStartElement("name");
        writer.writeCharacters("mkyong");
        writer.writeEndElement();

        writer.writeStartElement("salary");
        writer.writeAttribute("currency", "USD");
        writer.writeCharacters("5000");
        writer.writeEndElement();

        writer.writeStartElement("bio");
        writer.writeCData("HTML tag <code>testing</code>");
        writer.writeEndElement();

        writer.writeEndElement();
        // </staff>

        // <staff>
        writer.writeStartElement("staff");
        writer.writeAttribute("id", "1002");

        writer.writeStartElement("name");
        writer.writeCharacters("yflow");
        writer.writeEndElement();

        writer.writeStartElement("salary");
        writer.writeAttribute("currency", "EUR");
        writer.writeCharacters("8000");
        writer.writeEndElement();

        writer.writeStartElement("bio");
        writer.writeCData("a & b");
        writer.writeEndElement();

        writer.writeEndElement();


        writer.writeEndDocument();


        writer.flush();

        writer.close();
*/
    }

    private static String formatXML(String xml) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();


        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

        StreamSource source = new StreamSource(new StringReader(xml));
        StringWriter output = new StringWriter();
        transformer.transform(source, new StreamResult(output));

        return output.toString();

    }


}
