package ztu.education.spring_web_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ztu.education.spring_web_project.dao.UserDAO;
import ztu.education.spring_web_project.dto.UserLoginDTO;
import ztu.education.spring_web_project.dto.UserRegisterDTO;
import ztu.education.spring_web_project.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public User register(UserRegisterDTO userRegisterDTO) {
        if (userDAO.findByEmail(userRegisterDTO.getEmail()) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Електронна адреса уже використовується");
        }

        if (userDAO.findByPhoneNumber(userRegisterDTO.getPhoneNumber()) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Номер телефону уже використовується");
        }

        User newUser = new User();

        newUser.setFullName(userRegisterDTO.getFullName());
        newUser.setPhoneNumber(userRegisterDTO.getPhoneNumber());
        newUser.setEmail(userRegisterDTO.getEmail());

        // add encrypt
        newUser.setPassword(userRegisterDTO.getPassword());

        return userDAO.saveOrUpdateUser(newUser);
    }

    @Transactional
    public User login(UserLoginDTO userLoginDTO) {
        User user = userDAO.findByEmail(userLoginDTO.getEmail());

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Неправильна електронна адреса або пароль");
        }

        if (!user.getPassword().equals(userLoginDTO.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Неправильна електронна адреса або пароль");
        }

        return user;
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
