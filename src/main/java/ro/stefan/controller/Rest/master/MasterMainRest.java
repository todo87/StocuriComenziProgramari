package ro.stefan.controller.Rest.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.stefan.model.DTO.MasterTablesDTO;
import ro.stefan.serv.interfaces.RoleService;
import ro.stefan.serv.interfaces.UnitService;
import ro.stefan.serv.interfaces.UsersService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/master")
public class MasterMainRest {

    @Autowired
    UnitService unitService;

    @Autowired
    RoleService roleService;

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/listOfTables", method = RequestMethod.POST)
    public MasterTablesDTO getListOfTables(){
        List<String> tables = new ArrayList<>();
        tables.add("unit");
        tables.add("role");
        tables.add("users");

        MasterTablesDTO masterTablesDTO = new MasterTablesDTO();
        masterTablesDTO.setTables(tables);

        return masterTablesDTO;
    }

    @RequestMapping(value = "/tableData/{table}", method = RequestMethod.POST)
    public List getTablesData(@PathVariable String table){
        List list = null;
        switch (table){
            case "unit":
                list = unitService.findAll();
                break;
            case "role":
                list = roleService.findAll();
                break;
            case "users":
                list = usersService.findAll();
                break;
        }
        return list;
    }

}
