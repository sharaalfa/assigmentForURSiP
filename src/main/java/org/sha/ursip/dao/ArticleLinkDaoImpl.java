package org.sha.ursip.dao;

import org.sha.ursip.model.ArticleLink;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by first on 28.08.17.
 */
public class ArticleLinkDaoImpl implements ArticleLinkDAO {
    private JdbcTemplate jdbcTemplate;


    public ArticleLinkDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ArticleLink> list() {
        String sql = "SELECT * FROM article_link";
        List<ArticleLink> articleLinks = jdbcTemplate.query(sql, new RowMapper<ArticleLink>() {
            @Override
            public ArticleLink mapRow(ResultSet rs, int rowNum) throws SQLException {
                ArticleLink articleLink = new ArticleLink();
                articleLink.setArticle1Id(rs.getInt("article1_id"));
                articleLink.setArticle2Id(rs.getInt("article2_id"));
                return articleLink;
            }
        });
        return articleLinks;
    }
}
