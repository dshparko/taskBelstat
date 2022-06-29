package dshparko.by.belstat.task;


import dshparko.by.belstat.task.reader.csv.CSVFile;
import dshparko.by.belstat.task.reader.xml.models.Template;

import java.util.ArrayList;

public class CsvXmlHandler {
    ArrayList<String> report = new ArrayList<>();

    public ArrayList<String> excludeLines(ArrayList<CSVFile> csvFiles, Template template) {
        checkLineCode(csvFiles,template);
        checkTables(csvFiles,template);
        checkGraphs(csvFiles,template);
        checkValue(csvFiles,template);
        return report;
    }


    public ArrayList<String> checkGraphs(ArrayList<CSVFile> csvFiles, Template template) {
        boolean isGraph;
        for (int k = 0; k < csvFiles.size(); k++) {
            isGraph = true;
            for (int j = 0; j < template.getParts().get(0).getTables().get(0).getGraphs().size(); j++) {
                if ((csvFiles.get(k).getGraphNumber()).equals(String.valueOf(template.getParts().get(0).getTables().get(0).getGraphs().get(j).getNumber()))) {
                    //System.out.println(csvFiles.get(k).getGraphNumber()+"   "+template.getParts().get(0).getTables().get(0).getGraphs().get(j).getNumber());
                    isGraph = false;
                    break;
                }
            }
            if (isGraph) {
                report.add("Line number " + k + 1 + " graph with the specified number was not found");
                System.out.println("Line number " + k + 1 + " graph with the specified number was not found");
            }
        }

        return report;
    }


    public ArrayList<String> checkTables(ArrayList<CSVFile> csvFiles, Template template) {
        boolean isGraph;
        for (int k = 0; k < csvFiles.size(); k++) {
            isGraph = true;
            for (int j = 0; j < template.getParts().get(0).getTables().size(); j++) {
                if ((csvFiles.get(k).getTableNumber()).equals(String.valueOf(template.getParts().get(0).getTables().get(j).getNumber()))) {
                    //System.out.println(csvFiles.get(k).getGraphNumber()+"   "+template.getParts().get(0).getTables().get(0).getGraphs().get(j).getNumber());
                    isGraph = false;
                    break;
                }
            }
            if (isGraph) {
                report.add("Line number " + k + 1 + " table with the specified number was not found");
                System.out.println("Line number " + k + 1 + " table with the specified number was not found");
            }
        }

        return report;
    }

    public ArrayList<String> checkLineCode(ArrayList<CSVFile> csvFiles, Template template) {
        boolean isGraph;
        for (int k = 0; k < csvFiles.size(); k++) {
            isGraph = true;
            for (int j = 0; j < template.getParts().get(0).getTables().get(0).getRows().size(); j++) {
                if ((csvFiles.get(k).getLineCode()).equals(String.valueOf(template.getParts().get(0).getTables().get(0).getRows().get(j).getCode()))) {
                    //System.out.println(csvFiles.get(k).getGraphNumber()+"   "+template.getParts().get(0).getTables().get(0).getGraphs().get(j).getNumber());
                    isGraph = false;
                    break;
                }
            }
            if (isGraph) {
                report.add("Line number " + (k + 1) + " linecode with the specified number was not found");
                System.out.println("Line number " + (k + 1) + " linecode with the specified number was not found");
            }
        }

        return report;
    }

    public ArrayList<String> checkValue(ArrayList<CSVFile> csvFiles, Template template) {
        for (int k = 0; k < csvFiles.size(); k++) {
            if (!(csvFiles.get(k).getValue()).matches("^[-+]?[0-9]*[.]?[0-9]+(?:[eE][-+]?[0-9]+)?$")) {
                report.add("Line number " + (k + 1) + " value is not valid");
                System.out.println("Line number " + (k + 1) + " value is not valid");
            }

        }
        return report;
    }

}
