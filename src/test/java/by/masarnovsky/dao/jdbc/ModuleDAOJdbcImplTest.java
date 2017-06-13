package by.masarnovsky.dao.jdbc;

import by.masarnovsky.service.ModuleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class ModuleDAOJdbcImplTest {

    @Autowired
    ModuleService moduleService;

    @Test
    public void getModules() throws Exception {
        int modulesCount = 7;
        assertEquals(7, moduleService.getModules().size());
    }

}