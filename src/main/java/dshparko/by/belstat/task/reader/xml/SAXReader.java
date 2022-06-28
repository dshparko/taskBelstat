package dshparko.by.belstat.task.reader.xml;

import dshparko.by.belstat.task.reader.xml.models.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;


public class SAXReader extends DefaultHandler {


    private static final String TABLES = "TABLES";
    private static final String GRAPH_PROGRAPH = "GRAPH_PROGRAPH";
    private static final String ROW_IN_TABLE = "ROW_IN_TABLE";
    private static final String DEATH_GRAPH_CELL = "DEATH_GRAPH_CELL";
    private boolean isTable = false;
    private boolean isRows = false;
    private boolean isGraph = false;
    private boolean isCell = false;

    private ArrayList<TemplateTable> table;
    private ArrayList<UnitOfMeasure> uom;
    TemplateTable t;
    TemplateGraph g;
    TemplateRow r;
    UnitOfMeasure unitOfMeasure;


    ReferenceList rl;

    TemplateDescription description;
    UnitOfMeasureReference unitOfMeasureReference;
    TemplatePart templatePart;
    ArrayList<Period> periods;
    ArrayList<TemplateRow> rows;
    ArrayList<TemplateGraph> graphListWrapper;
    ArrayList<TemplatePart> parts;
    ArrayList<ReferenceList> referenceLists;
    ArrayList<UnitOfMeasureReference> unitOfMeasureReferences;
    private Template template;

    Period period;

    PeriodType periodType;

    public Template getXMLTemplate() {
        return this.template;
    }

    @Override
    public void startDocument() {
        unitOfMeasureReference = new UnitOfMeasureReference();
        unitOfMeasureReferences = new ArrayList<>();
        unitOfMeasure = new UnitOfMeasure();
        rl = new ReferenceList();
        periodType = new PeriodType();
        period = new Period();
        periods = new ArrayList<>();
        description = new TemplateDescription();
        table = new ArrayList<>();
        t = new TemplateTable();
        g = new TemplateGraph();
        r = new TemplateRow();


        templatePart = new TemplatePart();

        referenceLists = new ArrayList<>();
        rows = new ArrayList<>();
        graphListWrapper = new ArrayList<>();
        parts = new ArrayList<>();
        uom = new ArrayList<>();

        template = new Template();
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() {


        periodType.setPeriods(periods);
        template.setUnitsOfMeasure(uom);
        template.setReferenceLists(referenceLists);
        template.setPeriodType(periodType);
        template.setDescription(description);
        template.setParts(parts);
     //   for (int i = 0; i < template.getUnitsOfMeasure().size(); i++) {
     //       System.out.println(String.valueOf(template.getUnitsOfMeasure().get(i).getId()));
     //   }
        System.out.println("End Document");
    }


    @Override
    public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attributes) {
        switch (qName) {
            case TABLES -> isTable = true;
            case GRAPH_PROGRAPH -> isGraph = true;
            case ROW_IN_TABLE -> isRows = true;
            case DEATH_GRAPH_CELL -> isCell = true;
        }
        //   System.out.printf("Start Element : %s%n", qName);
        if (qName.equals("DESCRIPTION")) {
            description.setTemplateId(Integer.parseInt(attributes.getValue("ID_FT")));

            description.setVersionNumber(Integer.parseInt(attributes.getValue("VER_NUMBER")));

        }

        if (qName.equals("PERIOD")) {
            period = new Period();
            period.setId(Integer.parseInt(attributes.getValue("ID_P")));

            periods.add(period);
        }


        if (isTable) {
            if (isRows) {
                if (qName.equals("row")) {
                    rl = new ReferenceList();
                    unitOfMeasureReference = new UnitOfMeasureReference();
                    if ((attributes.getValue("ID_UOM")) != null)
                        unitOfMeasureReference.setUnitOfMeasureId(Integer.parseInt(attributes.getValue("ID_UOM")));
                  //  rl.setFirstReferenceId(Integer.parseInt(attributes.getValue("ID_REF")));

                    rl.setUnitsOfMeasureReferences(unitOfMeasureReferences);
                    if ((attributes.getValue("ID_REFLST")) != null)
                        rl.setId(Integer.parseInt(attributes.getValue("ID_REFLST")));
System.out.println((attributes.getValue("ID_UOM"))+"   "+attributes.getValue("ID_REF")+"  "+attributes.getValue("ID_REFLST"));

                    referenceLists.add(rl);
                }
            }
            if (qName.equals("row")) {
                if (!isGraph && !isRows && !isCell) {
                    t = new TemplateTable();

                    t.setId(Integer.parseInt(attributes.getValue("ID_DTABLE")));
                    t.setNumber(Integer.parseInt(attributes.getValue("NUMBER_DTABLE")));
                    t.setName(attributes.getValue("NAME_DPART"));
                }
                if (isGraph) {
                    g = new TemplateGraph();
                    g.setId(Integer.parseInt(attributes.getValue("ID_DGP")));
                    g.setNumber(Integer.parseInt(attributes.getValue("NUMBER_DGP")));

                    if (!graphListWrapper.contains(g))
                        graphListWrapper.add(g);
                }
                if ((!(attributes.getValue("ID_UOM") == null))) {
                    unitOfMeasure = new UnitOfMeasure();
                    unitOfMeasure.setId(Integer.parseInt(attributes.getValue("ID_UOM")));
                    uom.add(unitOfMeasure);
                    //    System.out.println(attributes.getValue("ID_UOM"));
                }
                if (isRows && attributes.getValue("TYPE_ROW") != null) {
                    r = new TemplateRow();
                    r.setId(Integer.parseInt(attributes.getValue("ID_DROW")));
                    r.setCode(Integer.parseInt(attributes.getValue("CODE_DROW")));
                    if ((attributes.getValue("ID_REF")) != null)
                        unitOfMeasureReference.setStringBlockReferenceId(Integer.parseInt(attributes.getValue("ID_REF")));

                    r.setType(Integer.parseInt(attributes.getValue("TYPE_ROW")));
                    //System.out.println(attributes.getValue("ID_DROW"));
                  //  if (!rows.contains(r))
                        rows.add(r);
                    t.setRows(rows);
                    t.setGraphs(graphListWrapper);
                        table.add(t);
                }







                templatePart.setTables(table);

                parts.add(templatePart);

            }
        }
    }

    @Override
    public void endElement(String uri,
                           String localName,
                           String qName) {

        switch (qName) {
            case TABLES -> isTable = false;
            case GRAPH_PROGRAPH -> isGraph = false;
            case ROW_IN_TABLE -> isRows = false;
            case DEATH_GRAPH_CELL -> isCell = false;
        }
        //  for (TemplateTable templateTable : table) {System.out.println(templateTable.getNumber());
        //System.out.println();}

        // for (TemplateGraph templateGraph : graphListWrapper) System.out.println(templateGraph.getNumber());
        // for (TemplateRow templateRow : rows) System.out.println(templateRow.getCode());
        // for (TemplateTable templateTable : table) System.out.println(templateTable.getGraphs());
/*
      for (TemplateTable templateTable : table) {
            ArrayList<TemplateRow> tt = templateTable.getRows();
            System.out.println(tt.size());
        }
  */
        //   System.out.printf("End Element : %s%n", qName);


    }


}
