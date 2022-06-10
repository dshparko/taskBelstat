package dshparko.by.belstat.task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

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
        openFile(description,extensions);
    }

    @FXML
    void onOpenXML(ActionEvent event) {
        String description = "XML";
        List<String> extensions = Collections.singletonList("*.xml");
        openFile(description,extensions);
    }

    File openFile(String description, List<String> extensions) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(description, extensions));
        File selectedFile = fileChooser.showOpenDialog(null);
        return selectedFile;
    }

    @FXML
    void initialize() {
        assert scvButton != null : "fx:id=\"scvButton\" was not injected: check your FXML file 'main-view.fxml'.";
        assert xmlButton != null : "fx:id=\"xmlButton\" was not injected: check your FXML file 'main-view.fxml'.";

    }

}
