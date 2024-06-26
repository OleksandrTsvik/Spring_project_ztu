package ztu.education.spring_web_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ztu.education.spring_web_project.dao.AdminDAO;
import ztu.education.spring_web_project.dto.AdminSaveDTO;
import ztu.education.spring_web_project.entity.Admin;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AdminDAO adminDAO;

    @Override
    @Transactional
    public AdminSaveDTO getAdminSaveDTO(int id) {
        Admin admin = adminDAO.getAdmin(id);

        if (admin == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        AdminSaveDTO adminSaveDTO = new AdminSaveDTO();

        adminSaveDTO.setId(admin.getId());
        adminSaveDTO.setEmail(admin.getEmail());

        return adminSaveDTO;
    }

    @Override
    @Transactional
    public Admin findByEmail(String email) {
        return adminDAO.findByEmail(email);
    }

    @Override
    @Transactional
    public Admin register(AdminSaveDTO adminSaveDTO) {
        Admin adminById = null;
        if (adminSaveDTO.getId() != null) {
            adminById = adminDAO.getAdmin(adminSaveDTO.getId());
        }

        if (
                (adminById != null && !adminById.getEmail().equals(adminSaveDTO.getEmail())) &&
                        adminDAO.findByEmail(adminSaveDTO.getEmail()) != null
        ) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Електронна адреса уже використовується");
        }

        Admin newAdmin = new Admin();

        newAdmin.setId(adminSaveDTO.getId());
        newAdmin.setEmail(adminSaveDTO.getEmail());
        newAdmin.setPassword(bCryptPasswordEncoder.encode(adminSaveDTO.getPassword()));

        return adminDAO.saveOrUpdateAdmin(newAdmin);
    }

    @Override
    @Transactional
    public Admin login(Admin admin) {
        Admin adminByEmail = adminDAO.findByEmail(admin.getEmail());

        if (adminByEmail == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Неправильна електронна адреса або пароль");
        }

        if (!bCryptPasswordEncoder.matches(admin.getPassword(), adminByEmail.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Неправильна електронна адреса або пароль");
        }

        return adminByEmail;
    }

    @Override
    @Transactional
    public Admin login(String email, String password) {
        return this.login(new Admin(email, password));
    }

    @Override
    @Transactional
    public List<Admin> getAllAdmins() {
        return adminDAO.getAllAdmins();
    }

    @Override
    @Transactional
    public int deleteAdmin(int id) {
        Admin admin = adminDAO.getAdmin(id);

        if (admin != null && admin.getEmail().equals("admin@gmail.com")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Неможливо видалити головного адміністратора");
        }

        return adminDAO.deleteAdmin(id);
    }
}
