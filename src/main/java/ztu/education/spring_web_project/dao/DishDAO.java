package ztu.education.spring_web_project.dao;

import ztu.education.spring_web_project.entity.Dish;

import java.util.List;

public interface DishDAO {
    List<Dish> getAllDishes();

    Dish getDish(int id);

    Dish saveOrUpdateDish(Dish dish);

    int deleteDish(int id);

    void deleteDish(Dish dish);
}
