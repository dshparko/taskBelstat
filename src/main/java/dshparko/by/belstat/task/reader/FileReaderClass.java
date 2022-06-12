package dshparko.by.belstat.task.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderClass implements ReaderInterface {


    private StringBuilder lines;
    private String text;

    @Override
    public void fileRead(String filename) throws IOException {

        lines = new StringBuilder();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filename);
            String str;
            bufferedReader = new BufferedReader(fileReader);
            while ((str = bufferedReader.readLine()) != null) {
                lines.append(str.replaceAll(" ", ""));
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < lines.length(); i++) {
            text += lines.charAt(i);
        }
        //  System.out.println(text);
        System.out.println("Success!");
    }


}