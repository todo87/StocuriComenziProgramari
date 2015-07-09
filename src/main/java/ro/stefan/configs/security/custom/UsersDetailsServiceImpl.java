package ro.stefan.configs.security.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ro.stefan.model.Users;
import ro.stefan.serv.interfaces.UsersService;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UsersService usersService;

    private UserCustom user;

    @Override
    public UserCustom loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersService.findByUserName(username);
        if (null != users){
            List<GrantedAuthority> authList = new ArrayList<>();
            authList.add(new SimpleGrantedAuthority("ROLE_" + users.getRole().getRole()));
            user = new UserCustom(
                    users.getUsername(),
                    users.getPassword(),
                    users.getEnabled(),
                    users.getAccNonExp(),
                    users.getCredNonExpired(),
                    users.getAccNonLocked(),
                    authList,
                    users.getId(),
                    users.getName(),
                    users.getSurname(),
                    users.getEmail(),
                    users.getRole(),
                    users.getCreatedAt(),
                    users.getCreatedBy(),
                    users.getModifiedAt(),
                    users.getModifiedBy(),
                    users.getUnit()
            );
        }
        return user;
    }
}
