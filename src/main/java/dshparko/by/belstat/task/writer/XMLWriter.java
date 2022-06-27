package dshparko.by.belstat.task.writer;

import dshparko.by.belstat.task.reader.csv.CSVFile;
import dshparko.by.belstat.task.reader.xml.models.Template;

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
import java.util.ArrayList;
import java.util.Random;

public class XMLWriter {
    public  Random random = new Random();

    private Template template;
    public void writeXml(ArrayList<CSVFile> csvFiles, Template template) {

        this.template = template;
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


    private  void writeXml(OutputStream out) throws XMLStreamException {

        XMLOutputFactory output = XMLOutputFactory.newInstance();

        XMLStreamWriter writer = output.createXMLStreamWriter(out);

        writer.writeStartDocument("utf-8", "1.0");


        writer.writeStartElement("REPORT_ROOT");
        writer.writeStartElement("REPORT");

        writer.writeStartElement("DESCRIPTION");

        writer.writeAttribute("APP_VER", "22.1.4.14.ARM");

        writer.writeAttribute("DB_VER", "3");
        writer.writeAttribute("FT_VER", String.valueOf(template.getDescription().getVersionNumber()));

        writer.writeAttribute("COMMENT", String.valueOf(random.nextInt(50000)));
        writer.writeAttribute("ID_REF", "-1");
        writer.writeAttribute("ID_FT", String.valueOf(template.getDescription().getTemplateId()));
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
        for(int i =0; i <template.getReferenceLists().size();i++) {
            writer.writeStartElement("row");

            writer.writeAttribute("ID_REF", String.valueOf(template.getReferenceLists().get(i).getFirstReferenceId()));

            writer.writeAttribute("ID_REFLST",  String.valueOf(template.getReferenceLists().get(i).getId()));
            writer.writeAttribute("ID_ROWRPT", "8 029 113-17-89; 8 017 511-99-55 (вн.1163)");//CHANGE!
            writer.writeAttribute("ID_DTABLE", "zaitseva@yurkas.by");//CHANGE!
            writer.writeAttribute("NUMBER_ROW", "8 029 113-17-89; 8 017 511-99-55 (вн.1163)");//CHANGE!
            writer.writeAttribute("ID_DROW", "zaitseva@yurkas.by");//CHANGE!
            writer.writeAttribute("TYPE_ROW", "zaitseva@yurkas.by");//CHANGE!
            writer.writeEndElement();
        }
        writer.writeEndElement();

        writer.writeStartElement("GRAPH_CELL");
        writer.writeStartElement("row");
        writer.writeAttribute("ID_ROWRPT", "146");//CHANGE!
        writer.writeAttribute("ID_DGP", "83245");//CHANGE!
        writer.writeAttribute("ID_UOM", "163");//CHANGE!
        writer.writeAttribute("VALUE_GCELL", "1");//CHANGE!
        writer.writeEndElement();
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

    private  String formatXML(String xml) throws TransformerException {
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
