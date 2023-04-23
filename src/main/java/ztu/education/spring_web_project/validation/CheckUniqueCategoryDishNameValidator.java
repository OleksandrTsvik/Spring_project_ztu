package ztu.education.spring_web_project.validation;

import org.springframework.beans.factory.annotation.Autowired;
import ztu.education.spring_web_project.service.CategoryDishService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckUniqueCategoryDishNameValidator implements ConstraintValidator<CheckUniqueCategoryDishName, String> {
    @Autowired
    private CategoryDishService categoryDishService;

    // Ініціалізація
    @Override
    public void initialize(CheckUniqueCategoryDishName constraintAnnotation) {
    }

    // Перевірка
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return categoryDishService.findByName(name) == null;
    }
}