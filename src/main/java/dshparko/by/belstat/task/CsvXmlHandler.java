package dshparko.by.belstat.task;


import dshparko.by.belstat.task.reader.csv.CSVFile;
import dshparko.by.belstat.task.reader.xml.models.Template;

import java.util.ArrayList;

public class CsvXmlHandler {

    public void excludeLines(ArrayList<CSVFile> csvFiles, Template template) {
        for (int k = 0; k < csvFiles.size(); k++) {
            for (int j = 0; j < template.getParts().get(0).getTables().size(); j++) {

                if ((csvFiles.get(k).getGraphNumber()).matches("[-+]?\\d+") && Integer.parseInt(csvFiles.get(k).getGraphNumber()) == (template.getParts().get(0).getTables().get(j).getGraphs().get(j).getNumber())) {
                    System.out.println("True");
                }
                if (csvFiles.get(k).getLineCode().matches("[-+]?\\d+") && Integer.parseInt(csvFiles.get(k).getLineCode()) == (template.getParts().get(0).getTables().get(j).getRows().get(j).getCode())) {
                    System.out.println("True");
                }
                if (Integer.parseInt(csvFiles.get(k).getTableNumber()) == (template.getParts().get(0).getTables().get(j).getNumber())) {
                    System.out.println("True");
                }
                if (!(csvFiles.get(k).getFourthCell() == null)) {
                    System.out.println("True");
                }
                if (!(csvFiles.get(k).getUnitCode() == null)) {
                    System.out.println("True");
                }

            }
            if ((csvFiles.get(k).getValue()).matches("[-+]?\\d+") || csvFiles.get(k).getValue().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {
                System.out.println("True");
            }
        }
    }
}
