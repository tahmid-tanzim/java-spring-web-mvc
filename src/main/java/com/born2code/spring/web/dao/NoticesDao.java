package com.born2code.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("noticesDao")
public class NoticesDao {

    @Autowired
    private SessionFactory sessionFactory;

    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<Notice> getNotices() {

        /* JDBC */
//        return jdbc.query("SELECT * FROM notices, users WHERE notices.username = users.username AND users.enabled = true",
//                new NoticeRowMapper());

        /* Hibernate */
        Criteria criteria = session().createCriteria(Notice.class);
        criteria.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Notice> getNotices(String username) {

        /* JDBC */
//        return jdbc.query("SELECT * FROM notices, users WHERE notices.username = users.username AND users.enabled = true AND notices.username=:username",
//                new MapSqlParameterSource("username", username),
//                new NoticeRowMapper());

        /* Hibernate */
        Criteria criteria = session().createCriteria(Notice.class);
        criteria.createAlias("user", "u");
        criteria.add(Restrictions.eq("u.enabled", true));
        criteria.add(Restrictions.eq("u.username", username));
        return criteria.list();
    }

    public boolean delete(int id) {

        /* JDBC */
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("id", id);
//
//        return jdbc.update("DELETE FROM notices WHERE id = :id", params) == 1;

        /* Hibernate */
        Query query = session().createQuery("delete from Notice where id = :id");
        query.setLong("id", id);
        return query.executeUpdate() == 1;

    }

    public void update(Notice notice) {

        /* JDBC */
//        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(notice);
//
//        return jdbc.update("UPDATE notices SET text=:text WHERE id=:id", params) == 1;

        /* Hibernate */
        session().update(notice);
    }

    public void create(Notice notice) {

        /* JDBC */
//        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(notice);
//        return jdbc.update("INSERT INTO notices (username, text) VALUES (:username, :text)", params) == 1;

        /* Hibernate */
        session().save(notice);
    }

    /**
     * Merging Both Create & Update
     */
    public void saveOrUpdate(Notice notice) {
        session().saveOrUpdate(notice);
    }

    public int[] create(List<Notice> notices) {

        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(notices.toArray());

        return jdbc.batchUpdate("INSERT INTO notices (username, text) VALUES (:username, :text)", params);
    }


    public Notice getNotice(int id) {
        /* JDBC */
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("id", id);
//
//        return jdbc.queryForObject("SELECT * FROM notices, users WHERE notices.username = users.username AND users.enabled = true AND id = :id",
//                params, new NoticeRowMapper());

        /* Hibernate */
        Criteria criteria = session().createCriteria(Notice.class);
        criteria.createAlias("user", "u");
        criteria.add(Restrictions.eq("u.enabled", true));
        criteria.add(Restrictions.idEq(id));
        return (Notice) criteria.uniqueResult();
    }

}