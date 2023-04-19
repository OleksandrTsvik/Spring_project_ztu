package ztu.education.spring_web_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ztu.education.spring_web_project.dto.DishSaveDTO;
import ztu.education.spring_web_project.entity.Dish;
import ztu.education.spring_web_project.service.CategoryDishService;
import ztu.education.spring_web_project.service.DishService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class DishController {
    @Autowired
    private DishService dishService;
    @Autowired
    private CategoryDishService categoryDishService;

//    @RequestMapping("/dish")
//    public String dish() {
//        return "dish";
//    }

    // список страв по пошуку або за категорією
    @RequestMapping("/dishes")
    public String dishes(HttpServletRequest request, Model model) {
//    public String dishes(
//            @RequestParam("dishName") String dishName,
//            Model model
//    ) {
        String dishName = request.getParameter("dishName");

        model.addAttribute("dishes", dishService.getAllDishes());
        model.addAttribute("dishName", dishName);

        return "dishes";
    }

    @RequestMapping(value = "/admin/dish", method = RequestMethod.GET)
    public String saveDish(Model model) {
        model.addAttribute("dish", new DishSaveDTO());
        model.addAttribute("categoriesDish", categoryDishService.getAllCategoriesDish());

        return "formDish";
    }

    @RequestMapping(value = "/admin/dish", method = RequestMethod.POST)
    public String saveDish(
            @Valid @ModelAttribute("dish") DishSaveDTO dish,
            BindingResult bindingResult,
            Model model,
            HttpSession session
    ) {
        if (!bindingResult.hasErrors()) {
            String imagePath = session.getServletContext().getRealPath("/") + "resources\\images";

            System.out.println(imagePath);

            try {
                dishService.saveOrUpdateDish(dish, imagePath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            model.addAttribute("dishMessage", "Страву успішно збережено");
            model.addAttribute("dish", new DishSaveDTO());
        } else {
            model.addAttribute("dish", dish);
        }

        model.addAttribute("categoriesDish", categoryDishService.getAllCategoriesDish());

        return "formDish";
    }

    @RequestMapping(value = "/admin/dish/edit/{id}", method = RequestMethod.GET)
    public String editDish(@PathVariable("id") int id, Model model) {
        model.addAttribute("dish", dishService.getDishSaveDTO(id));
        model.addAttribute("categoriesDish", categoryDishService.getAllCategoriesDish());

        return "formDish";
    }

    @RequestMapping(value = "/admin/dish/delete/{id}", method = RequestMethod.GET)
    public String deleteDish(@PathVariable("id") int id, Model model) {
        model.addAttribute("deleteMessage", "Кількість видалених записів = " +
                dishService.deleteDish(id));
        model.addAttribute("dishes", dishService.getAllDishes());

        return "dishes";
    }
}
