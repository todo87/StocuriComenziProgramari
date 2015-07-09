package ro.stefan.serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.stefan.model.Users;
import ro.stefan.repo.UsersRepo;
import ro.stefan.serv.interfaces.UsersService;

@Service
@Transactional
public class UsersServiceImpl implements UsersService  //extends BaseService implements UsersService
{

    @Autowired
    private UsersRepo usersRepo;

//    @Autowired
//    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;
//
//    public UsersServiceImpl() {
//        super(Users.class);
//    }

    @Override
    public boolean findByLogin(String userName, String password) {
        Users users = usersRepo.findByUserName(userName);
        if(users != null){
            if(!users.getPassword().equals(password)){
                return false;
            }
        }else{
            return false;
        }
        return true;
    }

    @Override
    public Users findByUserName(String userName) {
        return usersRepo.findByUserName(userName);
    }
}
