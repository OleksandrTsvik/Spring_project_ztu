package ztu.education.spring_web_project.dao;

import ztu.education.spring_web_project.entity.Admin;

import java.util.List;

public interface AdminDAO {
    Admin getAdmin(int id);

    Admin findByEmail(String email);

    List<Admin> getAllAdmins();

    Admin saveOrUpdateAdmin(Admin admin);

    int deleteAdmin(int id);
}
