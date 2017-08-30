package org.sha.ursip.dao;

import org.sha.ursip.model.Articles;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by first on 28.08.17.
 */
public class ArticlesDaoImpl implements ArticlesDAO {
    private JdbcTemplate jdbcTemplate;

    public ArticlesDaoImpl(DataSource dataSource) {jdbcTemplate = new JdbcTemplate(dataSource);}
    @Override
    public List<Articles> list() {
        String sql = "SELECT * FROM articles";
        List<Articles> articlesList = jdbcTemplate.query(sql, new RowMapper<Articles>() {
            @Override
            public Articles mapRow(ResultSet resultSet, int i) throws SQLException {
                Articles articles = new Articles();
                articles.setId(resultSet.getInt("id"));
                articles.setName(resultSet.getString("name"));
                articles.setTypeid(resultSet.getInt("typeid"));
                return articles;
            }
        });
        return articlesList;
    }
}
