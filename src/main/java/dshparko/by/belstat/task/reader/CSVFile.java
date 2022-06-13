package dshparko.by.belstat.task.reader;

public class CSVFile {

    private String tableNumber;
    private String graphNumber;
    private String lineCode;
    private String fourthCell;
    private String unitCode;
    private String value;

    public CSVFile(String tableNumber, String graphNumber, String lineCode, String fourthCell, String unitCode, String value) {
        this.tableNumber = tableNumber;
        this.graphNumber = graphNumber;
        this.lineCode = lineCode;
        this.fourthCell = fourthCell;
        this.unitCode = unitCode;
        this.value = value;

    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setGraphNumber(String graphNumber) {
        this.graphNumber = graphNumber;
    }

    public String getGraphNumber() {
        return graphNumber;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setFourthCell(String fourthCell) {
        this.fourthCell = fourthCell;
    }


    public String getFourthCell() {
        return fourthCell;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
