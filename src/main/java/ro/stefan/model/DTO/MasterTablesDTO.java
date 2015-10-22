package ro.stefan.model.DTO;

import java.util.ArrayList;
import java.util.List;

public class MasterTablesDTO {
    private List<String> tables = new ArrayList<>();
    private String selected;

    public List<String> getTables() {
        return tables;
    }

    public void setTables(List<String> tables) {
        this.tables = tables;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }
}
