package com.example.sportyshoes.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;


    @OneToOne
    @JoinColumn(nullable = false)
    private RoleEntity permissionLevel;

    public UserEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
