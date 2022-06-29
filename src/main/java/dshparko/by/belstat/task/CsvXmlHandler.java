package dshparko.by.belstat.task;


import dshparko.by.belstat.task.reader.csv.CSVFile;
import dshparko.by.belstat.task.reader.xml.models.Template;

import java.util.ArrayList;

public class CsvXmlHandler {

    public ArrayList<CSVFile> excludeLines(ArrayList<CSVFile> csvFiles, Template template) {
        ArrayList<String> report = new ArrayList<>();
        csvFiles = checkLineCode(csvFiles, template);
        csvFiles = checkTables(csvFiles, template);
        csvFiles = checkGraphs(csvFiles, template);
        csvFiles = checkValue(csvFiles, template);
        return csvFiles;
    }


    public ArrayList<CSVFile>  checkGraphs(ArrayList<CSVFile> csvFiles, Template template) {
        ArrayList<String> report = new ArrayList<>();
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
                csvFiles.remove(k);
                report.add("Line number " + (k + 1) + " graph with the specified number was not found");
                System.out.println("Line number " + (k + 1) + " graph with the specified number was not found");
            }
        }

        return csvFiles;
    }


    public ArrayList<CSVFile> checkTables(ArrayList<CSVFile> csvFiles, Template template) {
        ArrayList<String> report = new ArrayList<>();
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
                csvFiles.remove(k);
                report.add("Line number " + k + 1 + " table with the specified number was not found");
                System.out.println("Line number " + k + 1 + " table with the specified number was not found");
            }
        }

        return csvFiles;
    }

    public ArrayList<CSVFile> checkLineCode(ArrayList<CSVFile> csvFiles, Template template) {
        ArrayList<String> report = new ArrayList<>();
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
                csvFiles.remove(k);
                System.out.println("Line number " + (k + 1) + " linecode with the specified number was not found");
            }
        }

        return csvFiles;
    }

    public ArrayList<CSVFile> checkValue(ArrayList<CSVFile> csvFiles, Template template) {
        ArrayList<String> report = new ArrayList<>();
        for (int k = 0; k < csvFiles.size(); k++) {
            if (!(csvFiles.get(k).getValue()).matches("^[-+]?[0-9]*[.]?[0-9]+(?:[eE][-+]?[0-9]+)?$")) {
                report.add("Line number " + (k + 1) + " value is not valid");
                System.out.println("Line number " + (k + 1) + " value is not valid");
                csvFiles.remove(k);
            }

        }
        return csvFiles;
    }

}
