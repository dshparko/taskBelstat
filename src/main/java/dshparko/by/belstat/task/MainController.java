package dshparko.by.belstat.task;

import dshparko.by.belstat.task.reader.csv.CSVFile;
import dshparko.by.belstat.task.reader.csv.CSVReader;
import dshparko.by.belstat.task.reader.xml.XMLReader;
import dshparko.by.belstat.task.reader.xml.XmlSerializer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.System.exit;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button generateButton;

    @FXML
    private ImageView xmlFile;

    @FXML
    private ImageView csvFile;

    @FXML
    private URL location;

    @FXML
    private Button scvButton;

    @FXML
    private Button xmlButton;


    @FXML
    void onGenerateButton(ActionEvent event) {
        if(csvFile.isVisible()&&xmlFile.isVisible()){
            GenerateReport generateReport = new GenerateReport();
            CSVReader csvReader = new CSVReader();
            ArrayList<CSVFile> list = csvReader.getCSVList();
            generateReport.generateReport(list,list);
        }
    }


    @FXML
    void onOpenSCV(ActionEvent event) {
        String description = "CSV";
        List<String> extensions = Collections.singletonList("*.csv");
        File selectedFile = openFile(description, extensions);
        CSVReader fileR = new CSVReader();
        fileR.fileRead(selectedFile.getPath());
        csvFile.setVisible(true);
    }

    @FXML
    void onOpenXML(ActionEvent event) throws IOException {
        String description = "XML";
        List<String> extensions = Collections.singletonList("*.xml");
        File selectedFile = openFile(description, extensions);
        XmlSerializer fileR = new XmlSerializer();
        fileR.fileRead(selectedFile.getPath());
        xmlFile.setVisible(true);
    }

    File openFile(String description, List<String> extensions) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(description, extensions));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            return selectedFile;
        } else {
            showMessage();
            exit(0);
            return null;
        }

    }


    void showMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("You have not selected any file");

        alert.showAndWait();
    }

    @FXML
    void initialize() {
    }

}
