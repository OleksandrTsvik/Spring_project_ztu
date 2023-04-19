package ztu.education.spring_web_project.service;

import ztu.education.spring_web_project.entity.CategoryDish;

import java.util.List;

public interface CategoryDishService {
    public List<CategoryDish> getAllCategoriesDish();

    public CategoryDish getCategoryDish(int id);

    public CategoryDish findByName(String name);

    public CategoryDish saveOrUpdateCategoryDish(CategoryDish categoryDish);

    public int deleteCategoryDish(int id);
}
