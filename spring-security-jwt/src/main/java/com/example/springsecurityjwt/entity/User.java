package com.example.springsecurityjwt.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @Column(name = "username")
    private String userName;
    private String password, roles;
    private boolean enabled;
}
