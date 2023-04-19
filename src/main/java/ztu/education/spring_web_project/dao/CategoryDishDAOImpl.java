package ztu.education.spring_web_project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ztu.education.spring_web_project.entity.CategoryDish;

import java.util.List;

@Repository
public class CategoryDishDAOImpl implements CategoryDishDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<CategoryDish> getAllCategoriesDish() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from CategoryDish", CategoryDish.class).getResultList();
    }

    public CategoryDish getCategoryDish(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(CategoryDish.class, id);
    }

    public CategoryDish findByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        return session
                .createQuery("from CategoryDish where name = :name", CategoryDish.class)
                .setParameter("name", name)
                .setMaxResults(1)
                .stream()
                .findFirst()
                .orElse(null);
    }

    public CategoryDish saveOrUpdateCategoryDish(CategoryDish categoryDish) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(categoryDish);

        return categoryDish;
    }

    public int deleteCategoryDish(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session
                .createQuery("delete from CategoryDish where id = :categoryDishID")
                .setParameter("categoryDishID", id)
                .executeUpdate();
    }
}
