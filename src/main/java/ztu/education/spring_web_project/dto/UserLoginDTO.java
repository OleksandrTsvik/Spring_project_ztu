package ztu.education.spring_web_project.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserLoginDTO {
    @NotBlank(message = "Введіть електронну пошту")
    @Size(max = 64, message = "Електронна адреса повинна містити не більше 64 символів")
    @Email(message = "Некоректна електронна адреса")
    private String email;

    @NotBlank(message = "Введіть пароль")
    private String password;
}
