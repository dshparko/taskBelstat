package dshparko.by.belstat.task.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class XmlTemplateData {

    public Map<String, String> description;
    public List<Map<String, String>> extAttr = new ArrayList<>();


    public List<Map<String, String>> parts = new ArrayList<>();
    public List<Map<String, String>> tables = new ArrayList<>();
    public List<Map<String, String>> graphs = new ArrayList<>();
    public List<Map<String, String>> rows = new ArrayList<>();

    public List<Map<String, String>> deathCells = new ArrayList<>();


    public Map<String, String> period;

}
