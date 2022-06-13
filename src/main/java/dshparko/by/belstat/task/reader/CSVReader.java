package dshparko.by.belstat.task.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader implements ReaderInterface {


    private StringBuilder lines;
    private String text = "";

    public int checkLine(String str) {
        String[] count = str.split(";");
        return count.length;
    }

    public String fixLine(String str) {
        String newStr = "";
        String[] count = str.split(";");
        for (int i = 0; i < 5; i++) {
            newStr += count[i];
            if (i != 4) {
                newStr += ';';
            }
        }
        return newStr;
    }

    public CSVFile initialize(String str) {

        String[] count = str.split(";");

        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }

        CSVFile scvFile = new CSVFile(count[0], count[1], count[2], count[3], count[4], count[5]);

        return scvFile;
    }


    @Override
    public void fileRead(String filename) {
        ArrayList<CSVFile> CSVList = new ArrayList<CSVFile>();
        lines = new StringBuilder();
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(filename);
            String str;
            int count;
            bufferedReader = new BufferedReader(fileReader);
            while ((str = bufferedReader.readLine()) != null) {
                count = checkLine(str);
                if (count > 6) {
                    str = fixLine(str);
                    count = 5;
                }
                if (count == 6) {
                    lines.append(str.replaceAll(";;", ";-;"));

                    lines.append('\n');
                }
                CSVList.add(initialize(str));
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < lines.length(); i++) {
            text += lines.charAt(i);
        }
        //   System.out.println(text);
        System.out.println("Success!");
    }


}
