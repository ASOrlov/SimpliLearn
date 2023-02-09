package com.example.backend.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;

    @Column(nullable = false, name="phonenumber")
    private String phoneNumber;

    @Column(nullable = false, name = "pincode")
    private String pinCode;

    @OneToOne
    @JoinColumn(nullable = false)
    private RoleEntity role;

    public UserEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
