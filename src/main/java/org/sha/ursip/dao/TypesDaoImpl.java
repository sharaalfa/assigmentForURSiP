package org.sha.ursip.dao;

import org.sha.ursip.model.Types;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TypesDaoImpl implements TypesDAO {



    private JdbcTemplate jdbcTemplate;


    public TypesDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Types> list() {
        String sql = "SELECT * FROM types";
        List<Types> listTypes = jdbcTemplate.query(sql, new RowMapper<Types>() {
            @Override
            public Types mapRow(ResultSet rs, int rowNum) throws SQLException {
                Types aTypes = new Types();
                aTypes.setId(rs.getInt("id"));
                aTypes.setName(rs.getString("name"));
                return aTypes;
            }
        });
        return listTypes;
    }


}
