package ro.stefan.serv.interfaces;

import ro.stefan.model.BaseEntity;
import ro.stefan.model.Users;

import java.io.Serializable;

public interface UsersService extends GenericService<Users,Long> {
    boolean findByLogin(String userName, String password);
    Users findByUserName(String userName);
}
