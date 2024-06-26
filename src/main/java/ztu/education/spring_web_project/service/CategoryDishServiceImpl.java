package ztu.education.spring_web_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ztu.education.spring_web_project.dao.CategoryDishDAO;
import ztu.education.spring_web_project.entity.CategoryDish;

import java.util.List;

@Service
public class CategoryDishServiceImpl implements CategoryDishService {
    @Autowired
    private CategoryDishDAO categoryDishDAO;

    @Override
    @Transactional
    public List<CategoryDish> getAllCategoriesDish() {
        return categoryDishDAO.getAllCategoriesDish();
    }

    @Override
    @Transactional
    public CategoryDish getCategoryDish(int id) {
        return categoryDishDAO.getCategoryDish(id);
    }

    @Override
    @Transactional
    public CategoryDish findByName(String name) {
        return categoryDishDAO.findByName(name);
    }

    @Override
    @Transactional
    public CategoryDish saveOrUpdateCategoryDish(CategoryDish categoryDish) {
        return categoryDishDAO.saveOrUpdateCategoryDish(categoryDish);
    }

    @Override
    @Transactional
    public int deleteCategoryDish(int id) {
        return categoryDishDAO.deleteCategoryDish(id);
    }
}
