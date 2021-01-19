package ru.ifmo.se.springweb.models;

import javax.persistence.*;

@Entity
@Table(name = "point_users")
public class User {
    @Id
    @Column(nullable = false, unique = true)
    private String username;
    private String password;

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}