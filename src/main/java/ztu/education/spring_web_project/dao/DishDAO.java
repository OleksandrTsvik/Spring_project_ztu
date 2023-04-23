package ztu.education.spring_web_project.dao;

import ztu.education.spring_web_project.entity.Dish;

import java.util.List;

public interface DishDAO {
    Long getCountDishes();

    List<Dish> getAllDishes();

    List<Dish> getDishesByName(String name);

    List<Dish> getDishesByCategory(Integer categoryId);

    Dish getDish(int id);

    Dish saveOrUpdateDish(Dish dish);

    int deleteDish(int id);

    void deleteDish(Dish dish);
}
