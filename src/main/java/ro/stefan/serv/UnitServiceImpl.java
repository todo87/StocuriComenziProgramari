package ro.stefan.serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.stefan.model.Unit;
import ro.stefan.repo.UnitRepo;
import ro.stefan.serv.interfaces.UnitService;

@Service
@Transactional
public class UnitServiceImpl extends GenericServiceImpl<Unit,Long> implements UnitService{

    @Autowired
    UnitRepo unitRepo;

    public UnitServiceImpl() {
        super(Unit.class);
    }

    @Override
    public Unit findByName(String name) {
        return unitRepo.findByName(name);
    }
}
