package dshparko.by.belstat.task.reader;

public class CSVFile {

    private int tableNumber;
    private int graphNumber;
    private int lineCode;
    private String fourthCell;
    private int unitCode;
    private double value;

    public CSVFile(int tableNumber, int graphNumber, int lineCode, String fourthCell, int unitCode, double value) {
        this.tableNumber = tableNumber;
        this.graphNumber = graphNumber;
        this.lineCode = lineCode;
        this.fourthCell = fourthCell;
        this.unitCode = unitCode;
        this.value = value;

    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setGraphNumber(int graphNumber) {
        this.graphNumber = graphNumber;
    }

    public int getGraphNumber() {
        return graphNumber;
    }

    public void setLineCode(int lineCode) {
        this.lineCode = lineCode;
    }

    public int getLineCode() {
        return lineCode;
    }

    public void setFourthCell(String fourthCell) {
        this.fourthCell = fourthCell;
    }


    public String getFourthCell() {
        return fourthCell;
    }

    public void setUnitCode(int unitCode) {
        this.unitCode = unitCode;
    }

    public int getUnitCode() {
        return unitCode;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }


}
