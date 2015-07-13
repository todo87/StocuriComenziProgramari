package ro.stefan.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.stefan.configs.configs.app.TestAppConfig;
import ro.stefan.model.Users;
import ro.stefan.serv.interfaces.RoleService;
import ro.stefan.serv.interfaces.UnitService;
import ro.stefan.serv.interfaces.UsersService;

import javax.validation.constraints.AssertTrue;
import java.util.List;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppConfig.class)
public class UsersTest {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UnitService unitService;

    private Users users = new Users();

    @Before
    public void initInsert(){
        users.setCredNonExpired(true);
        users.setAccNonLocked(true);
        users.setAccNonExp(true);
        users.setEmail("12321");
        users.setEnabled(true);
        users.setName("asdada");
        users.setPassword("asda");
        users.setSurname("asdsada");
        users.setUsername("asdsada" + new Random().nextInt(100000));
        users.setCreatedBy("test");
        users.setRole(roleService.findByRole("MASTER"));
        users.setUnit(unitService.findByName("test"));

        users = usersService.save(users);
        assertNotNull(users.getId());
    }

    @Test
    public void findAll(){
        List<Users> list = usersService.findAll();
        assertTrue(list.size() != 0);
    }

    @Test
    public void findOneById(){
        Users users1 = usersService.findOne(users.getId());
        assertNotNull(users1);
        assertEquals(users1, users);
    }

    @Test
    public void updateByUser(){
        Users users1 = usersService.findOne(users.getId());
        users1.setPassword("changed_pass");
        Users users2 = usersService.save(users1);
        assertEquals(users1, users2);
    }

    @Test
    public void updateById(){
        Users users1 = usersService.findOne(users.getId());
        users1.setPassword("changed_pass");
        Users users2 = usersService.save(users1);
        assertEquals(users1,users2);
    }


    @After
    public void deleteById(){
        usersService.delete(users.getId());
        assertNull(usersService.findOne(users.getId()));
    }


}
