package by.masarnovsky.dao.jdbc;

import by.masarnovsky.dao.ModuleDAO;
import by.masarnovsky.dao.rowmapper.ModuleRowMapper;
import by.masarnovsky.model.Module;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ModuleDAOJdbcImpl implements ModuleDAO {
    private JdbcTemplate jdbcTemplate;
    private final String GET_MODULES = "select * from modules";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Module> getModules() {
        return jdbcTemplate.query(GET_MODULES, new ModuleRowMapper());
    }
}
