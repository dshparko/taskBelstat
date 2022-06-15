package dshparko.by.belstat.task.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader implements ReaderInterface {


    public CSVFile initialize(String str) {
        CSVFile csvFile = null;
        String[] count = str.split(";");
        if (count.length > 5)
            csvFile = new CSVFile(count[0], count[1], count[2], count[3], count[4], count[5]);

        return csvFile;
    }


    @Override
    public void fileRead(String filename) {
        ArrayList<CSVFile> CSVList = new ArrayList<>();
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(filename);
            String str;
            CSVFile CSVLine;
            bufferedReader = new BufferedReader(fileReader);
            while ((str = bufferedReader.readLine()) != null) {
                CSVLine = initialize(str);
                if (CSVLine != null)
                    CSVList.add(CSVLine);
            }
            System.out.println("Success!");
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
