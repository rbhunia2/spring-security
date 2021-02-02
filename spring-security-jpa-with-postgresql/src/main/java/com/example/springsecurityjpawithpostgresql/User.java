package com.example.springsecurityjpawithpostgresql;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
