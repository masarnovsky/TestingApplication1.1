package by.masarnovsky.dao.jdbc;

import by.masarnovsky.model.User;
import by.masarnovsky.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/appServlet-servlet.xml"})
public class UserDAOJdbcImplTest {

//    private final String LAST_ID = "select LAST_INSERT_ID()";
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Test
//    @Transactional
//    public void save(){
//        User user = new User("username", "surname", "email", "testLogin", "password");
//        userService.save(user);
//        int insertedId = jdbcTemplate.queryForObject(LAST_ID, Integer.class);
//        user.setId(insertedId);
////        User user2 = userService.getUserByLogin("testLogin");
////        assertEquals(user, user2);
//    }


    @Test
    public void getUsersCount() {

    }

}