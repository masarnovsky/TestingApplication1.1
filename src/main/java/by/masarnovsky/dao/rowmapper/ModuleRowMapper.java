package by.masarnovsky.dao.rowmapper;

import by.masarnovsky.model.Module;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ModuleRowMapper implements RowMapper<Module> {
    public Module mapRow(ResultSet resultSet, int i) throws SQLException {
        Module module = new Module(
                resultSet.getInt("id"),
                resultSet.getString("theme")
        );
        return module;
    }
}
