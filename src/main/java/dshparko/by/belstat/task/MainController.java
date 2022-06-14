package dshparko.by.belstat.task;

import dshparko.by.belstat.task.reader.CSVReader;
import dshparko.by.belstat.task.reader.XMLReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.System.exit;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button scvButton;

    @FXML
    private Button xmlButton;

    @FXML
    void onOpenSCV(ActionEvent event) {
        String description = "CSV";
        List<String> extensions = Collections.singletonList("*.csv");
        File selectedFile = openFile(description, extensions);
        CSVReader fileR = new CSVReader();
        fileR.fileRead(selectedFile.getPath());
    }

    @FXML
    void onOpenXML(ActionEvent event) {
        String description = "XML";
        List<String> extensions = Collections.singletonList("*.xml");
        File selectedFile = openFile(description, extensions);
        XMLReader fileR = new XMLReader();
        fileR.fileRead(selectedFile.getPath());
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
