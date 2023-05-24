package ztu.education.spring_web_project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ztu.education.spring_web_project.entity.Admin;

import java.util.List;

@Repository
public class AdminDAOImpl implements AdminDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Admin getAdmin(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Admin.class, id);
    }

    @Override
    public Admin findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();

        return session
                .createQuery("from Admin where email = :email", Admin.class)
                .setParameter("email", email)
                .setMaxResults(1)
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Admin> getAllAdmins() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Admin", Admin.class).getResultList();
    }

    @Override
    public Admin saveOrUpdateAdmin(Admin admin) {
        Session session = sessionFactory.getCurrentSession();

        session.clear();
        session.saveOrUpdate(admin);

        return admin;
    }

    @Override
    public int deleteAdmin(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session
                .createQuery("delete from Admin where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
