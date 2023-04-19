package ztu.education.spring_web_project.service;

import ztu.education.spring_web_project.dto.DishSaveDTO;
import ztu.education.spring_web_project.entity.Dish;

import java.io.IOException;
import java.util.List;

public interface DishService {
    public List<Dish> getAllDishes();

    public Dish getDish(int id);

    public DishSaveDTO getDishSaveDTO(int id);

    public Dish saveOrUpdateDish(DishSaveDTO dishDTO, String imagePath) throws IOException;

    public int deleteDish(int id);
}
