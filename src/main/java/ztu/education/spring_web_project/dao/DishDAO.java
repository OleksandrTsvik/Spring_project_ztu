package ztu.education.spring_web_project.dao;

import ztu.education.spring_web_project.dto.DishSaveDTO;
import ztu.education.spring_web_project.entity.Dish;

import java.util.List;

public interface DishDAO {
    public List<Dish> getAllDishes();

    public Dish getDish(int id);

    public Dish saveOrUpdateDish(Dish dish);

    public int deleteDish(int id);
}
