package ztu.education.spring_web_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ztu.education.spring_web_project.dao.DishDAO;
import ztu.education.spring_web_project.dto.DishSaveDTO;
import ztu.education.spring_web_project.entity.Dish;
import ztu.education.spring_web_project.utils.Files;

import java.io.IOException;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishDAO dishDAO;

    @Transactional
    public List<Dish> getAllDishes() {
        return dishDAO.getAllDishes();
    }

    @Transactional
    public Dish getDish(int id) {
        return dishDAO.getDish(id);
    }

    @Transactional
    public DishSaveDTO getDishSaveDTO(int id) {
        Dish dish = this.getDish(id);
        DishSaveDTO dishSaveDTO = new DishSaveDTO();

        dishSaveDTO.setId(dish.getId());
        dishSaveDTO.setName(dish.getName());
        dishSaveDTO.setDescription(dish.getDescription());
        dishSaveDTO.setComponents(dish.getComponents());
        dishSaveDTO.setPrice(dish.getPrice());
        dishSaveDTO.setCategoryDish(dish.getCategoryDish());

        return dishSaveDTO;
    }

    @Transactional
    public Dish saveOrUpdateDish(DishSaveDTO dishDTO, String imagePath) throws IOException {
        String imageName = Files.uploadFile(dishDTO.getImage(), imagePath);

        Dish dish = new Dish();

        dish.setId(dishDTO.getId());
        dish.setName(dishDTO.getName());
        dish.setDescription(dishDTO.getDescription());
        dish.setComponents(dishDTO.getComponents());
        dish.setPrice(dishDTO.getPrice());
        dish.setImageName(imageName);

        return dishDAO.saveOrUpdateDish(dish);
    }

    @Transactional
    public int deleteDish(int id) {
        return dishDAO.deleteDish(id);
    }
}
