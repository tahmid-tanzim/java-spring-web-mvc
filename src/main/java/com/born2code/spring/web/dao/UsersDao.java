package com.born2code.spring.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Component("usersDao")
public class UsersDao {

    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    @Transactional
    public boolean create(User user) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
        // User Table insert
        jdbc.update("INSERT INTO users (username, password, email, enabled) VALUES (:username, :password, :email, :enabled)", params);
        // Authority Table insert
        return jdbc.update("INSERT INTO authorities (username, authority) VALUES (:username, :authority)", params) == 1;
    }

    public boolean exists(String username) {
        return jdbc.queryForObject("SELECT COUNT(*) FROM users WHERE username=:username", new MapSqlParameterSource("username", username), Integer.class) > 0;
    }
}