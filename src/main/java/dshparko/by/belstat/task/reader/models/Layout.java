package dshparko.by.belstat.task.reader.models;

public class Layout {
    private String layoutDescription;
    private String tablesDescription;
    private String graphsDescription;
    private String rowsDescription;
    private String cellsDescription;
    private String referencesDescription;
    private String uomReferences;
    private String positionsReferences;
    private String unitDescription;

    public Layout(String layoutDescription, String tablesDescription, String graphsDescription, String rowsDescription, String cellsDescription, String referencesDescription, String uomReferences, String positionsReferences, String unitDescription) {
        this.layoutDescription = layoutDescription;
        this.tablesDescription = tablesDescription;
        this.graphsDescription = graphsDescription;
        this.rowsDescription = rowsDescription;
        this.referencesDescription = referencesDescription;
        this.cellsDescription = cellsDescription;
        this.uomReferences = uomReferences;
        this.positionsReferences = positionsReferences;
        this.unitDescription = unitDescription;
    }

    public String getLayoutDescription() {
        return layoutDescription;
    }

    public String getTablesDescription() {
        return tablesDescription;
    }

    public String getGraphsDescription() {
        return graphsDescription;
    }

    public String getRowsDescription() {
        return rowsDescription;
    }

    public String getReferencesDescription() {
        return referencesDescription;
    }

    public String getCellsDescription() {
        return cellsDescription;
    }

    public String getUomReferences() {
        return uomReferences;
    }

    public String getPositionsReferences() {
        return positionsReferences;
    }

    public String getUnitDescription() {
        return unitDescription;
    }


}
