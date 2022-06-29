package dshparko.by.belstat.task;

import dshparko.by.belstat.task.reader.csv.CSVFile;
import dshparko.by.belstat.task.reader.xml.models.Template;
import dshparko.by.belstat.task.writer.XMLWriter;

import java.util.ArrayList;

public class GenerateReport {

    public ArrayList<String> generateReport(ArrayList<CSVFile> csvFiles, Template template) {
        ArrayList<String> newCsvFiles;
        CsvXmlHandler csvXmlHandler = new CsvXmlHandler();
        newCsvFiles = csvXmlHandler.excludeLines(csvFiles,template);
     //   for(int i = 0;i<newCsvFiles.size();i++){
      //      System.out.println(newCsvFiles.get(i));
     //   }
        XMLWriter xmlWriter = new XMLWriter();
        xmlWriter.writeXml(csvFiles,template);
        return newCsvFiles;
    }
}
