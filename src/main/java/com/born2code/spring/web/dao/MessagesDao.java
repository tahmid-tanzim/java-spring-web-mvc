package com.born2code.spring.web.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@Component("messagesDao")
public class MessagesDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    public Message getMessage(int id) {
        Criteria criteria = session().createCriteria(Message.class);
        criteria.add(Restrictions.idEq(id));
        return (Message) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Message> getMessages() {
        Criteria criteria = session().createCriteria(Message.class);
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Message> getMessages(String username) {
        Criteria criteria = session().createCriteria(Message.class);
        criteria.add(Restrictions.eq("username", username));
        return criteria.list();
    }

    public void saveOrUpdate(Message Message) {
        session().saveOrUpdate(Message);
    }

    public boolean delete(int id) {
        Query query = session().createQuery("delete from Message where id = :id");
        query.setLong("id", id);
        return query.executeUpdate() == 1;
    }
}