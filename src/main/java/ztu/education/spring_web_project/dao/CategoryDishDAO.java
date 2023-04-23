package ztu.education.spring_web_project.dao;

import ztu.education.spring_web_project.entity.CategoryDish;

import java.util.List;

public interface CategoryDishDAO {
    List<CategoryDish> getAllCategoriesDish();

    CategoryDish getCategoryDish(int id);

    CategoryDish findByName(String name);

    CategoryDish saveOrUpdateCategoryDish(CategoryDish categoryDish);

    int deleteCategoryDish(int id);
}
