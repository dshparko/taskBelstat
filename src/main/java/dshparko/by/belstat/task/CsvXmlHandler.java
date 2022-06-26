package dshparko.by.belstat.task;


import dshparko.by.belstat.task.reader.csv.CSVFile;
import dshparko.by.belstat.task.reader.xml.models.Template;

import java.util.ArrayList;

public class CsvXmlHandler {


    public void excludeLines(ArrayList<CSVFile> csvFiles, Template template){
        int size = template.getParts().size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < template.getParts().get(i).getTables().size(); j++) {
                for (int k = 0; k < csvFiles.size(); k++) {

                    //     System.out.println(template.getParts().get(i).getTables().get(j).getNumber()+"     "+Integer.parseInt(csvFiles.get(k).getTableNumber()));
                    if (Integer.parseInt(csvFiles.get(k).getTableNumber())==(template.getParts().get(i).getTables().get(j).getNumber())) {
                        System.out.println("True");
                        //     System.out.println(template.getParts().get(i).getTables().get(j).getNumber()+"     "+Integer.parseInt(csvFiles.get(k).getTableNumber()));
                    }
                }
            }
        }
    }
}
