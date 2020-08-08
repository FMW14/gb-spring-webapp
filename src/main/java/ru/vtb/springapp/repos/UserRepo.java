package ru.vtb.springapp.repos;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.vtb.springapp.domain.User;
import ru.vtb.springapp.util.HibernateUtil;

import java.util.List;

@AllArgsConstructor
@Component
@Scope("singleton") //prototype
public class UserRepo {
    @Autowired
    private HibernateUtil hibernateUtil;

    public User getById(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }

        Session session = null;
        User userFromDb;

        try {
            session = hibernateUtil.getSession();
            session.beginTransaction();
            userFromDb = session.get(User.class, id);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return userFromDb;
    }

    public List<User> getAll() {
        Session session = null;
        List<User> userList;

        try {
            session = hibernateUtil.getSession();
            session.beginTransaction();
            userList = hibernateUtil.getSession().createQuery("from User").list();
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return userList;
    }

    public void save(User user) {

        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }

        Session session = null;

        try {
            session = hibernateUtil.getSession();
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
