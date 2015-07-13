package ro.stefan.serv.interfaces;

import ro.stefan.model.Role;

public interface RoleService extends GenericService<Role,Long> {
    Role findByRole(String role);
}
