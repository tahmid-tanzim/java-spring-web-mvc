package com.born2code.spring.web.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
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
    public void create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        session().save(user);
    }

    public boolean exists(String username) {

        /* JDBC */
//        return jdbc.queryForObject("SELECT COUNT(*) FROM users WHERE username=:username", new MapSqlParameterSource("username", username), Integer.class) > 0;

        /* Hibernate */
        Criteria criteria = session().createCriteria(User.class);
//        criteria.add(Restrictions.eq("username", username));
        criteria.add(Restrictions.idEq(username));

        User user = (User) criteria.uniqueResult();

        return user != null;
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        /* JDBC */
//        return jdbc.query("SELECT * FROM users", BeanPropertyRowMapper.newInstance(User.class));

        /* Hibernate */
        return session().createQuery("from User").list();
    }

    public User getUser(String username) {
        /* Hibernate */
        Criteria criteria = session().createCriteria(User.class);
        criteria.add(Restrictions.idEq(username));
        return (User) criteria.uniqueResult();
    }
}