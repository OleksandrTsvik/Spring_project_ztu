package ztu.education.spring_web_project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ztu.education.spring_web_project.entity.Dish;

import java.util.List;

@Repository
public class DishDAOImpl implements DishDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long getCountDishes() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select count(*) from Dish", Long.class).getSingleResult();
    }

    @Override
    public List<Dish> getAllDishes() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Dish", Dish.class).getResultList();
    }

    @Override
    public List<Dish> getDishesByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        return session
                // || - оператор конкатенації
                .createQuery("from Dish where name like '%' || :name || '%'", Dish.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public List<Dish> getDishesByCategory(Integer categoryId) {
        Session session = sessionFactory.getCurrentSession();

        return session
                .createQuery("from Dish where categoryDish.id = :categoryId", Dish.class)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    @Override
    public Dish getDish(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Dish.class, id);
    }

    @Override
    public Dish saveOrUpdateDish(Dish dish) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(dish);

        return dish;
    }

    @Override
    public int deleteDish(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session
                .createQuery("delete from Dish where id = :dishID")
                .setParameter("dishID", id)
                .executeUpdate();
    }

    @Override
    public void deleteDish(Dish dish) {
        Session session = sessionFactory.getCurrentSession();

        session.delete(dish);
    }
}
