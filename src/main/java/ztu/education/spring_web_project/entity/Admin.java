package ztu.education.spring_web_project.entity;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", nullable = false, unique = true, length = 64)
    private String email;

    @Column(name = "password", nullable = false, length = 256)
    private String password;
}
