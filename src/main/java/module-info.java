module dshparko.by.belstat.task {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens dshparko.by.belstat.task to javafx.fxml;
    exports dshparko.by.belstat.task;
}