package ztu.education.spring_web_project.service;

import ztu.education.spring_web_project.dto.DishSaveDTO;
import ztu.education.spring_web_project.entity.Dish;

import java.io.IOException;
import java.util.List;

public interface DishService {
    List<Dish> getAllDishes();

    Dish getDish(int id);

    DishSaveDTO getDishSaveDTO(int id);

    Dish saveOrUpdateDish(DishSaveDTO dishDTO, String pathImagesDir) throws IOException;

    void deleteDish(int id, String pathImagesDir) throws IOException;
}
