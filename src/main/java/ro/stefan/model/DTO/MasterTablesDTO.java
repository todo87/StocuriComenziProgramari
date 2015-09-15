package ro.stefan.model.DTO;

import java.util.ArrayList;
import java.util.List;

public class MasterTablesDTO {
    private List<String> tables = new ArrayList<>();


    public List<String> getTables() {
        return tables;
    }

    public void setTables(List<String> tables) {
        this.tables = tables;
    }
}
