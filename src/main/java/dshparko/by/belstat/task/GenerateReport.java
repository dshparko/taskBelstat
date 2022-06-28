package dshparko.by.belstat.task;

import dshparko.by.belstat.task.reader.csv.CSVFile;
import dshparko.by.belstat.task.reader.xml.models.Template;
import dshparko.by.belstat.task.writer.XMLWriter;

import java.util.ArrayList;

public class GenerateReport {

    public void generateReport(ArrayList<CSVFile> csvFiles, Template template) {

        CsvXmlHandler csvXmlHandler = new CsvXmlHandler();
       // csvXmlHandler.excludeLines(csvFiles,template);
        XMLWriter xmlWriter = new XMLWriter();
        xmlWriter.writeXml(csvFiles,template);
    }
}
