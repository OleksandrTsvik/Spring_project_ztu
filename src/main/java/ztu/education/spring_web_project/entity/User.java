package ztu.education.spring_web_project.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "phone_number", nullable = false, unique = true, length = 12)
    private String phoneNumber;

    @Column(name = "email", unique = true, length = 64)
    private String email;

    @Column(name = "address", length = 128)
    private String address;

    @Column(name = "password", nullable = false, length = 256)
    private String password;
}