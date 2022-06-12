package dshparko.by.belstat.task.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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


    @Override
    public void fileRead(String filename) {

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
                if (count > 5) {
                    str = fixLine(str);
                    count = 5;
                }
                if (count == 5) {
                    lines.append(str.replaceAll(" ", ""));

                    lines.append('\n');
                }
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < lines.length(); i++) {
            text += lines.charAt(i);
        }
        System.out.println(text);
        System.out.println("Success!");
    }


}
