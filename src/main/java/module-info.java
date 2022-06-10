module dshparko.by.belstat.task {
    requires javafx.controls;
    requires javafx.fxml;


    opens dshparko.by.belstat.task to javafx.fxml;
    exports dshparko.by.belstat.task;
}