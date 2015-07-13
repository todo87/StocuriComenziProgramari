package ro.stefan.serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.stefan.model.Role;
import ro.stefan.repo.RoleRepo;
import ro.stefan.serv.interfaces.RoleService;

@Service
@Transactional
public class RoleServiceImpl extends GenericServiceImpl<Role,Long> implements RoleService {

    @Autowired
    RoleRepo roleRepo;

    public RoleServiceImpl() {
        super(Role.class);
    }

    @Override
    public Role findByRole(String role) {
        return roleRepo.findByRole(role);
    }
}
