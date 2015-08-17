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
        jdbc.update("insert into users (username, password, email, enabled) values (:username, :password, :email, :enabled)", params);
        // Authority Table insert
        return jdbc.update("insert into authorities (username, authority) values (:username, :authority)", params) == 1;
    }
}