package com.born2code.spring.web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Transactional
@Component("usersDao")
public class UsersDao {

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @Transactional
    public boolean create(User user) {
//        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("username", user.getUsername());
        params.addValue("password", passwordEncoder.encode(user.getPassword()));
        params.addValue("email", user.getEmail());
        params.addValue("name", user.getName());
        params.addValue("enabled", user.isEnabled());
        params.addValue("authority", user.getAuthority());
        // User Table insert
        return jdbc.update("INSERT INTO users (username, password, email, enabled, name, authority) VALUES (:username, :password, :email, :enabled, :name, :authority)", params) == 1;
    }

    public boolean exists(String username) {
        return jdbc.queryForObject("SELECT COUNT(*) FROM users WHERE username=:username", new MapSqlParameterSource("username", username), Integer.class) > 0;
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
//        return jdbc.query("SELECT * FROM users", BeanPropertyRowMapper.newInstance(User.class));
        return session().createQuery("from User").list();
    }
}