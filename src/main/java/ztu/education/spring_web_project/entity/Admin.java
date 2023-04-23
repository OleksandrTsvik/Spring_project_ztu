package ztu.education.spring_web_project.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "admins")
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Введіть електронну пошту")
    @Size(max = 64, message = "Електронна адреса повинна містити не більше 64 символів")
    @Email(message = "Некоректна електронна адреса")
    @Column(name = "email", nullable = false, unique = true, length = 64)
    private String email;

    @NotBlank(message = "Введіть пароль")
    @Column(name = "password", nullable = false, length = 256)
    private String password;
}
