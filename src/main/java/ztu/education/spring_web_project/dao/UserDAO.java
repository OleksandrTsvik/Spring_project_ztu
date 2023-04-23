package ztu.education.spring_web_project.dao;

import ztu.education.spring_web_project.entity.User;

import java.util.List;

public interface UserDAO {
    User findByEmail(String email);

    User findByPhoneNumber(String phoneNumber);

    List<User> getAllUsers();

    User saveOrUpdateUser(User user);

    int deleteUser(int id);
}
