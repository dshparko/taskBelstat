module dshparko.by.belstat.task {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.dataformat.xml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


    opens dshparko.by.belstat.task to javafx.fxml;
    exports dshparko.by.belstat.task;
}