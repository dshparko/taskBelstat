package dshparko.by.belstat.task.reader.models;

public class Layout {
    private String layoutNumber;
    private String tablesNumber;
    private String graphsNumber;
    private String rowsCode;
    private String rowsName;
    private String cellsNumber;
    private String referencesNumber;
    private String uomReferences;
    private String positionsReferences;
    private String unitCode;

    public Layout(String layoutNumber, String tablesNumber, String graphsNumber, String rowsCode, String cellsNumber, String referencesNumber, String uomReferences, String positionsReferences, String unitCode) {
        this.layoutNumber = layoutNumber;
        this.tablesNumber = tablesNumber;
        this.graphsNumber = graphsNumber;
        this.rowsCode = rowsCode;
        this.referencesNumber = referencesNumber;
        this.cellsNumber = cellsNumber;
        this.uomReferences = uomReferences;
        this.positionsReferences = positionsReferences;
        this.unitCode = unitCode;
    }

    public Layout(){

    }

    public String getLayoutNumber() {
        return layoutNumber;
    }

    public String getTablesNumber() {
        return tablesNumber;
    }

    public String getGraphsNumber() {
        return graphsNumber;
    }

    public String getRowsNumber() {
        return rowsCode;
    }
    public String getRowsName() {
        return rowsName;
    }
    public String getReferencesNumber() {
        return referencesNumber;
    }

    public String getCellsNumber() {
        return cellsNumber;
    }

    public String getUomReferences() {
        return uomReferences;
    }

    public String getPositionsReferences() {
        return positionsReferences;
    }

    public String getUnitCode() {
        return unitCode;
    }







    public void setLayoutNumber(String layoutNumber) {
        this.layoutNumber= layoutNumber;
    }

    public void setTablesNumber(String tablesNumber) {
        this.layoutNumber= tablesNumber;
    }

    public void setGraphsNumber(String graphsNumber) {
        this.graphsNumber= graphsNumber;
    }

    public void setRowsNumber(String rowsCode) {
        this.rowsCode=rowsCode;
    }
    public void setRowsName(String rowsName) {
        this.rowsName=rowsName;
    }
    public void setReferencesNumber(String referencesNumber) {
        this.referencesNumber=referencesNumber;
    }

    public void setCellsNumber(String cellsNumber) {
        this.cellsNumber=cellsNumber;
    }

    public void setUomReferences(String uomReferences) {
        this.uomReferences=uomReferences;
    }

    public void setPositionsReferences(String positionsReferences) {
        this.positionsReferences= positionsReferences;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode= unitCode;
    }


}
