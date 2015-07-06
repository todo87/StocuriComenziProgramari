package ro.stefan.serv.interfaces;

import ro.stefan.model.Users;

public interface UsersService {
    boolean findByLogin(String userName, String password);
    Users findByUserName(String userName);
}
