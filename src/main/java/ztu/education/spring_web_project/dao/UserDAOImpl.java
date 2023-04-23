package ztu.education.spring_web_project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ztu.education.spring_web_project.entity.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public User findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();

        return session
                .createQuery("from User where email = :email", User.class)
                .setParameter("email", email)
                .setMaxResults(1)
                .stream()
                .findFirst()
                .orElse(null);
    }

    public User findByPhoneNumber(String phoneNumber) {
        Session session = sessionFactory.getCurrentSession();

        return session
                .createQuery("from User where phoneNumber = :phoneNumber", User.class)
                .setParameter("phoneNumber", phoneNumber)
                .setMaxResults(1)
                .stream()
                .findFirst()
                .orElse(null);
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from User", User.class).getResultList();
    }

    public User saveOrUpdateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);

        return user;
    }
}
