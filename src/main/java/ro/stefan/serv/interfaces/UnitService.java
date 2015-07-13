package ro.stefan.serv.interfaces;

import ro.stefan.model.Unit;

public interface UnitService extends GenericService<Unit,Long> {
    Unit findByName(String name);
}
