package com.epam.web.entities;

public class User {

    private long id;
    private String email;
    private String password;
    private String name;
    private String lastname;
    private Role role;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(long id, String email, String password, String name, String lastname, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    private enum Role{
        ADMIN, CUSTOMER
    }

}
