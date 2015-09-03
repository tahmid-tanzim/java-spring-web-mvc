package com.born2code.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

@Component("noticesDao")
public class NoticesDao {

    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    public List<Notice> getNotices() {

        return jdbc.query("SELECT * FROM notices, users WHERE notices.username = users.username AND users.enabled = true",
                new NoticeRowMapper());
    }

    public List<Notice> getNotices(String username) {

        return jdbc.query("SELECT * FROM notices, users WHERE notices.username = users.username AND users.enabled = true AND notices.username=:username",
                new MapSqlParameterSource("username", username),
                new NoticeRowMapper());
    }

    public boolean delete(int id) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbc.update("DELETE FROM notices WHERE id = :id", params) == 1;

    }

    public boolean update(Notice notice) {

        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(notice);

        return jdbc.update("UPDATE notices SET text=:text WHERE id=:id", params) == 1;
    }

    public int[] create(List<Notice> notices) {

        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(notices.toArray());

        return jdbc.batchUpdate("INSERT INTO notices (username, text) VALUES (:username, :text)", params);
    }


    public boolean create(Notice notice) {

        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(notice);

        return jdbc.update("INSERT INTO notices (username, text) VALUES (:username, :text)", params) == 1;
    }

    public Notice getNotice(int id) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbc.queryForObject("SELECT * FROM notices, users WHERE notices.username = users.username AND users.enabled = true AND id = :id",
                params, new NoticeRowMapper());
    }

}