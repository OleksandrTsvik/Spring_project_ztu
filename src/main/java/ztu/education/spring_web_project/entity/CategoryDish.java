package ztu.education.spring_web_project.entity;

import lombok.Data;
import lombok.ToString;
import ztu.education.spring_web_project.validation.CheckUniqueCategoryDishName;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "categories_dishes")
@Data
@ToString(exclude = {"dishes"})
public class CategoryDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Назва страви повинна містити до 128 символів")
    @Size(min = 2, max = 128, message = "Назва страви повинна містити хоча б 2 символи, а макс. - 128")
    @CheckUniqueCategoryDishName(message = "Введений каталог уже існує")
    @Column(name = "name", nullable = false, unique = true, length = 128)
    private String name;

    @OneToMany(mappedBy = "categoryDish", fetch = FetchType.EAGER)
    private List<Dish> dishes;
}